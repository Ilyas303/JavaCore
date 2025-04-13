import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.demo.service.ProductService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {
    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllProducts() {

        Product p1 = new Product(1L, "Product 1", 10.0);
        Product p2 = new Product(2L, "Product 2", 20.0);
        when(repository.findAll()).thenReturn(Arrays.asList(p1, p2));


        List<Product> products = service.getAllProducts();


        assertEquals(2, products.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void getProductById() {

        Product p = new Product(1L, "Product 1", 10.0);
        when(repository.findById(1L)).thenReturn(p);


        Product result = service.getProductById(1L);


        assertNotNull(result);
        assertEquals("Product 1", result.getName());
    }


}