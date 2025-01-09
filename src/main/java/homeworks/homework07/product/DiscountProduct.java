package homeworks.homework07.product;

import java.time.LocalDate;
import java.util.Objects;

public class DiscountProduct extends Product {

    private Integer discount;
    private LocalDate discountDate;
    private Boolean isdiscaunted;

    public DiscountProduct(Integer discount, LocalDate discountDate, Boolean isdiscaunted) {
        this.discount = discount;
        this.discountDate = discountDate;
        this.isdiscaunted = isdiscaunted;
    }

    public DiscountProduct(String name, double price, Integer discount, LocalDate discountDate, Boolean isdiscaunted) {
        super(name, price);
        this.discount = discount;
        this.discountDate = discountDate;
        this.isdiscaunted = isdiscaunted;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        if (discount <= 0 || discount > getPrice()) {
            System.out.println("Скидка должна быть положительной и не больше цены продукта.");
        } else {
            this.discount = discount;
        }
    }

    public LocalDate getDiscountDate() {

        return discountDate;
    }

    public void setDiscountDate(LocalDate discountDate) {
        if (discountDate == null || discountDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Срок действия скидки должен быть в будущем.");
        }

        this.discountDate = discountDate;
    }

    public double getPriceWithDiscount() {
        return getPrice() - discount;
    }

    // Проверка, актуальна ли скидка
    public boolean isDiscountValid() {
        return LocalDate.now().isBefore(discountDate);
    }

    public Boolean getIsdiscaunted() {
        return isdiscaunted;
    }

    public void setIsdiscaunted(Boolean isdiscaunted) {
        this.isdiscaunted = isdiscaunted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return Objects.equals(discount, that.discount) && Objects.equals(discountDate, that.discountDate) && Objects.equals(isdiscaunted, that.isdiscaunted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, discountDate, isdiscaunted);
    }

    @Override
    public String toString() {
        if (isDiscountValid()) {
            return "Скидочный продукт: " + getName() + ", Цена со скидкой: " + getPriceWithDiscount() + " руб., Скидка: " + discount + " руб., До: " + discountDate;
        } else {
            return "Скидочный продукт: " + getName() + ", Скидка неактуальна. Обычная цена: " + getPrice() + " руб.";
        }

    }
}