package org.za.assets.dto;

import org.za.assets.dto.base.BaseDto;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author unakho.kama
 */
public class ProfileDto extends BaseDto {

    private String value;
    private UserDto user;
    private TypesDto types;

    public ProfileDto(UUID id, String value) {
        super(id);
        this.value = value;
    }

    public ProfileDto(UUID id, String value, UserDto user, TypesDto types) {
        super(id);
        this.value = value;
        this.user = user;
        this.types = types;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public TypesDto getTypes() {
        return types;
    }

    public void setTypes(TypesDto types) {
        this.types = types;
    }
}
