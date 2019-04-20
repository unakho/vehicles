package org.za.assets.dto;

import org.za.assets.dto.base.BaseDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author unakho.kama
 */
public class LicenseTypeDto extends BaseDto {

    private String code;
    private List<LicenseDto> licenses;

    public LicenseTypeDto(UUID id, String code) {
        super(id);
        this.code = code;
    }

    public LicenseTypeDto(UUID id, String code, List<LicenseDto> licenses) {
        super(id);
        this.code = code;
        this.licenses = licenses;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<LicenseDto> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<LicenseDto> licenses) {
        this.licenses = licenses;
    }
}
