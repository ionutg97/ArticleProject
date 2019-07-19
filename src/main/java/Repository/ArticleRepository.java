package Repository;

import exception.ArticleTitleNotFoundException;
import model.Article;
import model.Author;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {

    private List<Article> articles = new ArrayList<Article>();

    public void addArticle(Article article) {
        articles.add(article);
    }

    public Article getArticleByAuthor(Author author) {
        if (author != null) {
            for (Article article : articles) {
                if (article.getAuthor().equals(author))
                    return article;
            }
        } else {
            throw new NullPointerException("Invalid author");
        }
        return null;
    }

    public List<Article> getAllArticles() {
        return articles;
    }

    public Article getByTitle(String title) {
        for (Article article : articles) {
            if (article.getTitle().equals(title))
                return article;

        }
        throw new ArticleTitleNotFoundException("The article was not found");
    }

}