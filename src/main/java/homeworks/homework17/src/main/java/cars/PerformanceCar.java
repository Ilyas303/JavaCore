package cars;

import java.util.Arrays;

public class PerformanceCar extends Car {

    private String[] addOns;

    public PerformanceCar() {
        super();
        this.addOns = new String[0];
    }
    public PerformanceCar(String model, String mark, int year, int power, int boost, int pendant, int durability, String[] addOns) {
        super(model, mark, year, power, boost, pendant, durability);
        this.addOns = addOns;
        this.setPower((int) (this.getPower() * 1.5));
        this.setPendant((int) (this.getPendant() * 0.75));
    }
    public String[] getAddOns() {
        return addOns;
    }

    public void setAddOns(String[] addOns) {
        this.addOns = addOns;
    }

    @Override
    public String toString() {
        return "cars.PerformanceCar{" +
                "model='" + getModel() + '\'' +
                ", mark='" + getMark() + '\'' +
                ", year=" + getYear() +
                ", power=" + getPower() +
                ", boost=" + getBoost() +
                ", pendant=" + getPendant() +
                ", durability=" + getDurability() +
                ", addOns=" + Arrays.toString(addOns) +
                '}';
    }
}