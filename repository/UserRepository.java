package repository;

import java.util.Optional;

import model.User;

public interface UserRepository {
  User save(User user);
  Optional<User> findById(long id);
}
