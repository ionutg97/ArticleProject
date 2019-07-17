import controller.ArticleController;
import exception.UserIsNotAdmin;
import model.User;

import java.util.Scanner;

import static java.lang.System.*;

public class Application {
    public static void main(String[] args) {

        User user=new User((long) 1,"ionut",false);

        ArticleController articleController = new ArticleController(user);
        Scanner in = new Scanner(System.in);

        A: while (true) {
            System.out.println("write command: ");
            String command = in.nextLine();

            switch (command) {
                case "display Article":
                    articleController.displayArticle();
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
                    articleController.searchByTitle("title");
                    break;
                case "exit":
                    break A;
                default:
                    System.out.println("Unknown command");
                    break;

            }
        }

    }
}
