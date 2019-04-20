package org.za.assets.domain;

import org.za.assets.domain.base.BaseEntity;
import org.za.assets.dto.TypesDto;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
@Entity
@Table(schema = "assets_schema", name = "types")
public class Types extends BaseEntity {

    private String description;

    @Column(name = "cell_number")
    private String cellNumber;

    private String deleted;
    private String type;

    @OneToMany
    private List<Profile> profiles;

    /*
     * JPA wants an explicity definition of a default construct on the entity
     */
    public Types() {
    }

    private Types(UUID id, String description, String cellNumber, String deleted,
                 String type) {
        super(id);
        setDescription(description);
        setCellNumber(cellNumber);
        setDeleted(deleted);
        setType(type);
    }

    private String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private String getCellNumber() {
        return cellNumber;
    }

    private void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    private String getDeleted() {
        return deleted;
    }

    private void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    private String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    /*
     * @param dto
     * @return types entity
     * This method is used by services that are related with Types entity
     * @link TypesServiceImpl
     */
    public Types mapTo(TypesDto dto) {

        if (dto == null)
            throw new RuntimeException("Types dto is null!");

        return new Types(dto.getId(), dto.getDescription(), dto.getCellNumber(), dto.getType(), dto.getDeleted());
    }

    /*
     * @param types
     * @return types dto
     * This method is used by services that are related with Types entity
     * @link TypesServiceImpl
     */
    public TypesDto mapFrom(Types types) {

        if (types == null)
            throw new RuntimeException("Types entity is null!");

        return new TypesDto(types.getId(), types.getDescription(),
                types.getCellNumber(), types.getType(), types.getDeleted());
    }
}
