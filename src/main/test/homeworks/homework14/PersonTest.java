package homeworks.homework14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testPersonCreation() {
        Person person = new Person();
        person.setName("Вова");
        person.setMoney(100.0);

        assertEquals("Вова", person.getName());
        assertEquals(100.0, person.getMoney());
    }

    @Test
    void testAddProduct() {
        Person person = new Person();
        person.setName("Вова");
        person.setMoney(100.0);

        Product product = new Product();
        product.setName("Хлеб");
        product.setPrice(1);

        person.addProduct(product);

        assertEquals(1, person.getShoppingCart().size());
        assertEquals(99, person.getMoney());
    }

    @Test
    void testNegativePersonMoney() {
        Person person = new Person();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            person.setMoney(-50.0);
        });
        assertEquals("Деньги не могут быть отрицательными", exception.getMessage());
    }



}