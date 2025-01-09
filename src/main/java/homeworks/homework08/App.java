package homeworks.homework08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        String inputFile = "src/main/java/homeworks/homework08/data.txt";
        String outputFile = "src/main/java/homeworks/homework08/result.txt";


        List<Person> customers = new ArrayList<>();
        Map<String, Product> productCatalog = new HashMap<>();
        List<String> actions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;

            // Чтение данных о покупателях
            line = reader.readLine();
            if (line != null) {
                String[] customersData = line.split(";");
                for (String customerData : customersData) {
                    customerData = customerData.trim();
                    String[] details = customerData.split("=");
                    if (details.length != 2) {
                        System.out.println("Некорректные данные покупателя: " + customerData);
                        continue;
                    }
                    String name = details[0].trim();
                    try {
                        double money = Double.parseDouble(details[1].trim());
                        customers.add(new Person(name, money));
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка преобразования денег: " + customerData);
                    }
                }
            }

            // Чтение данных о продуктах
            line = reader.readLine();
            if (line != null) {
                String[] productData = line.split(";");
                for (String productInfo : productData) {
                    productInfo = productInfo.trim();
                    String[] details = productInfo.split("=");
                    if (details.length != 2) {
                        System.out.println("Некорректные данные продукта: " + productInfo);
                        continue;
                    }
                    String name = details[0].trim();
                    try {
                        double price = Double.parseDouble(details[1].trim());
                        productCatalog.put(name, new Product(name, price));
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка преобразования цены: " + productInfo);
                    }
                }
            }

            // Чтение действий
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.equals("END")) {
                    break;
                }
                actions.add(line);
            }

            // Обработка действий
            for (String action : actions) {
                String[] details = action.split(" ");
                if (details.length < 2) {
                    System.out.println("Некорректная строка действия: " + action);
                    continue;
                }
                String customerName = details[0] + " " + details[1];
                String productName = details.length > 2 ? action.substring(customerName.length()).trim() : "";

                Person customer = customers.stream()
                        .filter(c -> c.getName().equals(customerName))
                        .findFirst()
                        .orElse(null);
                Product product = productCatalog.get(productName);

                if (customer != null && product != null) {
                    customer.addProduct(product);
                } else {
                    System.out.println("Действие невозможно: " + action);
                }
            }

            // Запись результатов в файл
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                for (Person customer : customers) {
                    writer.write(customer.toString());
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}