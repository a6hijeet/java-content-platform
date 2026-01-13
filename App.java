
import java.util.List;

import controller.PostController;
import model.Post;

public class App {
  public static void main(String[] args) {
  PostController pc = new PostController();

   pc.createPost(101, "Post 1");
   pc.createPost(102, "Post 2");
   pc.createPost(103, "Post 3");
   pc.createPost(104, "Post 4");
   pc.createPost(105, "Post 5");

   List<Post> posts = pc.getAll();
    
   posts.forEach(post -> System.out.println(post.toString()));

   pc.updatePost(101, "Updated post");

    
   pc.getAll().forEach(post -> System.out.println(post.toString()));

   pc.deletePost(105);

   pc.getAll().forEach(post -> System.out.println(post.toString()));
  }
}