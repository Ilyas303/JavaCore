package homeworks.homework11;


import java.util.Objects;

public class Car {

    private String number;

    private String model;

    private String colour;

    private int mileage;

    private int price;

    public Car(String number, String model, String colour, int mileage, int price) {
        this.number = number;
        this.model = model;
        this.colour = colour;
        this.mileage = mileage;
        this.price = price;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return mileage == car.mileage && price == car.price && Objects.equals(number, car.number) && Objects.equals(model, car.model) && Objects.equals(colour, car.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, model, colour, mileage, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }
}
