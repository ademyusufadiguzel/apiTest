package works.pojos.zippo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ZippopotamPojo {

    private String postCode;
    private String country;
    private String countryAbbreviation;
    private ZippopotamDataPojo places;

    public ZippopotamPojo() {
    }

    public ZippopotamPojo(String post_code, String country, String country_abbreviation, ZippopotamDataPojo places) {
        this.postCode = post_code;
        this.country = country;
        this.countryAbbreviation = country_abbreviation;
        this.places = places;
    }

    public String getPost_code() {
        return postCode;
    }

    public void setPost_code(String post_code) {
        this.postCode = post_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_abbreviation() {
        return countryAbbreviation;
    }

    public void setCountry_abbreviation(String country_abbreviation) {
        this.countryAbbreviation = country_abbreviation;
    }

    public ZippopotamDataPojo getPlaces() {
        return places;
    }

    public void setPlaces(ZippopotamDataPojo places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "ZippopotamPojo{" +
                "post_code='" + postCode + '\'' +
                ", country='" + country + '\'' +
                ", country_abbreviation='" + countryAbbreviation + '\'' +
                ", places=" + places +
                '}';
    }
}
