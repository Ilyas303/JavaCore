package homeworks.homework14;


import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private double money;
    private List<Product> shoppingCart = new ArrayList<>();


    public Person(){}

    public Person(String name, double money) {
        this.name = name;
        this.money = money;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else {
            this.name = name;
        }
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        } else {
            this.money = money;
        }
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
            System.out.println(name + " не   может позволить себе " + product.getName());
            if (shoppingCart.isEmpty()){
                System.out.println("Ничего не куплено");
            }
        }
    }

    @Override
    public String toString() {
        if (shoppingCart.isEmpty()) {
            return name + " Ничего не куплено";
        } else {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", money=" + money +
                    ", shoppingCart=" + shoppingCart +
                    '}';
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (Double.compare(person.money, money) != 0) return false;
        if (!name.equals(person.name)) return false;
        return shoppingCart.equals(person.shoppingCart);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(money);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + shoppingCart.hashCode();
        return result;
    }
}