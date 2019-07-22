package service;

import Repository.ArticleRepository;
import model.Article;

import java.util.ArrayList;


public class ArticleServiceUseful {

    private ArticleRepository articleRepository;

    public ArticleServiceUseful() {

    }

    public ArticleServiceUseful(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    //count the paragraphs
    public static int countParagraph(Article article) {
        int numberOfParagraph = 0;
        for (String contentParagraph : article.getParagraphs()) {
            if (contentParagraph != null)
                numberOfParagraph++;
        }
        return numberOfParagraph;
    }

    //adding a paragraph
    public void addParagraph(Article article, String textParagraph, int indexArray) {
        if (articleRepository.getAllArticles().size() == 0)
            article.getParagraphs().add(textParagraph);
        else if (indexArray > article.getParagraphs().size() - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            article.getParagraphs().add(indexArray, textParagraph);
        }
    }

    //modify a paragraph
    public void modifyParagraph(Article article, String textParagraph, int indexArray) {
        if (indexArray > article.getParagraphs().size() - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            article.getParagraphs().set(indexArray, textParagraph);
        }
    }

    public String displayPartialInformation(ArrayList<Article> articles) {
        StringBuilder allInformation = new StringBuilder();
        for (Article article : articles) {
            allInformation.append("\n\n The id is ").append(article.getId());
            allInformation.append("\n The author is ").append(article.getAuthor().getNameAuthor());
            allInformation.append("\n The title is ").append(article.getTitle());
            allInformation.append("\n The priority is: ").append(article.getPriority().getValue());
            allInformation.append("\n The number Of Paragraph is: ").append(countParagraph(article));
        }
        return allInformation.toString();
    }
}
