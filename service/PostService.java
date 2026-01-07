package service;

import model.Post;

public class PostService {

  public Post createPost(int id, String title) {
    Post p = new Post(id, title);
    return p;
  }
}
