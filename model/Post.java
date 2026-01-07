package model;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Post {
  private String title;
  private long id;
  Set<Long> likes = new HashSet<Long>();
  List<Comment> comments = new ArrayList<>();

  public Post(String title, long id) {
    this.title = title;
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Set<Long> getLikes() {
    return likes;
  }

  public void setLikes(Set<Long> likes) {
    this.likes = likes;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  
}
