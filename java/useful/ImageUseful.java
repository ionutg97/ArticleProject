package useful;

import model.Image;

import java.util.Scanner;

public class ImageUseful {

    public static Image createNewImage() {
        Scanner in = new Scanner(System.in);
        Image image = new Image();

        System.out.println("Enter image path");
        image.setPathImage(in.nextLine());

        System.out.println("Enter image description");
        image.setDescription(in.nextLine());
        return image;
    }
}
