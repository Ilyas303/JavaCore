package homeworks.homework09;

import java.util.ArrayList;
import java.util.List;

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

    public List<Car> getParkedCars() {
        return parkedCars;
    }
}

