package org.za.assets.domain.enums;

/**
 * @author unakho.kama
 */
public enum Choice {

    NO(1, "no"),
    YES(2, "yes");

    private int id;
    private String abbr;

    Choice(int id, String abbr) {
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
