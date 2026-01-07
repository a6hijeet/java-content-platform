package model;

public class Comment {
  private long id;
  private User user;
  private String comment;

  public Comment(long id, User user, String comment) {
    this.id = id;
    this.user = user;
    this.comment = comment;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
  
}
