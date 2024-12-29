package homeworks.homework03;

public class Television {
    private String model;
    private Integer price;
    private Integer diagonal;

    public Television(String model, Integer price, Integer diagonal) {
        this.diagonal = diagonal;
        this.price = price;
        this.model = model;
    }

    public Television() {
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setprice(Integer price) {
        this.price = price;
    }

    public void setDiagonal(Integer diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "homework3.Television{" +
                "model='" + model + '\'' +
                ", price=" + price +
                ", diagonal=" + diagonal +
                '}';
    }
}

