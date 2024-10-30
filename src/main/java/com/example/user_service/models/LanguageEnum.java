package com.example.user_service.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public enum LanguageEnum {

    ENGLIGH(1, "English"),
    FRENCH(2, "French"),
    SWAHILI(3, "Swahili"),
    LUGANDA(4, "Uganda");

    private final int id;
    private final String name;

    LanguageEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static LanguageEnum getById(int id) {
        for (LanguageEnum lang : values()) {
            if (lang.getId() == id) {
                return lang;
            }
        }
        throw new IllegalArgumentException("No lang with id " + id);
    }
}
