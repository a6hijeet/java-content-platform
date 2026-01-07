package service;

import model.User;

public class UserService {
  public User createUser(long id, String name) {
    User u = new User(id, name);
    return u;
  }
}
