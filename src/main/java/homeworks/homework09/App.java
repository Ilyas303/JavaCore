package homeworks.homework09;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Car car1 = new Car("Toyota", "Corolla", 2020, 150, 9, 7, 200);
        PerformanceCar raceCar = new PerformanceCar("Ferrari", "F8", 2023, 500, 8, 5, 300, new String[]{"Spoiler", "Turbo"});
        ShowCar showCar = new ShowCar("Lamborghini", "Aventador", 2023, 700, 5, 10, 250, 5);


        Garage garage = new Garage();
        garage.addCar(car1);
        garage.addCar(raceCar);
        garage.addCar(showCar);


        for (Car car : garage.getParkedCars()) {
            System.out.println(car);
        }


        List<Car> participants = new ArrayList<>();
        participants.add(car1);
        participants.add(raceCar);
        Race race = new Race.CasualRace(500,"пустыня",20000,participants);
        System.out.println(race);
    }
}