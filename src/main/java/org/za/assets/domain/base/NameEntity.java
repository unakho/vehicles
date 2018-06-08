package org.za.assets.domain.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author unakho.kama
 */
@MappedSuperclass
public class NameEntity extends IdEntity {

    @Column(name = "first_names", length = 100)
    private String name;

    public NameEntity() {
    }

    public NameEntity(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
