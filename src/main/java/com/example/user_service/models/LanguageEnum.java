package global.govstack.user_service.models;

import com.fasterxml.jackson.annotation.JsonFormat;
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LanguageEnum {

    ENGLISH(1, "English"),
    FRENCH(2, "French"),
    SWAHILI(3, "Swahili"),
    LUGANDA(4, "Luganda");

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
