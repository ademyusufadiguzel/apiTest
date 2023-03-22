package works.pojos.zippo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ZippopotamPojo {

    private String post_code;
    private String country;
    private String country_abbreviation;
    private ZippopotamDataPojo places;

    public ZippopotamPojo() {
    }

    public ZippopotamPojo(String post_code, String country, String country_abbreviation, ZippopotamDataPojo places) {
        this.post_code = post_code;
        this.country = country;
        this.country_abbreviation = country_abbreviation;
        this.places = places;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_abbreviation() {
        return country_abbreviation;
    }

    public void setCountry_abbreviation(String country_abbreviation) {
        this.country_abbreviation = country_abbreviation;
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
                "post_code='" + post_code + '\'' +
                ", country='" + country + '\'' +
                ", country_abbreviation='" + country_abbreviation + '\'' +
                ", places=" + places +
                '}';
    }
}
