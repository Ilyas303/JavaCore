package homeworks.homework09;

import java.util.Arrays;

public class PerformanceCar extends Car{


    private String[] addOns;

    public PerformanceCar() {
        super();
        this.addOns = new String[0];
    }

    public PerformanceCar(String model,String mark,int year,int power,int boost,int pendant,int durability,String[] addOns){
        super(model,mark,year,power,boost,pendant,durability);
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
        return "PerformanceCar{" +
                "addOns=" + Arrays.toString(addOns) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PerformanceCar that = (PerformanceCar) o;
        return Arrays.equals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(addOns);
        return result;
    }
}
