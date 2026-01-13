import java.util.List;

import controller.PostController;
import model.Post;

public class App {
  public static void main(String[] args) {
    PostController pc = new PostController();

    // Pring exstigin list of posts
    List<Post> postList = pc.getAll(); 
    System.out.println("Existing posts");
    for (Post post : postList) {
      System.out.println(post.getId() + " " + post.getTitle());
    }
    System.out.println();

    // Get post by id
    Post p = pc.getPostById(102);
    System.out.println("Get Post by id 102");
    System.out.println(p.toString());
    System.out.println();


    // Create new post
    boolean addPost = pc.createPost(105, "New Post 5");
    System.out.println("Creating new post");
    System.out.println(addPost ? "Post Added " : " No post added");
    // Print updated list
    List<Post> postList1 = pc.getAll(); 
    for (Post post : postList1) {
      System.out.println(post.getId() + " " + post.getTitle());
    }
    System.out.println();
    

    // Update existing post
    System.out.println("Updating post 3");
    pc.updatePost(103, "Updated post 3");
    List<Post> postList2 = pc.getAll(); 
    for (Post post : postList2) {
      System.out.println(post.getId() + " " + post.getTitle());
    }
    System.out.println();

    // Delete post
    System.out.println("Deleting Post 1");
    Post deleted = pc.deletePost(101);
    System.out.println("Deleted Post " + deleted);
    System.out.println("Updated list after deleting");
    for (Post post : postList2) {
      System.out.println(post.getId() + " " + post.getTitle());
    }


  }
}