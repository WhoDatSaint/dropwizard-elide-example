package io.elide.example.model;

import com.yahoo.elide.annotation.Include;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author thuynh
 */
@Entity
@Include(rootLevel = true)
public class User {
    private long id;
    private String name;
    private String email;
    private Collection<Post> posts = new ArrayList<Post>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "author")
    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }
}
