package org.za.assets.dto.base;

/**
 * @author unakho.kama
 */
public class NameDto extends IdDto {

    private String name;

    public NameDto(Long id, String name) {
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
