package service;

import Repository.AuthorRepository;
import exception.ArticleTitleNotFoundException;
import model.Article;
import model.Author;
import useful.ApplicationInitObject;


import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AuthorService {

    private AuthorRepository authorRepository = new AuthorRepository();

    private ArticleServiceUseful articleServiceUseful = new ArticleServiceUseful();

    public void initAuthor() {
        authorRepository.addAuthor(ApplicationInitObject.author1);
        authorRepository.addAuthor(ApplicationInitObject.author2);
        authorRepository.addAuthor(ApplicationInitObject.author3);
        authorRepository.addAuthor(ApplicationInitObject.author4);
        authorRepository.addAuthor(ApplicationInitObject.author5);

        authorRepository.addNewArticle(ApplicationInitObject.article1, ApplicationInitObject.author1);
        authorRepository.addNewArticle(ApplicationInitObject.article2, ApplicationInitObject.author2);
        authorRepository.addNewArticle(ApplicationInitObject.article3, ApplicationInitObject.author2);

    }

    public void sortedAuthors() {
        List<Author> authors = authorRepository.getAllAuthors();
        authors.stream()
                .sorted(Comparator.comparing(Author::getNameAuthor))
                .filter(gender -> gender.getGender().equals("Male"))
                .forEach(System.out::println);
    }

    public void numberOfArticles() {
        List<Author> authors = authorRepository.getAllAuthors();
        authors.stream()
                .forEach(author -> System.out.println("Number of articles "
                        + author.getNameAuthor()
                        + " is: "
                        + author.getArticles().size()));
    }

    public void numberOfFemaleGender() {
        List<Author> authors = authorRepository.getAllAuthors();
        Optional<Integer> result = Optional.ofNullable(authors.stream()
                .filter(gender -> Comparator.comparing(Author::getGender).equals("Female"))
                .map(gender -> 1)
                .reduce(0, (number1, number2) -> number1 + number2));

        if (result.isPresent()) {
            System.out.println("Number of females : " + result.toString());
        }

    }

    public void customCollectorPrintData() {

        Collector<Author, StringJoiner, String> printData =
                Collector.of(() -> new StringJoiner(", ", " \t ", "\n"),
                        (auth, author) -> auth.add(author.getNameAuthor().toUpperCase()),
                        StringJoiner::merge,
                        StringJoiner::toString
                );

        String result = authorRepository.getAllAuthors().stream().collect(printData);
        System.out.println(result);

    }

    public void displayDistinctAuthors() {
        List<Author> authors = authorRepository.getAllAuthors();

        authors.stream().distinct().forEach(System.out::println);
    }

    public void transformAuthorsInArticles() {
        List<Author> authors = authorRepository.getAllAuthors();

        List<Article> articles = authors.stream()
                .map(Author::getArticles)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(articleServiceUseful.displayPartialInformation((ArrayList<Article>) articles));
    }

    public void findArticlesByAuthorName(String name){
        List<Author> authors = authorRepository.getAllAuthors();

        Optional<Article> article = authors.stream()
                .filter(author -> author.getNameAuthor().equals(name))
                .map(Author::getArticles)
                .flatMap(List::stream)
                .findFirst();

        if(article.isPresent())
        {
            System.out.println(article);
        }
    }

    public Article findByDateModified(LocalDateTime dateModified)
    {
        List<Author> authors = authorRepository.getAllAuthors();

        Optional<Article> article=
                authors.stream()
                        .map(Author::getArticles)
                        .flatMap(List::stream)
                        .filter(author -> author.getLastModifyDate().equals(dateModified))
                        .findAny();

        return article.orElseThrow(()-> new ArticleTitleNotFoundException());
    }



}
