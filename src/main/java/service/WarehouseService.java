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
    void addWarehouse(String location) throws Exception;
    void deleteWarehouse(String location) throws Exception;
    List<Product> getProductHistory(int productId);
}