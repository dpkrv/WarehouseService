package impl;

import models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.WarehouseService;

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
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void reserveProduct(int productId, int quantity) throws Exception {
        // Логика бронирования
    }

    @Override
    public void updateProduct(Product product) throws Exception {
        // Логика обновления
    }

    @Override
    public void addClient(Client client) throws Exception {
        // Логика добавления клиента
    }

    @Override
    public void updateClient(Client client) throws Exception {
        // Логика обновления клиента
    }

    @Override
    public List<Client> getClients() {
        // Логика получения клиентов
        return null;
    }

    @Override
    public void addWarehouse(String location) throws Exception {
        // Логика добавления склада
    }

    @Override
    public void deleteWarehouse(String location) throws Exception {
        throw new Exception("Удаление склада запрещено");
    }

    @Override
    public List<Product> getProductHistory(int productId) {
        // Логика получения истории
        return null;
    }
}