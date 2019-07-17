package controller;

import exception.UserIsNotAdmin;
import model.User;
import service.ArticleService;

public class ArticleController {

    private ArticleService articleService = new ArticleService();
    private User user;

    public ArticleController(User user) {
        this.user = user;
    }

    public void displayArticle() {

        System.out.println(articleService.displayAllArticle());
    }

    public void addArticle() {
        if(user.isAdmin()) {
            articleService.createArticle();
        }
        else
            throw new UserIsNotAdmin("The user is not Admin");
    }

    public void searchByTitle(String title){

        System.out.println(articleService.getArticleByTitle(title));
    }

}
