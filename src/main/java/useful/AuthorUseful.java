package useful;

import model.Author;

import java.util.Scanner;

public class AuthorUseful {

    public static Author createNewAuthor() {
        model.Author author = new Author();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter author name");
        author.setNameAuthor(in.nextLine());

        System.out.println("Enter author job");
        author.setJob(in.nextLine());

        author.setImageAuthor(ImageUseful.createNewImage());
        return author;
    }
}
