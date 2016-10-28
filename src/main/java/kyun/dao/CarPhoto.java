package kyun.dao;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by Yan Kurobane on 28/10/2016.
 */
@Entity
@Table(name = "car_photo", schema = "kyundb", catalog = "")
public class CarPhoto {
    private int id;
    private byte[] photo;
    private String description;
    private int carId;
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

    @Basic
    @Column(name = "car_id")
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarPhoto carPhoto = (CarPhoto) o;

        if (id != carPhoto.id) return false;
        if (carId != carPhoto.carId) return false;
        if (!Arrays.equals(photo, carPhoto.photo)) return false;
        if (description != null ? !description.equals(carPhoto.description) : carPhoto.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Arrays.hashCode(photo);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + carId;
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
