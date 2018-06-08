package org.za.assets.domain;

import org.za.assets.domain.base.IdEntity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author unakho.kama
 */
@Entity
@Table(name = "tlicense")
public class License extends IdEntity {

    private String code;

    @Column(name = "expiry_date")
    private Timestamp expiryDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public License() {
    }

    public License(Long id, String code, Timestamp expiryDate, User user) {
        super(id);
        this.code = code;
        this.expiryDate = expiryDate;
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
