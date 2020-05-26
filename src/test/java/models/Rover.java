package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Rover {
    @JsonProperty(value = "id")
    private int id;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "landing_date")
    private String landingDate;
    @JsonProperty(value = "launch_date")
    private String launchDate;
    @JsonProperty(value = "status")
    private String status;
    @JsonProperty(value = "max_sol")
    private int maxSol;
    @JsonProperty(value = "max_date")
    private String maxDate;
    @JsonProperty(value = "total_photos")
    private int totalPhotos;
    @JsonProperty(value = "cameras")
    private List<NamesCamera> cameras;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
