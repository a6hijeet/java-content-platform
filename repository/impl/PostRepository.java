package repository.impl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import model.Post;
import util.JsonFile;

public class PostRepository {
    
    private static final String FILE = "storage/posts.json";
    
    public List<Post> getAll() {
        List<Post> posts = JsonFile.readList(FILE, new TypeReference<List<Post>>() {});
        return posts;
    }

     /* public boolean addPost(Post p) {
        JsonFile.writeList(FILE, Arrays.asList(p));
        return this.postList.add(p);
    }

    public void updatePost(int index, Post p) {
        this.postList.set(index, p);
    }

    public Post deletePost(int index) {
        return this.postList.remove(index);
    } */
   public void saveAll(List<Post> posts) {
    JsonFile.writeList(FILE, posts);
   }
}
