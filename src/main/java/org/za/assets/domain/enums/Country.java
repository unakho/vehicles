package org.za.assets.domain.enums;

/**
 * @author unakho.kama
 */
public enum Country {

    SOUTH_AFRICA(1, "sa"),
    LESOTHO(2, "lesotho"),
    SWAZILAND(3, "swazil"),
    ZIMBABWE(4, "zim"),
    SOMALIA(5, "somal"),
    TANZANIA(6, "tanzania"),
    NAMIBIA(7, "nam"),
    GHANA(8, "gha"),
    MALAWI(9, ""),
    UGANDA(10, "ugan"),
    NIGERIA(11, "nig"),
    EGYPT(12, "egypt"),
    ENGLAND(13, "eng"),
    USA(14, "usa"),
    RUSSIA(15, "rus");

    private int id;
    private String abbr;

    Country(int id, String abbr) {
        this.id = id;
        this.abbr = abbr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }
}
