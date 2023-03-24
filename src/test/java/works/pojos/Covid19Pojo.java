package works.pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Covid19Pojo {

    private Integer TotalConfirmed;
    private Integer TotalDeaths;
    private Integer TotalRecovered;

    public Covid19Pojo() {
    }

    public Covid19Pojo(Integer totalConfirmed, Integer totalDeaths, Integer totalRecovered) {
        TotalConfirmed = totalConfirmed;
        TotalDeaths = totalDeaths;
        TotalRecovered = totalRecovered;
    }

    public Integer getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(Integer totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    public Integer getTotalDeaths() {
        return TotalDeaths;
    }

    public void setTotalDeaths(Integer totalDeaths) {
        TotalDeaths = totalDeaths;
    }

    public Integer getTotalRecovered() {
        return TotalRecovered;
    }

    public void setTotalRecovered(Integer totalRecovered) {
        TotalRecovered = totalRecovered;
    }

    @Override
    public String toString() {
        return "Covid19Pojo{" +
                "TotalConfirmed=" + TotalConfirmed +
                ", TotalDeaths=" + TotalDeaths +
                ", TotalRecovered=" + TotalRecovered +
                '}';
    }
}
