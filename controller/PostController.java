package controller;


import java.util.List;
import model.Comment;
import model.Post;
import model.dto.PostDto;
import service.PostService;

public class PostController {
    
    PostService ps = new PostService();
    public List<Post> getAll() {
        List<Post> postList =  ps.getAll();
        return postList;
    }

    public PostDto getPostById(long postId){
        return ps.getPostById(postId);
    }

    public boolean createPost(long id, String title, long createdBy) {
        return ps.createPost(id, title, createdBy);
    }

    public boolean updatePost(long id, Post post) {
        return ps.updatePost(id, post);
    }

    public boolean deletePost(long id) {
        return ps.deletePost(id);
    }

    public void attachComment(long id, Comment comment) {
        ps.attachComment(id, comment);
    }

    public void attachLike(long id, long userId) {
        ps.attachLike(id, userId);
    }

}
