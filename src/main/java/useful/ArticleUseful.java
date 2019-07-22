package useful;

import model.Article;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class ArticleUseful {


    public static Article createNewArticle() {
        Article article = new Article();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a id");
        article.setId(Long.parseLong(in.nextLine()));

        System.out.println("Enter a title");
        article.setTitle(in.nextLine());

        article.setImage(ImageUseful.createNewImage());
        article.setAuthor(AuthorUseful.createNewAuthor());

        System.out.println("Enter a youtube path");
        article.setPathYouTube(in.nextLine());

        article.setParagraphs(new LinkedList<String>());

        return article;
    }




}
