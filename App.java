import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;

import controller.PostController;
import controller.UserController;
import handler.PostHandler;
import handler.StaticFileHandler;
import model.Comment;
import model.Post;
import model.User;
import model.dto.PostDto;
import com.sun.net.httpserver.HttpServer;

public class App {
  public static void main(String[] args) throws Exception {
  PostController pc = new PostController();
  UserController userController = new UserController();




  /* List<Post> posts = pc.getAll();
  System.out.println("Existing posts");
  posts.forEach(post -> System.out.println(post.toString()));
  Post up = new Post();
  System.out.println();
  up.setTitle("Updated Post");
  pc.updatePost(101, up );

  System.out.println();
  System.out.println("Updated post title");
  pc.getAll().forEach(post -> System.out.println(post.toString()));

  pc.deletePost(105);
  System.out.println();
  System.out.println("deleted post 105");
  pc.getAll().forEach(post -> System.out.println(post.toString()));
    System.out.println(); */
 /*  System.out.println("Adding comment");
  User u = new User(101, "User 1");
  userController.createUser(u.getId(), u.getName());

  pc.createPost(101, "Post 1", u.getId());
  pc.createPost(102, "Post 2", u.getId());
  pc.createPost(103, "Post 3", u.getId());
  pc.createPost(104, "Post 4", u.getId());
  pc.createPost(105, "Post 5", u.getId());
*/

//User u = new User(102, "User 2");
 // Comment c = new Comment(102, 102, "Second comment from U1");
  
 // pc.attachComment(102, c);
 // pc.getAll().forEach(post -> System.out.println(post.toString())); 
 // pc.attachLike(102, 102);
  System.out.println(pc.getPostById(102).toString());

  HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
  server.createContext("/", new StaticFileHandler("frontend"));
  server.createContext("/posts", new PostHandler());
  server.start();
  System.out.println("Server started at https://localhost:8080/posts");
  }
}