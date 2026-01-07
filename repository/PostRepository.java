package repository;

import java.util.List;
import java.util.Optional;

import model.Post;

public interface PostRepository {
  List<Post> getAll();
  Optional<Post> findById();
  Post save(Post post);
}
