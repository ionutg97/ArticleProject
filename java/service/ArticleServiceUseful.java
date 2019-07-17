package service;

import Repository.ArticleRepository;
import model.Article;


public class ArticleServiceUseful {

    private ArticleRepository articleRepository;

    public ArticleServiceUseful(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    //count the paragraphs
    public int countParagraph() {
        int numberOfParagraph = 0;
        for (Article article1 : articleRepository.getAllArticles()) {
            {
                for (String contentParagraph : article1.getParagraphs()) {
                    if (contentParagraph != null)
                        numberOfParagraph++;
                }
            }
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
}
