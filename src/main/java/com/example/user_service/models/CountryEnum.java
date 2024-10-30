package com.example.user_service.models;

import java.util.List;

public enum CountryEnum {

    KENYA(1, "Kenya", List.of(LanguageEnum.ENGLIGH, LanguageEnum.SWAHILI)),
    UGANDA(2, "Uganda",List.of(LanguageEnum.ENGLIGH, LanguageEnum.SWAHILI, LanguageEnum.LUGANDA) ),
    SOMALIA(3, "Somalia", List.of(LanguageEnum.ENGLIGH, LanguageEnum.FRENCH));

    private final int id;
    private final String name;
    private final List<LanguageEnum> countryLanguages;

    CountryEnum(int id, String name, List<LanguageEnum> countryLanguages) {
        this.id = id;
        this.name = name;
        this.countryLanguages = countryLanguages;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<LanguageEnum> getCountryLanguages() {
        return countryLanguages;
    }

    public static CountryEnum getById(int id) {
        for (CountryEnum country : values()) {
            if (country.getId() == id) {
                return country;
            }
        }
        throw new IllegalArgumentException("No country with id " + id);
    }

}
