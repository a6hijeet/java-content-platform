package repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Post;

public class PostRepository {

    private List<Post> postList = new ArrayList<>(Arrays.asList(
            new Post(101, "Post 1"),
            new Post(102, "Post 2"),
            new Post(103, "Post 3"),
            new Post(104, "Post 4")
        ));

    public List<Post> getAll() {
        return this.postList;
    }

     public boolean addPost(Post p) {
        return this.postList.add(p);
    }

    public void updatePost(int index, Post p) {
        this.postList.set(index, p);
    }
}
