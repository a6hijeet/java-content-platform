package controller;


import java.util.List;
import java.util.Optional;

import model.Post;
import service.PostService;

public class PostController {
    
    PostService ps = new PostService();
    public List<Post> getAll() {
        List<Post> postList =  ps.getAll();
        return postList;
    }

    public Post getPostById(long postId){
        Optional<Post> p = ps.getPostById(postId);
        return p.orElseThrow();
    }

    public boolean createPost(long id, String title) {
        return ps.createPost(id, title);
    }

    public boolean updatePost(long id, String title) {
        return ps.updatePost(id, title);
    }

    public boolean deletePost(long id) {
        return ps.deletePost(id);
    }
}
