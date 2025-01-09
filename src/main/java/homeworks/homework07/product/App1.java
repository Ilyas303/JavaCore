package homeworks.homework07.product;

import java.time.LocalDate;

public class App1 {
    public static void main(String[] args) {

        // Создание обычного продукта
        Product product = new Product("Молоко", 50);
        System.out.println(product);

        // Создание скидочного продукта
        DiscountProduct discountProduct1 = new DiscountProduct("Сыр", 100, 20, LocalDate.of(2025, 12, 31), true);
        System.out.println(discountProduct1);

        // Создание продукта с ошибочным названием
        Product invalidProduct = new Product("12", 30);
        Product product2 = new Product("123",23);


    }
}