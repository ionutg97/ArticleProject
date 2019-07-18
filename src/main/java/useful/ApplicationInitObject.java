package useful;

import model.Article;
import model.Author;
import model.Image;


import java.util.Date;
import java.util.LinkedList;

public class ApplicationInitObject {

    public static Image imageA1 = new Image("C:\\Users\\igalan\\isd2019internship_java\\JavaBasic\\src\\main\\resources\\",
            "picture HEADPHONES");
    public static Author author1 = new Author("Theo Nicolakis",
            imageA1,
            "freelance");

    public static LinkedList<String> paragraphsA1= new LinkedList<>();
    static {
        paragraphsA1.add("The best headphones are the ultimate tool " +
                "for intimate listening experiences. Whether you’re " +
                "listening on your phone, a digital audio player, a disc player, " +
                "or even a PC or gaming console, when you’re ready to shut out the world " +
                "and be one with your music, there is nothing better than a great set of cans. ");
        paragraphsA1.add("And you probably have multiples of them, since most every smart device " +
                "and digital audio player comes with a pair; but it’s a safe bet that you’re " +
                "really not satisfied with any of them. Comfortable high-quality headphones " +
                "can transform your audio experiences ranging from listening to music and podcasts " +
                "to watching TV shows and movies, .");

    }

    public static Article article1 = new Article(
            (long)1001,
            "BEST HEADPHONES",
            paragraphsA1,
            imageA1,
            "https://www.youtube.com/watch?v=nuNYtj8keaE",
            Priority.IMPORTANT,
            author1,
            new Date(2019,7,15,10,34),
            new Date(2019, 7, 16)
    );

    public static Image imageA2 = new Image("C:\\Users\\igalan\\isd2019internship_java\\JavaBasic\\src\\main\\resources\\",
            "picture Z-EDGE");
    public static Author author2 = new Author("Jhon Jacobi",
            imageA2,
            "freelance");

    public static LinkedList<String> paragraphsA2= new LinkedList<>();
    static {
        paragraphsA2.add("The F1 is a wide-body camera, measuring approximately 4.25x1.75x1.35 inches." +
                " It’s handsome as dash cams go, with a suction mount that also incorporates the GPS module." +
                " Nicely, the GPS module serves as a handle that rotates to aid the removal mechanism." +
                " If you’ve used a high-suction model that relies on only a rotary dial, you’ll appreciate how much easier it is.");
        paragraphsA2.add("GPS info is watermarked onto the video, as well as embedded into the video for use with " +
                "playback and mapping software. Z-Edge also provides (via download) a player that will render the video," +
                " as well as display your location, heading, and speed. See below.");

    }

    public static Article article2 = new Article(
            (long)1002,
            "Z-EDGE F1 DASH",
            paragraphsA2,
            imageA2,
            "https://www.youtube.com/watch?v=nuNYtj8keaE",
            Priority.MID_IMPORTANT,
            author2,
            new Date(2019,7,16,11,00),
            new Date(2019, 7, 17)
    );

    public static Image imageA3 = new Image("C:\\Users\\igalan\\isd2019internship_java\\JavaBasic\\src\\main\\resources\\",
            "picture Z-EDGE");
    public static Author author3 = new Author("Jhon Jacobi",
            imageA3,
            "freelance");

    public static LinkedList<String> paragraphsA3= new LinkedList<>();
    static {
        paragraphsA3.add("The F1 is a wide-body camera, measuring approximately 4.25x1.75x1.35 inches." +
                " It’s handsome as dash cams go, with a suction mount that also incorporates the GPS module." +
                " Nicely, the GPS module serves as a handle that rotates to aid the removal mechanism." +
                " If you’ve used a high-suction model that relies on only a rotary dial, you’ll appreciate how much easier it is.");

    }

    public static Article article3 = new Article(
            (long)1003,
            "X-EDGE F1 DASH",
            paragraphsA3,
            imageA3,
            "https://www.youtube.com/watch?v=nuNYtj8keaE",
            Priority.MID_IMPORTANT,
            author3,
            new Date(2019,7,16,11,00),
            new Date(2019, 7, 17)
    );

}
