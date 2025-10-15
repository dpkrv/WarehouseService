package service;

import models.*;

import java.util.List;

public interface WarehouseService {
    void addProduct(Product product) throws Exception;
    void reserveProduct(int productId, int quantity) throws Exception;
    void updateProduct(Product product) throws Exception;
    void addClient(Client client) throws Exception;
    void updateClient(Client client) throws Exception;
    List<Client> getClients();
    void addWarehouse(Warehouse warehouse) throws Exception;
    void updateWarehouse(Warehouse warehouse) throws Exception;
    void deleteWarehouse(int warehouseId) throws Exception;
    List<ProductMovement> getProductHistory(int productId);
    void addProductMovement(ProductMovement movement) throws Exception;
    void updateProductMovement(ProductMovement movement) throws Exception;
}