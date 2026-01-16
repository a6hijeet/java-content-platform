package model;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Post {
  private long id;
  private String title;
  private long createdBy; 
  Set<Long> likes = new HashSet<>();
  List<Long> comments = new ArrayList<>();

  public Post() {
  }

  public Post(long id, String title, long createdBy) {
    this.id = id;
    this.title = title;
    this.createdBy = createdBy;
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

  public long getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(long createdBy) {
    this.createdBy = createdBy;
  }

  public Set<Long> getLikes() {
    return likes;
  }

  public void setLikes(Set<Long> likes) {
    this.likes = likes;
  }

  public List<Long> getComments() {
    return comments;
  }

  public void setComments(List<Long> comments) {
    this.comments = comments;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    result = prime * result + (int) (createdBy ^ (createdBy >>> 32));
    result = prime * result + ((likes == null) ? 0 : likes.hashCode());
    result = prime * result + ((comments == null) ? 0 : comments.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Post other = (Post) obj;
    if (id != other.id)
      return false;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    if (createdBy != other.createdBy)
      return false;
    if (likes == null) {
      if (other.likes != null)
        return false;
    } else if (!likes.equals(other.likes))
      return false;
    if (comments == null) {
      if (other.comments != null)
        return false;
    } else if (!comments.equals(other.comments))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Post [id=" + id + ", title=" + title + ", createdBy=" + createdBy + ", likes=" + likes + ", comments="
        + comments + "]";
  }

  
  
}
