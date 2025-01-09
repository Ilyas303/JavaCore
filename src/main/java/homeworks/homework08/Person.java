package homeworks.homework08;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private double money;
    private List<Product> shoppingCart = new ArrayList<>();

    public Person(String name, double money) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя покупателя не может быть пустым.");
        }
        if (money < 0) {
            throw new IllegalArgumentException("Количество денег у покупателя не может быть отрицательным.");
        }
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void addProduct(Product product) {
        if (money >= product.getPrice()) {
            shoppingCart.add(product);
            money -= product.getPrice();
            System.out.println(name + " купил " + product.getName());
        } else {
            System.out.println(name + " не может позволить себе " + product.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" - ");
        if (shoppingCart.isEmpty()) {
            sb.append("Ничего не куплено");
        } else {
            for (Product p : shoppingCart) {
                sb.append(p.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2); // Удаление последней запятой и пробела
        }
        return sb.toString();
    }
}