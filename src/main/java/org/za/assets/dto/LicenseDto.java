package org.za.assets.dto;

import org.za.assets.dto.base.IdDto;

import java.time.LocalDateTime;

/**
 * @author unakho.kama
 */
public class LicenseDto extends IdDto {

    private String code;
    private LocalDateTime expiryDate;
    private UserDto user;

    public LicenseDto(Long id, String code, LocalDateTime expiryDate) {
        super(id);
        this.code = code;
        this.expiryDate = expiryDate;
    }

    public LicenseDto(Long id, String code, LocalDateTime expiryDate, UserDto user) {
        super(id);
        this.code = code;
        this.expiryDate = expiryDate;
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
