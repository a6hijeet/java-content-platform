package controller;

import java.util.List;

import model.Post;
import service.PostService;

public class PostController {
    
    PostService ps = new PostService();
    public List<Post> getAll() {
        List<Post> postList =  ps.getAll();

       
        return postList;
    }
}
