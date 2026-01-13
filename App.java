import java.util.List;

import controller.PostController;
import model.Post;

public class App {
  public static void main(String[] args) {
    PostController pc = new PostController();

    // Pring exstigin list of posts
    List<Post> postList = pc.getAll(); 
    for (Post post : postList) {
      System.out.println(post.getId() + " " + post.getTitle());
    }
    
    // Get post by id
    Post p = pc.getPostById(102);
    System.out.println(p.toString());

    // Create new post
    boolean addPost = pc.createPost(105, "New Post 5");

    System.out.println(addPost ? "Post Added " : " No post added");
    // Print updated list
    List<Post> postList1 = pc.getAll(); 
    for (Post post : postList1) {
      System.out.println(post.getId() + " " + post.getTitle());
    }
    

    // Update existing post
    pc.updatePost(106, "Updated post 2");
    List<Post> postList2 = pc.getAll(); 
    for (Post post : postList2) {
      System.out.println(post.getId() + " " + post.getTitle());
    }



  }
}