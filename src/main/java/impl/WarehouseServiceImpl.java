package impl;

import models.*;
import service.WarehouseService;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class WarehouseServiceImpl implements WarehouseService {

    @Override
    public void addProduct(Product product) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new Exception("Ошибка добавления продукта: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public void reserveProduct(int productId, int quantity) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Product product = session.get(Product.class, productId);
            if (product == null) throw new Exception("Продукт не найден");
            if (product.getQuantity() < quantity) throw new Exception("Недостаточно количества");
            product.setQuantity(product.getQuantity() - quantity);
            session.update(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void updateProduct(Product product) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Product existingProduct = session.get(Product.class, product.getId());
            if (existingProduct == null) throw new Exception("Продукт не найден");
            session.update(product);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new Exception("Ошибка обновления: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public void addClient(Client client) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(client);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new Exception("Ошибка добавления клиента: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public void updateClient(Client client) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Client existingClient = session.get(Client.class, client.getId());
            if (existingClient == null) throw new Exception("Клиент не найден");
            session.update(client);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new Exception("Ошибка обновления клиента: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public List<Client> getClients() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("FROM Client", Client.class).list();
        } finally {
            session.close();
        }
    }

    @Override
    public void addWarehouse(Warehouse warehouse) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(warehouse);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new Exception("Ошибка добавления склада: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Warehouse existingWarehouse = session.get(Warehouse.class, warehouse.getId());
            if (existingWarehouse == null) throw new Exception("Склад не найден");
            session.update(warehouse);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new Exception("Ошибка обновления склада: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteWarehouse(int warehouseId) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Warehouse warehouse = session.get(Warehouse.class, warehouseId);
            if (warehouse == null) throw new Exception("Склад не найден");
            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM ProductMovement pm WHERE pm.logistics.id = :id", Long.class);
            query.setParameter("id", warehouseId);
            long count = query.getSingleResult();
            if (count > 0) throw new Exception("Удаление склада с товарами запрещено");
            session.delete(warehouse);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<ProductMovement> getProductHistory(int productId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("FROM ProductMovement WHERE product.id = :id", ProductMovement.class)
                    .setParameter("id", productId)
                    .list();
        } finally {
            session.close();
        }
    }

    @Override
    public void addProductMovement(ProductMovement movement) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(movement);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new Exception("Ошибка добавления движения: " + e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public void updateProductMovement(ProductMovement movement) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            ProductMovement existingMovement = session.get(ProductMovement.class, movement.getId());
            if (existingMovement == null) throw new Exception("Движение не найдено");
            session.update(movement);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new Exception("Ошибка обновления движения: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}