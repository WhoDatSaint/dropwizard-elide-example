package io.elide.example.model;

import com.yahoo.elide.annotation.Include;

import javax.persistence.*;

/**
 * @author thuynh
 */
@Entity
@Include(rootLevel = true)
public class Post {
    private long id;
    private User author;
    private String title;
    private String content;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
