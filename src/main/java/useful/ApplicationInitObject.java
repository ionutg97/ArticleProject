package useful;

import model.Article;
import model.Author;
import model.Image;


import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.LinkedList;

public class ApplicationInitObject {

    public static Image imageA1 = new Image("C:\\Users\\igalan\\isd2019internship_java\\JavaBasic\\src\\main\\resources\\",
            "picture HEADPHONES");
    public static Author author1 = new Author(
            (long)2001,
            "Theo",
            "Nicolakis",
            "0723456675",
            "Male",
            new ArrayList<Article>(),
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

    public static Article article1 = new Article.ArticleBuilder(
            (long)1001,
            "BEST HEADPHONES",
            paragraphsA1,
            Priority.IMPORTANT,
            author1,
            LocalDateTime.of(2019, Month.JULY, 16, 19, 30, 40),
            LocalDateTime.of(2019, Month.JULY, 17, 12, 20, 00)
            )
            .setImage( imageA1)
            .setPathYouTube("https://www.youtube.com/watch?v=nuNYtj8keaE")
            .build();

    public static Image imageA2 = new Image("C:\\Users\\igalan\\isd2019internship_java\\JavaBasic\\src\\main\\resources\\",
            "picture Z-EDGE");
    public static Author author2 = new Author(
            (long)2002,
            "Jhon",
            "Jacobi",
            "0798765432",
            "Male",
            new ArrayList<Article>(),
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

    public static Article article2 = new Article.ArticleBuilder(
            (long)1002,
            "Z-EDGE F1 DASH",
            paragraphsA2,
            Priority.MID_IMPORTANT,
            author2,
            LocalDateTime.of(2019, Month.JULY, 17, 18, 00, 00),
            LocalDateTime.of(2019, Month.JULY, 17, 12, 30, 40))
            .setImage( imageA2)
            .setPathYouTube("https://www.youtube.com/watch?v=nuNYtj8keaE")
            .build();

    public static Image imageA3 = new Image("C:\\Users\\igalan\\isd2019internship_java\\JavaBasic\\src\\main\\resources\\",
            "picture Z-EDGE");
    public static Author author3 = new Author((long)2003,
            "Pike",
            "Mike",
            "0799123411",
            "Male",
            new ArrayList<Article>(),
            imageA2,
            "freelance");

    public static LinkedList<String> paragraphsA3= new LinkedList<>();
    static {
        paragraphsA3.add("The F1 is a wide-body camera, measuring approximately 4.25x1.75x1.35 inches." +
                " It’s handsome as dash cams go, with a suction mount that also incorporates the GPS module." +
                " Nicely, the GPS module serves as a handle that rotates to aid the removal mechanism." +
                " If you’ve used a high-suction model that relies on only a rotary dial, you’ll appreciate how much easier it is.");

    }

    public static Article article3 = new Article.ArticleBuilder(
            (long)1003,
            "X-EDGE F1 DASH",
            paragraphsA3,
            Priority.MID_IMPORTANT,
            author2,
            LocalDateTime.of(2019, Month.JULY, 15, 00, 00, 40),
            LocalDateTime.of(2019, Month.JULY, 17, 12, 30, 40))
            .setImage(imageA3)
            .setPathYouTube("https://www.youtube.com/watch?v=nuNYtj8keaE")
            .build();

    public static Author author4 = new Author((long)2004,
            "Moira",
            "Alexander",
            "0799123411",
            "Male",
            new ArrayList<Article>(),
            imageA2,
            "CIO");

    public static Author author5 = new Author((long)2005,
            "Evelin",
            "Loyola",
            "0799123411",
            "Female",
            new ArrayList<Article>(),
            imageA2,
            "MACWorld");
}
