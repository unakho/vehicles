package org.za.assets.domain;

import org.za.assets.domain.base.BaseEntity;
import org.za.assets.dto.ProfileDto;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author unakho.kama
 */
@Entity
@Table(schema = "assets_schema", name = "profile")
public class Profile extends BaseEntity {

    private String value;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "types_id")
    private Types types;

    /*
     * JPA wants an explicity definition of a default construct on the entity
     */
    public Profile() {
    }

    Profile(UUID id, String value) {
        super(id);
        this.value = value;
    }

    private Profile(UUID id, String value, Types types) {
        super(id);
        this.value = value;
        this.types = types;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    /*
     * @param dto
     * @return profile entity
     * This method is used by services that are related with Profile entity
     * @link ProfileServiceImpl
     */
    public Profile mapTo(ProfileDto dto) {

        if (dto == null)
            throw new RuntimeException("Profile entity is null!");

        return new Profile(dto.getId(), dto.getValue(), this.getTypes().mapTo(dto.getTypes()));
    }

    /*
     * @param license
     * @return dto
     * This method is used by services that are related with Profile entity
     * @link LicenceServiceImpl
     */
    public ProfileDto mapFrom(Profile profile) {

        if (profile == null)
            throw new RuntimeException("Profile entity is null!");

        return new ProfileDto(profile.getId(), profile.getValue(),null, null);
    }
}
