package gmibank.pojos;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country{
    private String name;
    private List<States> states;

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", states=" + states +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<States> getStates() {
        return states;
    }

    public void setStates(List<States> states) {
        this.states = states;
    }

    public Country(String name, List<States> states) {
        this.name = name;
        this.states = states;
    }

    public Country() {
    }
}