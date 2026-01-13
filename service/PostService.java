package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import model.Post;
import repository.impl.PostRepository;

public class PostService {

  PostRepository pr = new PostRepository();
  
  public boolean createPost(long id, String title) {
    Post p = new Post(id, title);
    return pr.addPost(p);
  }

  public boolean updatePost(long id, String title) {
    try {
      Post p = getPostById(id).get();
      List<Post> postList = pr.getAll();
      int index = postList.indexOf(p);
      p.setTitle(title);
      p.setId(id);
      pr.updatePost(index, p);
    }catch(Exception e) {
      System.out.println("No post found");
      return false;
    }
    return true;
  }

  public List<Post> getAll() {
      List<Post> postList = pr.getAll();
      return postList;
  }

  public Optional<Post> getPostById(long postId) {
      List<Post> postList = pr.getAll();
      Stream<Post> post = postList.stream().filter(p -> p.getId() == postId);
      return post.findFirst();
  }
}
;