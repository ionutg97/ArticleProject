package controller;

import service.ArticleService;

public class ArticleController {

    private ArticleService articleService = new ArticleService();

    public void displayArticle() {
        System.out.println(articleService.displayAllArticle());
    }

    public void addArticle() {
        articleService.createArticle();
    }

    public void searchByTitle(String title){

        System.out.println(articleService.getArticleByTitle(title));
    }

}
