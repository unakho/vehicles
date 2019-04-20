package org.za.assets.dto;

import org.za.assets.dto.base.BaseDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
public class TypesDto extends BaseDto {

    private String description;
    private String cellNumber;
    private String deleted;
    private String type;
    private List<ProfileDto> profiles;

    public TypesDto(UUID id, String description, String cellNumber, String deleted,
                    String type) {
        super(id);
        this.description = description;
        this.cellNumber = cellNumber;
        this.deleted = deleted;
        this.type = type;
    }

    public TypesDto(UUID id, String description, String cellNumber, String deleted,
                    String type, List<ProfileDto> profiles) {
        super(id);
        this.description = description;
        this.cellNumber = cellNumber;
        this.deleted = deleted;
        this.type = type;
        this.profiles = profiles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ProfileDto> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileDto> profiles) {
        this.profiles = profiles;
    }
}
