package model;

import java.util.List;
import java.util.Objects;

public class Author {

    private Long id;
    private String nameAuthor;
    private String surname;
    private String phoneNumber;
    private String gender;
    private List<Article> articles;
    private Image imageAuthor;
    private String job;


    public Author() {

    }

    public Author(
            Long id, String nameAuthor,
            String surname, String phoneNumber,
            String gender, List<Article> articles,
            Image imageAuthor, String job) {
        this.id = id;
        this.nameAuthor = nameAuthor;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.articles = articles;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return getNameAuthor().equals(author.getNameAuthor())  &&
                getJob().equals(author.getJob());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameAuthor(), getJob());
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", nameAuthor='" + nameAuthor + '\'' +
//                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

}
