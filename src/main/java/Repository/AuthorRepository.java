package Repository;

import model.Article;
import model.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorRepository {

    private List<Author> authors = new ArrayList<Author>();

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public Optional<Author> getAuthorById(Long id) {
        for (Author author : authors) {
            if (author.getId() == id) {
                return Optional.of(author);
            }
        }
        return Optional.empty();
    }

    public void addNewArticle(Article article, Author author) {

        for (Author myAuthor: authors) {
            if(myAuthor.equals(author))
            {
                myAuthor.getArticles().add(article);
            }
        }
    }

    public List<Author> getAllAuthors(){
        List<Author> newAuthors = new ArrayList<>();
        for (Author author : authors) {
            newAuthors.add(author);
        }
        return newAuthors;
    }
}
