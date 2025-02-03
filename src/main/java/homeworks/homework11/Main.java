package homeworks.homework11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();

        cars.add(new Car("a123me","Mercedes","White",0,8300000));
        cars.add(new Car("b873of","Volga","Black",0,673000));
        cars.add(new Car("w487mn","Lexus","Grey",76000,900000));
        cars.add(new Car("p987hj","Volga","Red",610,704340));
        cars.add(new Car("c987ss","Toyota","White",254000,761000));
        cars.add(new Car("o983op","Toyota","Black",698000,740000));
        cars.add(new Car("p146op","BMW","White",271000,850000));
        cars.add(new Car("u893ii","Toyota","Purple",210900,440000));
        cars.add(new Car("l097df","Toyota","Black",108000,780000));
        cars.add(new Car("y876wd","Toyota","Black",160000,1000000));


        int mileageToFind = 0;
        List<String> result1 = cars.stream()
                .filter(car ->car.getMileage() == mileageToFind)
                .map(Car::getNumber)
                .collect(Collectors.toList());
        System.out.println("Номера автомобилей с нулевым пробегом: " + result1);



        double n = 740000;
        double m = 1000000;
        long uniqueModelsCount = cars.stream()
                .filter(car -> car.getPrice() >= n && car.getPrice() <= m)
                .map(Car::getModel)
                .distinct()
                .count();
        System.out.println("Количество уникальных моделей в ценовом диапазоне от " + n + " до " + m + ": " + uniqueModelsCount);


    }
}
