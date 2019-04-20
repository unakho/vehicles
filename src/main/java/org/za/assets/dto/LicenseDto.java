package org.za.assets.dto;

import org.za.assets.domain.enums.Choice;
import org.za.assets.dto.base.BaseDto;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author unakho.kama
 */
public class LicenseDto extends BaseDto {

    private LocalDateTime acquiredDate;
    private LocalDateTime expiryDate;
    private byte choice;
    private Integer ticketsCharged;
    private LicenseTypeDto licenseType;

    public LicenseDto(UUID id, LocalDateTime acquiredDate, LocalDateTime expiryDate,
                      byte choice, Integer ticketsCharged) {
        super(id);
        this.acquiredDate = acquiredDate;
        this.expiryDate = expiryDate;
        this.choice = choice;
        this.ticketsCharged = ticketsCharged;
    }

    public LicenseDto(UUID id, LocalDateTime acquiredDate, LocalDateTime expiryDate,
                      byte choice, Integer ticketsCharged, LicenseTypeDto
                              licenseType) {
        super(id);
        this.acquiredDate = acquiredDate;
        this.expiryDate = expiryDate;
        this.choice = choice;
        this.ticketsCharged = ticketsCharged;
        this.licenseType = licenseType;
    }

    public LocalDateTime getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(LocalDateTime acquiredDate) {
        this.acquiredDate = acquiredDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public byte getChoice() {
        return choice;
    }

    public void setChoice(byte choice) {
        this.choice = choice;
    }

    public Integer getTicketsCharged() {
        return ticketsCharged;
    }

    public void setTicketsCharged(Integer ticketsCharged) {
        this.ticketsCharged = ticketsCharged;
    }

    public LicenseTypeDto getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(LicenseTypeDto licenseType) {
        this.licenseType = licenseType;
    }
}
