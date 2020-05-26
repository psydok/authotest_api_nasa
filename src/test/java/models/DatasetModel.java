package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DatasetModel {
    @JsonProperty(value = "photos")
    private List<Photo> photos;

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
