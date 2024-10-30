package com.example.user_service.models;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CountyEnum {

    MOMBASA(1, "Mombasa"),
    KWALE(2, "Kwale"),
    KILIFI(3, "Kilifi"),
    LAMU(4, "Lamu"),
    MANDERA(5, "Mandera");

    private final int id;
    private final String name;

    CountyEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static CountyEnum getByName(String countyName) {
        for (CountyEnum countyEnum : CountyEnum.values()) {
            if (countyEnum.getName().equalsIgnoreCase(countyName)) {
                return countyEnum;
            }
        }
        throw new IllegalArgumentException("No county found with name: " + countyName);
    }

}
