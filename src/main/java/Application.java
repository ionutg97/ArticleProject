import controller.ArticleController;
import exception.UserIsNotAdmin;
import model.User;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        User user=new User((long) 1,"ionut",false);

        ArticleController articleController = new ArticleController(user);
        Scanner in = new Scanner(System.in);

        articleController.creatInitialArticle();

        A: while (true) {
            System.out.println("write command: ");
            String command = in.nextLine();

            switch (command) {
                case "display Article":
                    articleController.displayArticles();
                    break;
                case "add Article":
                    try {
                        articleController.addArticle();
                    }
                    catch (UserIsNotAdmin e)
                    {
                        System.out.println(e);
                    }
                    break;
                case "search Article":
                    System.out.println("title article ");
                    String articleTitle=in.nextLine();
                    articleController.searchByTitle(articleTitle);
                    break;
                case"sort Article":
                    articleController.sortArticlesByPriorityOrTitle();
                    break;
                case "sort Para":
                    articleController.sortArticlesByNumberOfParagraph();
                    break;
                case "sort Author":
                    System.out.println("Author name is: ");
                    String name=in.nextLine();
                    articleController.groupArticleByAuthor(name);
                case "exit":
                    break A;
                default:
                    System.out.println("Unknown command");
                    break;

            }
        }

    }
}
