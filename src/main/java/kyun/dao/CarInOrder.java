package kyun.dao;

import javax.persistence.*;

/**
 * Created by Yan Kurobane on 28/10/2016.
 */
@Entity
@Table(name = "car_in_order", schema = "kyundb", catalog = "")
public class CarInOrder {
    private int id;
    private int amount;
    private int fkCar;
    private int fkOrder;
    private Car carByFkCar;
    private Order orderByFkOrder;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "fk_car")
    public int getFkCar() {
        return fkCar;
    }

    public void setFkCar(int fkCar) {
        this.fkCar = fkCar;
    }

    @Basic
    @Column(name = "fk_order")
    public int getFkOrder() {
        return fkOrder;
    }

    public void setFkOrder(int fkOrder) {
        this.fkOrder = fkOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarInOrder that = (CarInOrder) o;

        if (id != that.id) return false;
        if (amount != that.amount) return false;
        if (fkCar != that.fkCar) return false;
        if (fkOrder != that.fkOrder) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + amount;
        result = 31 * result + fkCar;
        result = 31 * result + fkOrder;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fk_car", referencedColumnName = "id", nullable = false)
    public Car getCarByFkCar() {
        return carByFkCar;
    }

    public void setCarByFkCar(Car carByFkCar) {
        this.carByFkCar = carByFkCar;
    }

    @ManyToOne
    @JoinColumn(name = "fk_order", referencedColumnName = "id", nullable = false)
    public Order getOrderByFkOrder() {
        return orderByFkOrder;
    }

    public void setOrderByFkOrder(Order orderByFkOrder) {
        this.orderByFkOrder = orderByFkOrder;
    }
}
