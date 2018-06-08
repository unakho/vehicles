package org.za.assets.domain.enums;

/**
 * @author unakho.kama
 */
public enum Gender {

    MALE(1, "male"),
    FEMALE(2, "female");

    private int id;
    private String name;

    Gender(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
