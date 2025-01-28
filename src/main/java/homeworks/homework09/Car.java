package homeworks.homework09;

import java.util.Objects;

public class Car {
    private String model;
    private String mark;
    private int year;
    private int power;
    private int boost;
    private int pendant;
    private int durability;


    public Car () {

    }

    public Car(String model, String mark, int year, int power, int boost, int pendant, int durability) {
        this.model = model;
        this.mark = mark;
        this.year = year;
        this.power = power;
        this.boost = boost;
        this.pendant = pendant;
        this.durability = durability;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getBoost() {
        return boost;
    }

    public void setBoost(int boost) {
        this.boost = boost;
    }

    public int getPendant() {
        return pendant;
    }

    public void setPendant(int pendant) {
        this.pendant = pendant;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && power == car.power && boost == car.boost && pendant == car.pendant && durability == car.durability && Objects.equals(model, car.model) && Objects.equals(mark, car.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, mark, year, power, boost, pendant, durability);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", mark='" + mark + '\'' +
                ", year=" + year +
                ", power=" + power +
                ", boost=" + boost +
                ", pendant=" + pendant +
                ", durability=" + durability +
                '}';
    }
}
