package homeworks.homework14;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProductTest {

    @Test
    void testProductCreation() {
        Product product = new Product();
        product.setName("Хлеб");
        product.setPrice(1);

        assertEquals("Хлеб", product.getName());
        assertEquals(1, product.getPrice());
    }

    @Test
    void testProductNegativePrice() {
        Product product = new Product();
        product.setPrice(1);

        assertNotEquals(-1.0, product.getPrice());
    }


    @ParameterizedTest
    @ValueSource(strings = {"молоко", "вода", "чипсы"})
    void testProductName(String name) {
        Product product = new Product();
        product.setName(name);
        assertEquals(name, product.getName());
    }

    @ParameterizedTest
    @ValueSource(doubles = {10, 20, 30})
    void testProductPrice(double price) {
        Product product = new Product();
        product.setPrice(price);
        assertEquals(price, product.getPrice());
    }

    @Disabled
    @Test
    void testIgnored() {
        Product product = new Product();
        product.setName("яблоко");
        assertEquals("яблоко", product.getName());
    }
}
