package Repository;

import model.Image;

import java.util.List;

public class ImageRepository {
    private List<Image> images;

    public void addImage(Image image) {
        images.add(image);
    }

}
