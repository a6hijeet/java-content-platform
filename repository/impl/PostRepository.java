package repository.impl;

import java.util.Arrays;
import java.util.List;
import model.Post;

public class PostRepository {

    public List<Post> getAll() {
        return Arrays.asList(
            new Post(101, "Post 1"),
            new Post(102, "Post 2"),
            new Post(103, "Post 3"),
            new Post(104, "Post 4")
        );
    }
}
