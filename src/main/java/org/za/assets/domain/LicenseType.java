package org.za.assets.domain;

import org.za.assets.domain.base.BaseEntity;
import org.za.assets.dto.LicenseTypeDto;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author unakho.kama
 */
@Entity
@Table(schema = "assets_schema", name = "license_type")
public class LicenseType extends BaseEntity {

    private String code;

    @OneToMany//(mappedBy = "licence_type_id")
    private List<License> licenses;

    /*
     * JPA wants an explicity definition of a default construct on the entity
     */
    public LicenseType() {
    }

    private LicenseType(UUID id, String code) {
        super(id);
        setCode(code);
    }

    private String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    /*public List<License> getLicenses() {
        return licenses;
    }*/

    /*public void setLicenses(List<License> licenses) {
        this.licenses = licenses;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LicenseType)) return false;
        LicenseType that = (LicenseType) o;
        return Objects.equals(getCode(), that.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }

    /*
     * @param dto
     * @return LicenceType
     * This method is used by services
     * @link LicenceTypeServiceImpl
     */
    public LicenseType mapTo(LicenseTypeDto dto) {
        if (dto == null)
            throw new RuntimeException("LicenseType dto is null");

        return new LicenseType(dto.getId(), dto.getCode());
    }

    /*
     * @param licenseType
     * @return dto
     * This method is used by services
     * @link LicenceTypeServiceImpl
     */
    public LicenseTypeDto mapFrom(LicenseType licenseType) {

        if (licenseType == null)
            throw new RuntimeException("LicenseType entity is null");

        return new LicenseTypeDto(licenseType.getId(), licenseType.getCode());
    }
}
