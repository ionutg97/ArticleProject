package Repository;

import model.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

    private List<Author> authors = new ArrayList<Author>();

    public void addAuthor(Author author) {
        authors.add(author);
    }
}
