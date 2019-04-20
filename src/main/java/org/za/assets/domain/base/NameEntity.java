package org.za.assets.domain.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * @author unakho.kama
 */
@MappedSuperclass
public class NameEntity extends BaseEntity {

    //@Column(name = "name")
    private String name;

    public NameEntity() {
    }

    public NameEntity(UUID id, String name) {
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
