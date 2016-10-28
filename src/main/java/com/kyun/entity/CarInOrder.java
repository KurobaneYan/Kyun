package com.kyun.entity;

import javax.persistence.*;

@Entity
@Table(name = "car_in_order", schema = "kyundb")
public class CarInOrder {
    private int id;
    private int amount;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarInOrder that = (CarInOrder) o;

        return id == that.id && amount == that.amount;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + amount;
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
