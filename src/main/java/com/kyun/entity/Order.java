package com.kyun.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Order {
    private int id;
    private BigDecimal cast;
    private Date date;
    private Collection<CarInOrder> carInOrdersById;
    private User userByFkUser;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cast")
    public BigDecimal getCast() {
        return cast;
    }

    public void setCast(BigDecimal cast) {
        this.cast = cast;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (cast != null ? !cast.equals(order.cast) : order.cast != null) return false;
        return date != null ? date.equals(order.date) : order.date == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cast != null ? cast.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "orderByFkOrder")
    public Collection<CarInOrder> getCarInOrdersById() {
        return carInOrdersById;
    }

    public void setCarInOrdersById(Collection<CarInOrder> carInOrdersById) {
        this.carInOrdersById = carInOrdersById;
    }

    @ManyToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "id", nullable = false)
    public User getUserByFkUser() {
        return userByFkUser;
    }

    public void setUserByFkUser(User userByFkUser) {
        this.userByFkUser = userByFkUser;
    }
}
