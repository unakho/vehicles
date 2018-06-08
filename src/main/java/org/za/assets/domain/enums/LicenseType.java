package org.za.assets.domain.enums;

/**
 * @author unakho.kama
 */
public enum LicenseType {

    BIKE("001"),
    MOTOR("002"),
    TRUCK("003"),
    HEAVY("004");

    private String code;

    LicenseType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
