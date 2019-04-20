package org.za.assets.domain;

import org.za.assets.domain.base.BaseEntity;
import org.za.assets.domain.enums.Choice;
import org.za.assets.dto.LicenseDto;
import org.za.assets.service.utils.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author unakho.kama
 */
@Entity
@Table(schema = "assets_schema", name = "license")
public class License extends BaseEntity {

    @Column(name = "acquired_date")
    private Timestamp acquiredDate;

    @Column(name = "expiry_date")
    private Timestamp expiryDate;

    @Column(name = "has_pdp")
    private byte hasPdp = (byte) Choice.NO.getId();

    @Column(name = "tickets_charged")
    private Integer ticketsCharged;

    @ManyToOne
    @JoinColumn(name = "license_type_id")
    private LicenseType licenseType;

    @OneToOne(mappedBy = "license")
    private User user;

    /*
     * JPA wants an explicity definition of a default construct on the entity
     */
    public License() {
    }

    private License(UUID id, Timestamp acquiredDate, Timestamp expiryDate,
                   byte hasPdp, Integer ticketsCharged, LicenseType licenseType) {
        super(id);
        setAcquiredDate(acquiredDate);
        setExpiryDate(expiryDate);
        setHasPdp(hasPdp);
        setTicketsCharged(ticketsCharged);
        setLicenseType(licenseType);
    }

    private Timestamp getAcquiredDate() {
        return acquiredDate;
    }

    private void setAcquiredDate(Timestamp acquiredDate) {
        this.acquiredDate = acquiredDate;
    }

    private Timestamp getExpiryDate() {
        return expiryDate;
    }

    private void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    private byte getHasPdp() {
        return hasPdp;
    }

    private void setHasPdp(byte hasPdp) {
        this.hasPdp = hasPdp;
    }

    private Integer getTicketsCharged() {
        return ticketsCharged;
    }

    private void setTicketsCharged(Integer ticketsCharged) {
        this.ticketsCharged = ticketsCharged;
    }

    private LicenseType getLicenseType() {
        return licenseType;
    }

    private void setLicenseType(LicenseType licenseType) {
        this.licenseType = licenseType;
    }

    public User getUser() {
        return user;
    }

    /*private void setUser(User user) {
        this.user = user;
    }*/

    /*
     * @param dto
     * @return licence entity
     * This method is used by services
     * @link LicenceServiceImpl
     */
    public License mapTo(LicenseDto dto) {

        if (dto == null)
            throw new RuntimeException("License is null");

        LocalDateTimeAttributeConverter ldtac = new LocalDateTimeAttributeConverter();

        return new License(dto.getId(), ldtac.convertToDatabaseColumn(dto.getAcquiredDate()),
                ldtac.convertToDatabaseColumn(dto.getExpiryDate()), dto.getChoice(),  dto.getTicketsCharged(),
                new LicenseType().mapTo(dto.getLicenseType()));
    }

    /*
     * @param license
     * @return dto
     * This method is used by services
     * @link LicenceServiceImpl
     */
    public LicenseDto mapFrom(License license) {

        if (license == null)
            throw new RuntimeException("License is null");

        LocalDateTimeAttributeConverter ldtac = new LocalDateTimeAttributeConverter();

        return new LicenseDto(license.getId(), ldtac
                .convertToEntityAttribute(license.getAcquiredDate()),
                ldtac.convertToEntityAttribute(license.getExpiryDate()),
                license.getHasPdp(), license.getTicketsCharged(), new LicenseType()
                .mapFrom(license.getLicenseType()));
    }
}
