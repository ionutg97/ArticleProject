package service;

import Repository.ArticleRepository;
import exception.ArticleTitleNotFoundException;
import model.Article;
import useful.ApplicationInitObject;
import useful.ArticleUseful;
import useful.Calculation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArticleService {

    private ArticleRepository articleRepository = new ArticleRepository();

    private ArticleServiceUseful articleServiceUseful = new ArticleServiceUseful(articleRepository);

    public ArticleService() {
    }

    public void createArticle() {
        Article article = ArticleUseful.createNewArticle();
        articleRepository.addArticle(article);
    }

    //display all the article information
    public StringBuilder displayAllArticles() {
        StringBuilder allInformation = new StringBuilder();

        for (Article article : articleRepository.getAllArticles()) {
            allInformation.append("\n\n The id is ").append(article.getId());
            allInformation.append("\n The author is ").append(article.getAuthor().getNameAuthor());
            allInformation.append("\n The title is ").append(article.getTitle());

            for (String contentParagraph : article.getParagraphs()) {
                if (contentParagraph != null) {

                    allInformation.append("\n All paragraph: ");
                    allInformation.append(contentParagraph);

                }
            }
            allInformation.append("\n The number of paragraphs: ").append(articleServiceUseful.countParagraph(article));
            allInformation.append("\n The image is: ").append(article.getImage().getDescription());
            allInformation.append("\n The priority is: ").append(article.getPriority().getValue());
        }
        return allInformation;
    }

    public String getArticleByTitle(String title) {
        StringBuilder allInformation = new StringBuilder();
        try {
            Article article = articleRepository.getByTitle(title);
            allInformation.append("\n title is ").append(article.getTitle());
            allInformation.append("\n id is ").append(article.getId());
            allInformation.append("\n author is ").append(article.getAuthor().getNameAuthor());

        } catch (ArticleTitleNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return allInformation.toString();

    }

    public void initArticle() {
        articleRepository.addArticle(ApplicationInitObject.article1);
        articleRepository.addArticle(ApplicationInitObject.article2);
        articleRepository.addArticle(ApplicationInitObject.article3);

    }

    public void sortByPriority() {
        ArrayList<Article> sortedArticle = (ArrayList<Article>) articleRepository.getAllArticles();
        Collections.sort(sortedArticle);
        System.out.println(articleServiceUseful.displayPartialInformation(sortedArticle));

    }

    public void sortByNumberOfParagraph() {
        ArrayList<Article> sortedArticle = new ArrayList<Article>();
        sortedArticle = (ArrayList<Article>) articleRepository.getAllArticles();
        Collections.sort(sortedArticle, Comparator.comparing(article -> ArticleServiceUseful.countParagraph(article)));

        System.out.println(articleServiceUseful.displayPartialInformation(sortedArticle));
    }


    public void groupArticleByAuthor(String name) {
        ArrayList<Article> sortedArticle = new ArrayList<Article>();

        for (Article article : articleRepository.getAllArticles()) {
            if (article.getAuthor().getNameAuthor().equals(name))
                sortedArticle.add(article);
        }

        System.out.println(articleServiceUseful.displayPartialInformation(sortedArticle));
    }

    public void displayByPriority(int priority) {

//        Predicate<Article> priorityFilter = (article) -> article.getPriority().getValue() == priority;
//        List<Article> articleSorted= articleRepository.getAllArticles()
//                .stream()
//                .filter(priorityFilter)
//                .collect(Collectors.toList());
//
        List<Article> sortedArticle = articleRepository.getAllArticles()
                .stream()
                .filter(article -> article.getPriority().getValue() == priority)
                .collect(Collectors.toList());

        System.out.println(articleServiceUseful.displayPartialInformation((ArrayList<Article>) sortedArticle));

    }

    public void differenceBetweenDate(Long id) {

        Article article = articleRepository.getArticleById(id);
        Calculation calculation = (myArticle) -> (myArticle.getPublicationDate().getHour() - myArticle.getLastModifyDate().getHour());

        System.out.println("Difference between  publication date and last modify date is: " +
                calculation.calculation(article));

    }

    public void concatenateInformationAboutArticle(Long Id) {
        Article article = articleRepository.getArticleById(Id);
        Function<String, Function<Long, Function<String, String>>> concatenate =
                title
                        -> id
                        -> authorName
                        -> ""+ authorName + " "+id + " " +title;

        String result = concatenate.apply(article.getTitle())
                .apply(article.getId())
                .apply(article.getAuthor().getNameAuthor());

        System.out.println("Useful information about article: " + result);
    }





}





