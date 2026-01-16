package model.dto;

public class CommentDto {
  private long id;
  private UserDto user;
  private String comment;
  
  public CommentDto(long id, UserDto user, String comment) {
    this.id = id;
    this.user = user;
    this.comment = comment;
  }

  @Override
  public String toString() {
    return "CommentDto [id=" + id + ", user=" + user + ", comment=" + comment + "]";
  }

  
  
}
