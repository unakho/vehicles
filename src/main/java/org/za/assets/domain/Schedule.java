package org.za.assets.domain;

import org.za.assets.domain.base.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author unakho.kama
 */
@Entity
@Table(name = "tschedule")
public class Schedule extends IdEntity {

    @Column(name = "scheduled_date")
    private Timestamp date;

    @OneToMany(mappedBy = "schedule")
    private List<Route> routes;

    public Schedule() {
    }

    public Schedule(Long id, Timestamp date, List<Route> routes) {
        super(id);
        this.date = date;
        this.routes = routes;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
