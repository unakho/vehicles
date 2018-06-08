package org.za.assets.domain;

import org.za.assets.domain.base.NameEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author unakho.kama
 */
@Entity
@Table(name = "tvehicle")
public class Vehicle extends NameEntity {

    private String model;
    private String type;
    private String regNo;

    @OneToMany(mappedBy = "vehicle")
    private List<User> users;

    public Vehicle() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUser(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        return getRegNo().equals(vehicle.getRegNo());
    }

    @Override
    public int hashCode() {
        return getRegNo().hashCode();
    }
}
