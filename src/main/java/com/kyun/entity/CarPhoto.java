package com.kyun.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "car_photo", schema = "kyundb")
public class CarPhoto {
    private int id;
    private byte[] photo;
    private String description;
    private Car carByCarId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "photo")
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarPhoto carPhoto = (CarPhoto) o;

        if (id != carPhoto.id) return false;
        if (!Arrays.equals(photo, carPhoto.photo)) return false;
        return description != null ? description.equals(carPhoto.description) : carPhoto.description == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Arrays.hashCode(photo);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    public Car getCarByCarId() {
        return carByCarId;
    }

    public void setCarByCarId(Car carByCarId) {
        this.carByCarId = carByCarId;
    }
}
