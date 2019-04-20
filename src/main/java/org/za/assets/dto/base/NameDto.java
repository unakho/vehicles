package org.za.assets.dto.base;

import java.util.UUID;

/**
 * @author unakho.kama
 */
public class NameDto extends BaseDto {


    private String name;

    public NameDto(UUID id, String name) {
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
