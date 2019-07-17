package model;

import java.util.Date;

public abstract class InformationArticle {
    private Author author;
    private Date publicationDate;
    private Date lastModifyDate;

    public InformationArticle() {

    }

    public InformationArticle(Author author, Date publicationDate, Date lastModifyDate) {
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

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }
}
