import java.util.List;

import controller.PostController;
import model.Post;

public class App {
  public static void main(String[] args) {
    PostController pc = new PostController();
    List<Post> postList = pc.getAll(); 
    for (Post post : postList) {
      System.out.println(post.getId() + " " + post.getTitle());
    }
  
  }
}