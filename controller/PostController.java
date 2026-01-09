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
}
