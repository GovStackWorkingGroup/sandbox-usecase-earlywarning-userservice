package com.example.user_service.models;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CommunicationChannelEnum {

    SMS(1, "SMS"),
    EMAIL(2, "EMAIL"),
    TELEGRAM(3, "TELEGRAM");

    private final int id;
    private final String name;

    CommunicationChannelEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static CommunicationChannelEnum getById(int id) {
        for (CommunicationChannelEnum comm : values()) {
            if (comm.getId() == id) {
                return comm;
            }
        }
        throw new IllegalArgumentException("No communication channel with id " + id);
    }
}
