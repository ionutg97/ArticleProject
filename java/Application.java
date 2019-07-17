import controller.ArticleController;

public class Application {
    public static void main(String[] args) {
        ArticleController articleController = new ArticleController();

        articleController.addArticle();
        articleController.displayArticle();

        articleController.searchByTitle("title");
    }
}
