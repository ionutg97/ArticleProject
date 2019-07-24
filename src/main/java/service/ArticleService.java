package service;

import repository.ArticleRepository;

import model.Article;
import useful.ApplicationInitObject;
import useful.ArticleUseful;
import useful.Calculation;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArticleService {

    private ArticleRepository articleRepository = new ArticleRepository();

    private ArticleServiceUseful articleServiceUseful = new ArticleServiceUseful(articleRepository);

    public ArticleService() {
    }

    public void createArticle() {
        Optional<Article> article = Optional.of(ArticleUseful.createNewArticle());
        if (article.isPresent())
            articleRepository.addArticle(article.get());
    }


    public List<Article> displayAllArticles() {
        List<Article> articles = articleRepository.getAllArticles().get();
        return articles;
    }

    public Article searchArticleByTitle(String title) {
        Article article = articleRepository.getArticleByTitle(title).get();
        return article;

    }

    public void initArticle() {
        articleRepository.addArticle(ApplicationInitObject.article1);
        articleRepository.addArticle(ApplicationInitObject.article2);
        articleRepository.addArticle(ApplicationInitObject.article3);
    }

    public List<Article> sortByPriority() {
        List<Article> sortedArticle = articleRepository.getAllArticles().get();

        Collections.sort(sortedArticle);

        return sortedArticle;
    }

    public List<Article> sortByNumberOfParagraph() {
        List<Article> sortedArticle = articleRepository.getAllArticles().get();

        Collections.sort(sortedArticle,
                Comparator.comparing(article -> ArticleServiceUseful.countParagraph(article)));

        return sortedArticle;
    }


    public List<Article> groupArticleByAuthor(String name) {
        List<Article> sortedArticle = new ArrayList<Article>();

        for (Article article : articleRepository.getAllArticles().get()) {
            if (article.getAuthor().getNameAuthor().equals(name))
                sortedArticle.add(article);
        }

        return sortedArticle;
    }

    public List<Article> groupByPriority(Integer priority) {
        List<Article> sortedArticle =
                articleRepository.getAllArticles().get()
                        .stream()
                        .filter(article -> article.getPriority().getValue() == priority)
                        .collect(Collectors.toList());

        return sortedArticle;
    }

    public Integer getTimeDifferenceBetweenDate(Long id) {
        Article article = articleRepository.getArticleById(id).get();

        Calculation calculation = (myArticle) -> (myArticle.getPublicationDate().getHour() - myArticle.getLastModifyDate().getHour());

        return calculation.calculation(article);

    }

    public String concatenateInformationAboutArticle(Long Id) {
        Article article = articleRepository.getArticleById(Id).get();

        Function<String, Function<Long, Function<String, String>>> concatenate =
                title
                        -> id
                        -> authorName
                        -> "" + authorName + " " + id + " " + title;

        String result = concatenate.apply(article.getTitle())
                .apply(article.getId())
                .apply(article.getAuthor().getNameAuthor());

        return result;
    }

    public String printInformation(List<Article> articles)
    {
       return articleServiceUseful.displayInformationAboutArticles((ArrayList<Article>)articles);
    }
}





