package service;

import java.util.List;

import model.Post;
import repository.impl.PostRepository;

public class PostService {

  PostRepository pr = new PostRepository();
  public Post createPost(int id, String title) {
    Post p = new Post(id, title);
    return p;
  }

  public List<Post> getAll() {
      List<Post> postList = pr.getAll();
      return postList;

  }
}
