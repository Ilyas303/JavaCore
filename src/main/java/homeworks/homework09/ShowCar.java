package homeworks.homework09;


import java.util.Objects;

public class ShowCar extends Car {

    private int stars;

    public ShowCar() {
        super();
        this.stars = 0;
    }

    public ShowCar(String model,String mark,int year,int power,int boost,int pendant,int durability,int stars){
        super(model,mark,year,power,boost,pendant,durability);
        this.stars = stars;
    }


    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "ShowCar{" +
                "stars=" + stars +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShowCar showCar = (ShowCar) o;
        return stars == showCar.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }
}