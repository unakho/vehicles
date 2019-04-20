package org.za.assets.dto.base;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author unakho.kama
 */
public class BaseDto implements Serializable {

    private UUID id;

    public BaseDto(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
