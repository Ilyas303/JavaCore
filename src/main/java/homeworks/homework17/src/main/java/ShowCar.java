import lombok.*;
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class ShowCar extends Car {

    private int stars;

    public ShowCar() {
        super();
        this.stars = 0;
    }
    public ShowCar(String model, String mark, int year, int power, int boost, int pendant, int durability, int stars) {
        super(model, mark, year, power, boost, pendant, durability);
        this.stars = stars;
    }
}