package service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Comment;
import model.Post;
import model.User;
import model.dto.CommentDto;
import model.dto.PostDto;
import model.dto.UserDto;
import repository.impl.CommentRepository;
import repository.impl.PostRepository;
import repository.impl.UserRepository;

public class PostService {

  PostRepository pr = new PostRepository();
  CommentRepository commentRepo = new CommentRepository(); 
  UserRepository userRepo = new UserRepository();
  
  public boolean createPost(long id, String title, long createdBy) {
    List<Post> posts = pr.getAll();
    Post p = new Post(id, title, createdBy);
    posts.add(p);
    pr.saveAll(posts);
    return true;
  }

  public void attachComment(long id, Comment comment) {
    try {
      Post p = pr.getPostById(id);
      List<Post> postList = pr.getAll();

      int index = postList.indexOf(p);
      p.setComments(Arrays.asList(comment.getId()));

      postList.set(index, p);
      pr.saveAll(postList);
      List<Comment> commentList = commentRepo.getAll();
      commentList.add(comment);
      commentRepo.saveAll(commentList);
    }catch (Exception e) {
      System.out.println("No post found");
    }
  }

  public void attachLike(long id, long userId) {
    try {
      Post p = pr.getPostById(id);
      List<Post> postList = pr.getAll();

      int index = postList.indexOf(p);
      Set<Long> likes = p.getLikes();
      likes.add(userId);
      p.setLikes(likes);

      postList.set(index, p);
      pr.saveAll(postList);
    }catch (Exception e) {
      System.out.println("No post found");
    }
  }

  public boolean updatePost(long id, Post post) {
    try {
      Post p = pr.getPostById(id);
      // Get All Posts
      List<Post> postList = pr.getAll();
      System.out.println("post id " + id );
      //Find index of post
      int index = postList.indexOf(p);
      System.out.println("post index " + index );

      if(post.getTitle() != null && post.getTitle().trim() != "" ) {
        p.setTitle(post.getTitle());
      } 
      if(post.getId() != 0) {
        p.setId(post.getId());
      }
      if(p.getComments() != null) {
        System.out.println(" In comments if");
        p.setComments(post.getComments());
      }
      postList.set(index, p);
      pr.saveAll(postList);
      return true;
    }catch(Exception e) {
      System.out.println("No post found" + e);
      return false;
    }
  
  }

  public boolean deletePost(long id) {
    try {
      PostDto p = getPostById(id);
      List<Post> postList = pr.getAll();
      int index = postList.indexOf(p);
      postList.remove(index);
      pr.saveAll(postList);
      return true;
    }catch(Exception e) {
      System.out.println("No post found");
      return false;
    }
  }

  public List<Post> getAll() {
      List<Post> postList = pr.getAll();
      
      return postList;
  }

  public PostDto getPostById(long postId) {
    System.out.println(postId);
      Post post = pr.getPostById(postId);
    //  List<>
      UserDto createdBy = userRepo.getUserById(post.getCreatedBy()).toDto();

      List<Long> commentIds = post.getComments();
      System.out.println(post.getLikes());
      Set<UserDto> likes = post.getLikes().stream()
                                           .map(userId -> userRepo.getUserById(userId))
                                           .map(user -> toUserDto(user))
                                           .collect(Collectors.toSet());
      List<CommentDto> commentDtos = commentIds.stream()
                                              .map(commentId -> commentRepo.getCommentById(commentId))
                                              .map(comment -> new CommentDto(comment.getId(), toUserDto(userRepo.getUserById(comment.getUserId())), comment.getComment()))
                                              .toList();

      return new PostDto(postId, post.getTitle(), createdBy, likes, commentDtos);
  }

  private UserDto toUserDto(User user) {
    return new UserDto(user.getId(), user.getName());
  }
}
