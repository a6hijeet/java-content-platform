package model;

import model.dto.CommentDto;

public class Comment {
  private long id;
  private long userId;
  private String comment;

  public Comment(){}
  public Comment(long id, long userId, String comment) {
    this.id = id;
    this.userId = userId;
    this.comment = comment;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUserId() {
    return this.userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
  
}
