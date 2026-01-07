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

  public Post(String title, long id) {
    this.title = title;
    this.id = id;
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

  
}
