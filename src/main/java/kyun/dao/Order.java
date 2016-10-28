package kyun.dao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Yan Kurobane on 28/10/2016.
 */
@Entity
public class Order {
    private int id;
    private BigDecimal cast;
    private Date date;
    private int fkUser;
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

    @Basic
    @Column(name = "fk_user")
    public int getFkUser() {
        return fkUser;
    }

    public void setFkUser(int fkUser) {
        this.fkUser = fkUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (fkUser != order.fkUser) return false;
        if (cast != null ? !cast.equals(order.cast) : order.cast != null) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cast != null ? cast.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + fkUser;
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
