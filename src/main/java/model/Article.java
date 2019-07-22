package model;

import useful.Priority;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Article extends InformationArticle implements Comparable<Article> {

    private Long id;
    private String title;
    private LinkedList<String> paragraphs;
    private Image image;
    private String pathYouTube;
    private Priority priority;

    public Article() {

    }

    public Article(Long id,
                   String title,
                   LinkedList<String> paragraphs,
                   Image image,
                   String pathYouTube,
                   Priority priority,
                   Author author,
                   LocalDateTime publicationDate,
                   LocalDateTime lastModifyDate) {

        super(author, publicationDate, lastModifyDate);
        this.id = id;
        this.title = title;
        this.paragraphs = paragraphs;
        this.image = image;
        this.pathYouTube = pathYouTube;
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(getTitle(), article.getTitle()) &&
                getPriority() == article.getPriority() &&
                Objects.equals(getAuthor(),article.getAuthor());
    }

    @Override
    public int hashCode() {
        return 31*getTitle().hashCode()+getPriority().getValue()+getAuthor().hashCode();
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

    @Override
    public int compareTo(Article article) {
        if(getPriority().getValue()==article.getPriority().getValue())
            return getTitle().compareTo(article.getTitle());
        else
            return getPriority().getValue()-article.getPriority().getValue();
    }

    @Override
    public String toString() {
        return "Article{"+
                "author name= "+getAuthor().getNameAuthor()+
                ", id=" + id +
                ", title='" + title + '\'' +
                ", priority=" + priority +
                '}';
    }
}
