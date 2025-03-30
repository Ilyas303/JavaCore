import cars.Car;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Garage {

    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public void addCar(Car car) {
        parkedCars.add(car);
    }

    public void modifyCar(Car car) {

    }


}

