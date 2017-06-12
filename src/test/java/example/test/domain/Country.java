package example.test.domain;

import java.util.*;

public class Country {
    private String name;

    private ArrayList<String> topLevelDomain;

    private String alpha2Code;

    private String alpha3Code;

    private ArrayList<String> callingCodes; // API returns array of strings not ints.

    private String capital;

    private ArrayList<String> altSpellings;

    private String relevance;

    private String region;

    private String subregion;

    private Long population;

    private ArrayList<Double> latlng; // The API response forces my hand here, latlng should probably be returned as an object not an array.

    private String demonym;

    private Double area;

    private Double gini;

    private ArrayList<TimeZone> timezones;

    private ArrayList<String> borders;

    private String nativeName;

    private String numericCode;

    private ArrayList<String> currencies;

    private ArrayList<String> languages;

    private Map<String, String> translations;

    public String getName() {
        return name;
    }

    public Collection<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public Collection<String> getCallingCodes() {
        return callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public Collection<String> getAltSpellings() {
        return altSpellings;
    }

    public String getRelevance() {
        return relevance;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public Long getPopulation() {
        return population;
    }

    public Collection<Double> getLatlng() {
        return latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public Double getArea() {
        return area;
    }

    public Double getGini() {
        return gini;
    }

    public Collection<TimeZone> getTimezones() {
        return timezones;
    }

    public Collection<String> getBorders() {
        return borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public Collection<String> getCurrencies() {
        return currencies;
    }

    public Collection<String> getLanguages() {
        return languages;
    }

    public Map<String, String> getTranslations() {
        return translations;
    }
}