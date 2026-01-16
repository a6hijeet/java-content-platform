package repository.impl;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import model.Comment;
import util.JsonFile;

public class CommentRepository {
    private static final String FILE = "storage/comments.json";
    
    public List<Comment> getAll() {
        List<Comment> comments = JsonFile.readList(FILE, new TypeReference<List<Comment>>() {});
        return comments;
    }

   public void saveAll(List<Comment> comments) {
    JsonFile.writeList(FILE, comments);
   }

   public Comment getCommentById(long id) {
    return getAll().stream().filter(comment -> comment.getId() == id).findFirst().orElseThrow();
   }
   /* public List<Comment> getCommentsByPostId(long postId) {
    List<Comment> comments = getAll().stream().filter(c -> c.getPostById() == postId).toList();
    return comments;
   } */
}
