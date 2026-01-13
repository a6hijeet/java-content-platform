package model;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Post {
  private long id;
  private String title;
  Set<User> likes = new HashSet<User>();
  List<Comment> comments = new ArrayList<>();

  public Post(long id, String title) {
    this.id = id;
    this.title = title;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Set<User> getLikes() {
    return likes;
  }

  public void setLikes(Set<User> likes) {
    this.likes = likes;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  @Override
  public String toString() {
    return "Post [id=" + id + ", title=" + title + ", likes=" + likes + ", comments=" + comments + "]";
  }

  

  
}
