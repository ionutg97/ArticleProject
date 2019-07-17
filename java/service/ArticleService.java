package service;

import Repository.ArticleRepository;
import exception.ArticleTitleNotFoundException;
import model.Article;
import useful.ArticleUseful;

public class ArticleService {

    private ArticleRepository articleRepository = new ArticleRepository();

    private ArticleServiceUseful articleServiceUseful = new ArticleServiceUseful(articleRepository);

    public ArticleService() {
    }

    public void createArticle() {
        Article article = ArticleUseful.createNewArticle();
        articleRepository.addArticle(article);
    }

    //display all the article information
    public StringBuilder displayAllArticle() {
        StringBuilder allInformation = new StringBuilder();

        for (Article article : articleRepository.getAllArticles()) {
            for (String contentParagraph : article.getParagraphs()) {
                if (contentParagraph != null) {

                    allInformation.append("\n All paragraph: ");
                    allInformation.append(contentParagraph);
                }
            }
            allInformation.append("\n The author is ").append(article.getAuthor().getNameAuthor());
            allInformation.append("\n The number of paragraphs ").append(articleServiceUseful.countParagraph());
            allInformation.append("\n The image is ").append(article.getImage().getDescription());

        }
        return allInformation;
    }

    public String getArticleByTitle(String title) {
        StringBuilder allInformation = new StringBuilder();
        try {
            Article article = articleRepository.getByTitle(title);
            allInformation.append("\n title is ").append(article.getTitle());
            allInformation.append("\n id is ").append(article.getId());
            allInformation.append("\n author is ").append(article.getAuthor().getNameAuthor());

        } catch (ArticleTitleNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return allInformation.toString();

    }


}





