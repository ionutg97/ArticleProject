import controller.ArticleController;
import controller.AuthorController;
import exception.UserIsNotAdminException;
import model.User;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        User user = new User((long) 1, "ionut", true);

        ArticleController articleController = new ArticleController(user);
        AuthorController authorController = new AuthorController(user);

        Scanner in = new Scanner(System.in);

        articleController.creatInitialArticle();
        authorController.createInitialAuthor();

        A:
        while (true) {
            System.out.println("write command: ");
            String command = in.nextLine();

            switch (command) {
                case "display Article":
                    articleController.displayArticles();
                    break;
                case "add Article":
                    try {
                        articleController.addArticle();
                    } catch (UserIsNotAdminException e) {
                        System.out.println(e);
                    }
                    break;
                case "search Article":
                    System.out.println("title article ");
                    String articleTitle = in.nextLine();
                    articleController.searchByTitle(articleTitle);
                    break;
                case "sort Article":
                    articleController.sortArticlesByPriorityOrTitle();
                    break;
                case "sort Para":
                    articleController.sortArticlesByNumberOfParagraph();
                    break;
                case "group Author":
                    System.out.println("Author name is: ");
                    String name = in.nextLine();
                    articleController.groupArticlesByAuthor(name);
                    break;
                case "sort Priority":
                    System.out.println("Priority number is: ");
                    int priority = Integer.parseInt(in.nextLine());
                    articleController.sortArticlesByPriority(priority);
                    break;
                case "difference":
                    System.out.println("The ID is: ");
                    Long id = Long.parseLong(in.nextLine());
                    articleController.articleDifferenceBetweenDate(id);
                    break;
                case "concatenate":
                    System.out.println("The ID is: ");
                    Long id1 = Long.parseLong(in.nextLine());
                    articleController.concatenateInformationFromArticle(id1);
                    break;

                //----------------------------Stream TASK calls----------------------------------------

                case "sort Authors":
                    try {
                        authorController.sortedByAuthorNameAndGender();
                    } catch (UserIsNotAdminException e) {
                        System.out.println(e.getMessage());

                    }
                    break;

                case "count":
                    try {
                        authorController.numberOfArticlesForAuthors();
                    } catch (UserIsNotAdminException e) {
                        System.out.println(e.getMessage());

                    }
                    break;

                case "female":
                    try {
                        authorController.numberOfFemaleGender();
                    } catch (UserIsNotAdminException e) {
                        System.out.println(e.getMessage());

                    }
                    break;

                case "collector":
                    try {
                        authorController.myCustomCollector();
                    } catch (UserIsNotAdminException e) {
                        System.out.println(e.getMessage());

                    }
                    break;

                case "distinct":
                    try {
                        authorController.displayAllInformation();
                    } catch (UserIsNotAdminException e) {
                        System.out.println(e.getMessage());

                    }
                    break;
                case "transform":
                    try {
                        authorController.transformAuthorsInArticles();
                    } catch (UserIsNotAdminException e) {
                        System.out.println(e.getMessage());

                    }
                    break;

                case "find article by author":
                    try {
                        System.out.println("Author name: ");
                        String authorName = in.nextLine();
                        authorController.findArticlesByAuthorName(authorName);
                    } catch (UserIsNotAdminException e) {
                        System.out.println(e.getMessage());

                    }
                    break;

                case "find by date":
                    try {
                        authorController.findArticleByLastDateModified(LocalDateTime
                                .of(2019, Month.JULY, 17, 12, 20, 00));
                    } catch (UserIsNotAdminException e) {
                        System.out.println(e.getMessage());

                    }
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
