package controller;

import exception.UserIsNotAdminException;
import model.Article;
import model.User;
import service.ArticleService;

import java.util.List;
import java.util.NoSuchElementException;


public class ArticleController {

    private ArticleService articleService = new ArticleService();
    private User user;

    public ArticleController(User user) {
        this.user = user;
    }

    public List<Article> displayArticles() {
        try {
            return articleService.displayAllArticles();
        }
        catch (NoSuchElementException e )
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void addArticle() {
        if (user.isAdmin()) {
            articleService.createArticle();
        } else
            throw new UserIsNotAdminException("The user is not Admin");
    }

    public Article searchByTitle(String title) {
        try {
            return articleService.searchArticleByTitle(title);
        }
        catch (NoSuchElementException e )
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void creatInitialArticle() {
        articleService.initArticle();
    }

    public List<Article> sortArticlesByPriorityOrTitle() {
        try {
           return articleService.sortByPriority();
        }
        catch (NoSuchElementException e )
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Article> sortArticlesByNumberOfParagraph() {
        try {
           return articleService.sortByNumberOfParagraph();
        }
        catch (NoSuchElementException e )
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Article> groupArticlesByAuthor(String name) {
        try {
           return articleService.groupArticleByAuthor(name);
        }
        catch (NoSuchElementException e )
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Article> groupArticlesByPriority(Integer priority) {
        try {
           return articleService.groupByPriority(priority);
        }
        catch (NoSuchElementException e )
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Integer getTimeDifferenceBetweenDate(Long id) {

        try {
           return articleService.getTimeDifferenceBetweenDate(id);
        }
        catch (NoSuchElementException e )
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String concatenateInformationFromArticle(Long id) {

       try {
          return articleService.concatenateInformationAboutArticle(id);
       }
       catch (NoSuchElementException e )
       {
           System.out.println(e.getMessage());
       }
        return null;
    }

    public String printInformation(List<Article> articles){
        return articleService.printInformation(articles);
    }
}