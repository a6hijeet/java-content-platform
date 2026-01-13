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

  public Post() {
  }

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
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((title == null) ? 0 : title.hashCode());
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
    return "Post [id=" + id + ", title=" + title + ", likes=" + likes + ", comments=" + comments + "]";
  }

  

  
}
