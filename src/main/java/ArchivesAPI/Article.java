package ArchivesAPI;

import java.util.Date;

public class Article {
    private long id;
    private String author;
    private String title;
    private String description;
    private Date publishedDate;

    public Article() {
        super();
    }

    public Article(String author, String title, String description, Date publishedDate) {
        super();
        this.author = author;
        this.title = title;
        this.description = description;
        this.publishedDate = publishedDate;
    }

    public Article(int id, String author, String title, String description, Date publishedDate) {
        super();
        this.id = id;
        this.author = author;
        this.title = title;
        this.description = description;
        this.publishedDate = publishedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

}
