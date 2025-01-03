package homeworks.homework05;

import java.util.Objects;


public class telev {
    private String model;
    private Integer price;
    private Integer diagonal;
    private Integer channelNumber;
    private Integer volume;
    private boolean isOn;

    public telev(String model, Integer price, Integer diagonal, Integer channelNumber, Integer volume, boolean isOn) {
        this.diagonal = diagonal;
        this.price = price;
        this.model = model;
        this.channelNumber = channelNumber;
        this.volume = volume;
        this.isOn = isOn;

    }

    public telev() {
    }

    public telev(String model, int channelNumber, int volume, boolean isOn) {
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

    public void setisOn(boolean isOn) {
        this.isOn = isOn;
    }

    public void setChannelNumber(Integer channelNumber) {
        this.channelNumber = channelNumber;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }


    @Override
    public String toString() {
        return "telev{" +
                "model='" + model + '\'' +
                ", price=" + price +
                ", diagonal=" + diagonal +
                ", channelNumber=" + channelNumber +
                ", volume=" + volume +
                ", isOn=" + isOn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        telev telev = (telev) o;
        return isOn == telev.isOn && Objects.equals(model, telev.model) && Objects.equals(price, telev.price) && Objects.equals(diagonal, telev.diagonal) && Objects.equals(channelNumber, telev.channelNumber) && Objects.equals(volume, telev.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price, diagonal, channelNumber, volume, isOn);
    }

    public int getChannelNumber() {
        return channelNumber;
    }

    public int getVolume() {
        return volume ;
    }

    public boolean isOn() {
        return isOn;
    }
}




