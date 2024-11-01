package com.example.user_service.models;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CountyEnum {

    MOMBASA(1, "Mombasa"),
    KWALE(2, "Kwale"),
    KILIFI(3, "Kilifi"),
    TANA_RIVER(4, "Tana River"),
    LAMU(5, "Lamu"),
    TAITA_TAVETA(6, "Taita Taveta"),
    GARISSA(7, "Garissa"),
    WAJIR(8, "Wajir"),
    MANDERA(9, "Mandera"),
    MARSABIT(10, "Marsabit"),
    ISIOLO(11, "Isiolo"),
    MERU(12, "Meru"),
    THARAKA_NITHI(13, "Tharaka Nithi"),
    EMBU(14, "Embu"),
    KITUI(15, "Kitui"),
    MACHAKOS(16, "Machakos"),
    MAKUENI(17, "Makueni"),
    NYANDARUA(18, "Nyandarua"),
    NYERI(19, "Nyeri"),
    KIRINYAGA(20, "Kirinyaga"),
    MURANG_A(21, "Murang'a"),
    KIAMBU(22, "Kiambu"),
    TURKANA(23, "Turkana"),
    WEST_POKOT(24, "West Pokot"),
    SAMBURU(25, "Samburu"),
    TRANS_NZOIA(26, "Trans Nzoia"),
    UASIN_GISHU(27, "Uasin Gishu"),
    ELGEYO_MARAKWET(28, "Elgeyo Marakwet"),
    NANDI(29, "Nandi"),
    BARINGO(30, "Baringo"),
    LAIKIPIA(31, "Laikipia"),
    NAKURU(32, "Nakuru"),
    NAROK(33, "Narok"),
    KAJIADO(34, "Kajiado"),
    KERICHO(35, "Kericho"),
    BOMET(36, "Bomet"),
    KAKAMEGA(37, "Kakamega"),
    VIHIGA(38, "Vihiga"),
    BUNGOMA(39, "Bungoma"),
    BUSIA(40, "Busia"),
    SIAYA(41, "Siaya"),
    KISUMU(42, "Kisumu"),
    HOMA_BAY(43, "Homa Bay"),
    MIGORI(44, "Migori"),
    KISII(45, "Kisii"),
    NYAMIRA(46, "Nyamira"),
    NAIROBI(47, "Nairobi");

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

    public static CountyEnum getById(int countyId) {
        for (CountyEnum countyEnum : CountyEnum.values()) {
            if (countyEnum.getId() == countyId) {
                return countyEnum;
            }
        }
        throw new IllegalArgumentException("No county found with id: " + countyId);
    }


}
