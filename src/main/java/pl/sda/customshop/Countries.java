package pl.sda.customshop;

import lombok.Getter;

@Getter
public enum Countries {

    POLAND("PL", "POLSKA"),
    USA("US", "STANY ZJEDNOCZONE"),
    FRANCE("FR", "FRANCJA");

    private final String symbol;
    private final String countryName;

    Countries(String symbol, String countryName) {
        this.symbol = symbol;
        this.countryName = countryName;
    }

}
