package repository.impl;

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

   public void saveAll(List<Post> posts) {
    JsonFile.writeList(FILE, posts);
   }
}
