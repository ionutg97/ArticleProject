package controller;

import exception.UserIsNotAdminException;
import model.User;
import service.AuthorService;

import java.time.LocalDateTime;

public class AuthorController {
    private AuthorService authorService = new AuthorService();
    private User user;

    public AuthorController(User user) {
        this.user = user;
    }

    public void createInitialAuthor() {
        authorService.initAuthor();
    }

    public void sortedByAuthorNameAndGender() {
        if (user.isAdmin())
            authorService.sortedAuthors();
        else
            throw new UserIsNotAdminException("The user is not admin");
    }

    public void numberOfArticlesForAuthors() {
        if (user.isAdmin())
            authorService.numberOfArticles();
        else
            throw new UserIsNotAdminException("The user is not admin");
    }

    public void numberOfFemaleGender() {
        if (user.isAdmin())
            authorService.numberOfFemaleGender();
        else
            throw new UserIsNotAdminException("The user is not admin");
    }

    public void myCustomCollector() {
        if (user.isAdmin())
            authorService.customCollectorPrintData();
        else
            throw new UserIsNotAdminException("The user is not admin");
    }

    public void displayAllInformation() {
        if (user.isAdmin())
            authorService.displayDistinctAuthors();
        else
            throw new UserIsNotAdminException("The user is not admin");
    }

    public void transformAuthorsInArticles() {
        if (user.isAdmin())
            authorService.transformAuthorsInArticles();
        else
            throw new UserIsNotAdminException("The user is not admin");
    }

    public void findArticlesByAuthorName(String authorName) {
        if (user.isAdmin())
            authorService.findArticlesByAuthorName(authorName);
        else
            throw new UserIsNotAdminException("The user is not admin");
    }

    public void findArticleByLastDateModified(LocalDateTime date) {
        if (user.isAdmin())
            System.out.println(authorService.findByDateModified(date));
        else
            throw new UserIsNotAdminException("The user is not admin");
    }
}
