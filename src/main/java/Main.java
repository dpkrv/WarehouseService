import impl.WarehouseServiceImpl;
import models.*;
import service.WarehouseService;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WarehouseService service = new WarehouseServiceImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Добавить продукт");
            System.out.println("2. Забронировать продукт");
            System.out.println("3. Обновить продукт");
            System.out.println("4. Добавить клиента");
            System.out.println("5. Обновить клиента");
            System.out.println("6. Показать клиентов");
            System.out.println("7. Добавить склад");
            System.out.println("8. Обновить склад");
            System.out.println("9. Удалить склад");
            System.out.println("10. Показать историю продукта");
            System.out.println("11. Добавить движение товара");
            System.out.println("12. Обновить движение товара");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Название: ");
                        String pName = scanner.nextLine();
                        System.out.print("Категория: ");
                        String pCategory = scanner.nextLine();
                        System.out.print("Количество: ");
                        int pQuantity = scanner.nextInt();
                        service.addProduct(new Product(pName, pCategory, pQuantity));
                        System.out.println("Продукт добавлен");
                        break;
                    case 2:
                        System.out.print("ID продукта: ");
                        int rProductId = scanner.nextInt();
                        System.out.print("Количество: ");
                        int rQuantity = scanner.nextInt();
                        service.reserveProduct(rProductId, rQuantity);
                        System.out.println("Продукт забронирован");
                        break;
                    case 3:
                        System.out.print("ID продукта: ");
                        int uProductId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Новое название: ");
                        String uName = scanner.nextLine();
                        System.out.print("Новая категория: ");
                        String uCategory = scanner.nextLine();
                        System.out.print("Новое количество: ");
                        int uQuantity = scanner.nextInt();
                        Product updatedProduct = new Product(uName, uCategory, uQuantity);
                        updatedProduct.setId(uProductId);
                        service.updateProduct(updatedProduct);
                        System.out.println("Продукт обновлен");
                        break;
                    case 4:
                        scanner.nextLine();
                        System.out.print("Имя клиента: ");
                        String cName = scanner.nextLine();
                        System.out.print("Контакты: ");
                        String cContact = scanner.nextLine();
                        service.addClient(new Client(cName, cContact));
                        System.out.println("Клиент добавлен");
                        break;
                    case 5:
                        System.out.print("ID клиента: ");
                        int uClientId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Новое имя: ");
                        String uCName = scanner.nextLine();
                        System.out.print("Новые контакты: ");
                        String uCContact = scanner.nextLine();
                        Client updatedClient = new Client(uCName, uCContact);
                        updatedClient.setId(uClientId);
                        service.updateClient(updatedClient);
                        System.out.println("Клиент обновлен");
                        break;
                    case 6:
                        List<Client> clients = service.getClients();
                        clients.forEach(c -> System.out.println(c.getId() + ": " + c.getName()));
                        break;
                    case 7:
                        scanner.nextLine();
                        System.out.print("Местоположение склада: ");
                        String wLocation = scanner.nextLine();
                        service.addWarehouse(new Warehouse(wLocation));
                        System.out.println("Склад добавлен");
                        break;
                    case 8:
                        System.out.print("ID склада: ");
                        int uWarehouseId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Новое местоположение: ");
                        String uWLocation = scanner.nextLine();
                        Warehouse updatedWarehouse = new Warehouse(uWLocation);
                        updatedWarehouse.setId(uWarehouseId);
                        service.updateWarehouse(updatedWarehouse);
                        System.out.println("Склад обновлен");
                        break;
                    case 9:
                        System.out.print("ID склада: ");
                        int dWarehouseId = scanner.nextInt();
                        service.deleteWarehouse(dWarehouseId);
                        System.out.println("Склад удален");
                        break;
                    case 10:
                        System.out.print("ID продукта: ");
                        int hProductId = scanner.nextInt();
                        List<ProductMovement> history = service.getProductHistory(hProductId);
                        history.forEach(m -> System.out.println(m.getMovementDate()));
                        break;
                    case 11:
                        System.out.print("ID продукта: ");
                        int mProductId = scanner.nextInt();
                        System.out.print("ID логистики: ");
                        int mLogisticsId = scanner.nextInt();
                        System.out.print("ID клиента: ");
                        int mClientId = scanner.nextInt();
                        Product product = new Product();
                        product.setId(mProductId);
                        Logistics logistics = new Logistics();
                        logistics.setId(mLogisticsId);
                        Client client = new Client();
                        client.setId(mClientId);
                        service.addProductMovement(new ProductMovement(product, logistics, client, new Date()));
                        System.out.println("Движение добавлено");
                        break;
                    case 12:
                        System.out.print("ID движения: ");
                        int uMovementId = scanner.nextInt();
                        ProductMovement updatedMovement = new ProductMovement();
                        updatedMovement.setId(uMovementId);
                        service.updateProductMovement(updatedMovement);
                        System.out.println("Движение обновлено");
                        break;
                    case 0:
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Неверный выбор");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}