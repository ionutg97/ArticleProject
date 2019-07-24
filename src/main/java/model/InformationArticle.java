package model;

import java.time.LocalDateTime;

public abstract class InformationArticle {
    private Author author;
    private LocalDateTime publicationDate;
    private LocalDateTime lastModifyDate;

    public InformationArticle(){
        
    }

    public InformationArticle(Author author, LocalDateTime publicationDate, LocalDateTime lastModifyDate) {
        this.author = author;
        this.publicationDate = publicationDate;
        this.lastModifyDate = lastModifyDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public LocalDateTime getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(LocalDateTime lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }
}
