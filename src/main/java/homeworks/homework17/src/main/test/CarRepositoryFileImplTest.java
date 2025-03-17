import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryFileImplTest {
    private CarRepository repository;

    @BeforeEach
    void setUp() {
        repository = new CarRepositoryFileImpl();
        repository.deleteAll();
    }

    @Test
    void testCreateAndFindById() {
        Car car = new Car("Toyota", "Corolla", 2020, 150, 9, 7, 200);
        repository.create(car);

        Car foundCar = repository.findById("Toyota");
        assertEquals(car, foundCar);
    }

    @Test
    void testUpdateCar() {
        Car car = new Car("Toyota", "Corolla", 2020, 150, 9, 7, 200);
        repository.create(car);

        car.setPower(200);
        repository.update(car);

        Car updatedCar = repository.findById("Toyota");
        assertEquals(200, updatedCar.getPower());
    }

    @Test
    void testDeleteById() {
        Car car = new Car("Toyota", "Corolla", 2020, 150, 9, 7, 200);
        repository.create(car);

        repository.deleteById("Toyota");
        assertThrows(RuntimeException.class, () -> repository.findById("Toyota"));
    }
}