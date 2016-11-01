package com.kyun.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
public class Car {
    private int id;
    private String name;
    private String manufacturer;
    private int productionYear;
    private String carClass;
    private String bodyStyle;
    private BigDecimal price;
    private int amountLeft;
    private Collection<CarInOrder> carInOrdersById;
    private Collection<CarPhoto> carPhotosById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "production_year")
    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    @Basic
    @Column(name = "class")
    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    @Basic
    @Column(name = "body_style")
    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "amount_left")
    public int getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(int amountLeft) {
        this.amountLeft = amountLeft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (productionYear != car.productionYear) return false;
        if (amountLeft != car.amountLeft) return false;
        if (name != null ? !name.equals(car.name) : car.name != null) return false;
        if (manufacturer != null ? !manufacturer.equals(car.manufacturer) : car.manufacturer != null) return false;
        if (carClass != null ? !carClass.equals(car.carClass) : car.carClass != null) return false;
        return bodyStyle != null ? bodyStyle.equals(car.bodyStyle) : car.bodyStyle == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + productionYear;
        result = 31 * result + (carClass != null ? carClass.hashCode() : 0);
        result = 31 * result + (bodyStyle != null ? bodyStyle.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + amountLeft;
        return result;
    }

    @OneToMany(mappedBy = "carByFkCar")
    public Collection<CarInOrder> getCarInOrdersById() {
        return carInOrdersById;
    }

    public void setCarInOrdersById(Collection<CarInOrder> carInOrdersById) {
        this.carInOrdersById = carInOrdersById;
    }

    @OneToMany(mappedBy = "carByCarId")
    public Collection<CarPhoto> getCarPhotosById() {
        return carPhotosById;
    }

    public void setCarPhotosById(Collection<CarPhoto> carPhotosById) {
        this.carPhotosById = carPhotosById;
    }

    @Override
    public String toString() {
        return getId() + " " + getName() + " " + getManufacturer() + " " + getProductionYear() + " " + getCarClass()
                + " " + getBodyStyle() + " " + getPrice() + " " + getAmountLeft();
    }
}
