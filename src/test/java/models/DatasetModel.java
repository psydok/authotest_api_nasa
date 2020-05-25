package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Array;

public class DatasetModel {
    @JsonProperty(value = "id")
    private int id;
    @JsonProperty(value = "sol")
    private int sol;
    @JsonProperty(value = "img_src")
    private String imgSrc;
    @JsonProperty(value = "earth_date")

    private String earthDate;

    public int getId() {
        return id;
    }

    public int getSol() {
        return sol;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public String getEarthDate() {
        return earthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSol(int sol) {
        this.sol = sol;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public void setEarthDate(String earthDate) {
        this.earthDate = earthDate;
    }

    @Override
    public String toString() {
        return "DatasetModel{" +
                "id=" + id +
                ", sol='" + sol + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", earth_date='" + earthDate + '\'' +
                '}';
    }
}
