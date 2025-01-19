package homeworks.homework06;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Person> persons = new ArrayList<>();


        while (true) {
            System.out.println("Введите название продукта или 'END' для окончания: ");
            String productName = scanner.nextLine();
            if (productName.equalsIgnoreCase("END")) {
                break;
            }

            System.out.println("Введите цену продукта");
            double productPrice = scanner.nextDouble();
            scanner.nextLine(); // Очистка буфера ввода

            Product product = new Product();
            product.setName(productName);
            product.setPrice(productPrice);
            products.add(product);

        }

        while (true) {
            System.out.println("введите имя покупателя или END для окончания ");
            String personName = scanner.nextLine();
            if (personName.equalsIgnoreCase("END")) {
                break;
            }
            System.out.println("введите сумму денег в кошельке ");
            double personMoney = scanner.nextDouble();
            scanner.nextLine(); // Очистка буфера ввода

            Person person = new Person();
            person.setName(personName);
            person.setMoney(personMoney);
            persons.add(person);
        }


        System.out.println("Начинаем покупку : ");


        String[] namePersons = new String[persons.size()];
        for (int i = 0; i < namePersons.length; i++) {
            namePersons[i] = persons.get(i).getName();
        }
        Random random = new Random();

        String[] nameProducts = new String[products.size()];

        for (int i = 0; i < nameProducts.length; i++) {
            nameProducts[i] = products.get(i).getName();
        }

        while (true) {
            System.out.println("для окончания покупки введитем END");
            String end = scanner.nextLine();
            if (end.equalsIgnoreCase("END")) {
                break;
            }


            //System.out.println("Введите имя покупателя или END для окончания: ");
            // String name = scanner.next();

            String name = namePersons[random.nextInt(0, namePersons.length)];


            String nameProduct = nameProducts[random.nextInt(0, nameProducts.length)];

            for (Person person : persons) {
                if (person.getName().equalsIgnoreCase(name)) {
                    //   System.out.println("Введите название продукта: ");
                    // String nameProduct = scanner.next();

                    for (Product product : products) {
                        if (product.getName().equalsIgnoreCase(nameProduct)) {
                            person.addProduct(product);
                        }
                    }
                }
            }
        }

        for (Person person : persons) {
            System.out.println(person);
        }


    }


}
