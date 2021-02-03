package blog.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


public class Post {
    private String title;
    private String text;
    private Category category;
    private Date createdDate;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

   

    public Post(String title, String text, Category category, Date createdDate, SimpleDateFormat sdf) {
        this.title = title;
        this.text = text;
        this.category = category;
        this.createdDate = createdDate;
        this.sdf = sdf;
    }

    public Post(String postDatum, String datum, Category category, Date date) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) &&
                Objects.equals(text, post.text) &&
                category == post.category &&
                Objects.equals(createdDate, post.createdDate) &&
                Objects.equals(sdf, post.sdf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, text, category, createdDate, sdf);
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", category=" + category +
                ", createdDate=" + createdDate +
                ", sdf=" + sdf +
                '}';
    }
}
