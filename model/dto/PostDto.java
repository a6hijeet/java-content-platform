package model.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PostDto {
  private long id;
  private String title;
  private UserDto createdBy; 
  Set<UserDto> likes = new HashSet<>();
  List<CommentDto> comments = new ArrayList<>();

  public PostDto(long id, String title, UserDto createdBy, Set<UserDto> likes, List<CommentDto> comments) {
    this.id = id;
    this.title = title;
    this.createdBy = createdBy;
    this.likes = likes;
    this.comments = comments;
  }

  @Override
  public String toString() {
    return "PostDto [id=" + id + ", title=" + title + ", createdBy=" + createdBy + ", likes=" + likes + ", comments="
        + comments + "]";
  }

  
}
