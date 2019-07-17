package model;

public class Image {
    private String pathImage;
    private String description;

    public Image() {

    }

    public Image(String pathImage, String description) {
        this.pathImage = pathImage;
        this.description = description;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
