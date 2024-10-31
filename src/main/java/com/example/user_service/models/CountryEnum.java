package com.example.user_service.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CountryEnum {

    KENYA(1, "Kenya", List.of(LanguageEnum.ENGLISH, LanguageEnum.SWAHILI), List.of(CountyEnum.MOMBASA, CountyEnum.KWALE, CountyEnum.MANDERA)),
    UGANDA(2, "Uganda",List.of(LanguageEnum.ENGLISH, LanguageEnum.LUGANDA), List.of()),
    SOMALIA(3, "Somalia", List.of(LanguageEnum.ENGLISH, LanguageEnum.FRENCH), List.of());

    private final int id;
    private final String name;
    private final List<LanguageEnum> countryLanguages;
    private final List<CountyEnum> counties;

    CountryEnum(int id, String name, List<LanguageEnum> countryLanguages, List<CountyEnum> counties) {
        this.id = id;
        this.name = name;
        this.countryLanguages = countryLanguages;
        this.counties = counties;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<CountyEnum> getCounties() {
        return counties;
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

    public static CountryEnum getByName(String countryName) {
        for (CountryEnum country : CountryEnum.values()) {
            if (country.getName().equalsIgnoreCase(countryName)) {
                return country;
            }
        }
        throw new IllegalArgumentException("No county found with name: " + countryName);
    }

}
