package org.za.assets.domain;

import org.za.assets.domain.base.IdEntity;

import javax.persistence.*;

/**
 * @author unakho.kama
 */
@Entity
@Table(name = "troute")
public class Route extends IdEntity {

    @Column(name = "start_address")
    private String startAddress;

    @Column(name = "end_address")
    private String endAddress;

    private Double mileage;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Route() {
    }

    public Route(String startAddress, String endAddress, Double mileage, User user,
                 Schedule schedule) {

        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.mileage = mileage;
        this.user = user;
        this.schedule = schedule;
    }

    public Route(Long id, String startAddress, String endAddress, Double mileage, User user, Schedule schedule) {
        super(id);
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.mileage = mileage;
        this.user = user;
        this.schedule = schedule;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User vehicle) {
        this.user = vehicle;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
