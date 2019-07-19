package model;

import useful.Priority;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Article extends InformationArticle {

    private Long id;
    private String title;
    private LinkedList<String> paragraphs;
    private Image image;
    private String pathYouTube;
    private Priority priority;

    public Article() {

    }


    public Article(Long id, String title, LinkedList<String> paragraphs, Image image, String pathYouTube, Priority priority,
                   Author author, Date publicationDate, Date lastModifyDate) {

        super(author, publicationDate, lastModifyDate);
        this.id = id;
        this.title = title;
        this.paragraphs = paragraphs;
        this.image = image;
        this.pathYouTube = pathYouTube;
        this.priority = priority;
    }

    public List<String> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(LinkedList<String> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getPathYouTube() {
        return pathYouTube;
    }

    public void setPathYouTube(String pathYouTube) {
        this.pathYouTube = pathYouTube;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
