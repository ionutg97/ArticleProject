package repository;

import model.Article;
import model.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArticleRepository {

    private List<Article> articles = new ArrayList<Article>();

    public void addArticle(Article article) {
        articles.add(article);
    }

    public Optional<Article> getArticleByAuthor(Optional<Author> author) {
        if (author.isPresent()) {
            for (Article article : articles) {
                if (article.getAuthor().equals(author))
                    return Optional.of(article);
            }
        }
        return Optional.empty();
    }

    public Optional<List<Article>> getAllArticles() {
        List<Article> newArticles = new ArrayList<Article>();
        for (Article article : articles) {
            newArticles.add(article);
        }
        return Optional.of(newArticles);
    }

    public Optional<Article> getArticleByTitle(String title) {
        for (Article article : articles) {
            if (article.getTitle().equals(title))
                return Optional.of(article);
        }
        return Optional.empty();
    }

    public Optional<Article> getArticleById(Long id) {
        for (Article article : articles) {
            if (article.getId().equals(id))
               return Optional.of(article);
        }
        return Optional.empty();
    }

}