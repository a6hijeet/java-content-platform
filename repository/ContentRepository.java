package repository;

import java.util.List;
import java.util.Optional;

public interface ContentRepository {
  <T> List<T> getAll();
  <T> Optional<T> findById();
  <T> T save(Class<T> t);
}
