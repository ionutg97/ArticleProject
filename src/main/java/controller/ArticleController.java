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

    public void displayArticles() {

        System.out.println(articleService.displayAllArticles());
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

    public void creatInitialArticle()
    {
        articleService.initArticle();
    }

    public void sortArticlesByPriorityOrTitle()
    {
        articleService.sortByPriority();
    }

    public void sortArticlesByNumberOfParagraph(){
        articleService.sortByNumberOfParagraph();
    }

    public void groupArticleByAuthor(String name)
    {
        articleService.groupArticleByAuthor(name);
    }

}