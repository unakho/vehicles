package org.za.assets.dto.base;

import java.io.Serializable;

/**
 * @author unakho.kama
 */
public class IdDto implements Serializable {

    private Long id;

    public IdDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
