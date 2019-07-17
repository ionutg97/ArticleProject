package model;

import java.util.Objects;

public class Author {
    private String nameAuthor;
    private Image imageAuthor;
    private String job;

    public Author(){

    }

    public Author(String nameAuthor, Image imageAuthor, String job) {
        this.nameAuthor = nameAuthor;
        this.imageAuthor = imageAuthor;
        this.job = job;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public Image getImageAuthor() {
        return imageAuthor;
    }

    public void setImageAuthor(Image imageAuthor) {
        this.imageAuthor = imageAuthor;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return getNameAuthor().equals(author.getNameAuthor()) &&
                getImageAuthor().equals(author.getImageAuthor()) &&
                getJob().equals(author.getJob());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameAuthor(), getImageAuthor(), getJob());
    }
}
