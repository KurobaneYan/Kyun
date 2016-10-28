package kyun.dao;

import javax.persistence.*;

/**
 * Created by Yan Kurobane on 28/10/2016.
 */
@Entity
@Table(name = "user_role", schema = "kyundb", catalog = "")
public class UserRole {
    private int id;
    private int fkUser;
    private int fkRole;
    private User userByFkUser;
    private Role roleByFkRole;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fk_user")
    public int getFkUser() {
        return fkUser;
    }

    public void setFkUser(int fkUser) {
        this.fkUser = fkUser;
    }

    @Basic
    @Column(name = "fk_role")
    public int getFkRole() {
        return fkRole;
    }

    public void setFkRole(int fkRole) {
        this.fkRole = fkRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (id != userRole.id) return false;
        if (fkUser != userRole.fkUser) return false;
        if (fkRole != userRole.fkRole) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fkUser;
        result = 31 * result + fkRole;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "id", nullable = false)
    public User getUserByFkUser() {
        return userByFkUser;
    }

    public void setUserByFkUser(User userByFkUser) {
        this.userByFkUser = userByFkUser;
    }

    @ManyToOne
    @JoinColumn(name = "fk_role", referencedColumnName = "id", nullable = false)
    public Role getRoleByFkRole() {
        return roleByFkRole;
    }

    public void setRoleByFkRole(Role roleByFkRole) {
        this.roleByFkRole = roleByFkRole;
    }
}
