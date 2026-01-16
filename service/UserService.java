package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import model.User;
import model.dto.UserDto;
import repository.impl.UserRepository;

public class UserService {

  UserRepository userRepo = new UserRepository();

  public boolean createUser(long id, String name) {
    List<User> users = userRepo.getAll();
    User user = new User(id, name);
    users.add(user);
    userRepo.saveAll(users);
    return true;
  }

  public boolean updateUser(long id, String name) {
    try {
      User u = userRepo.getUserById(id);
      List<User> userList = userRepo.getAll();
      int index = userList.indexOf(u);

      u.setId(id);
      u.setName(name);

      userList.set(index, u);
      userRepo.saveAll(userList);
      return true;
    } catch (Exception e) {
      System.out.println("No user found");
      return false;
    }
  }

  public boolean deleteUser(long id) {
    try {
      User u = userRepo.getUserById(id);

      List<User> userList = userRepo.getAll();
      int index = userList.indexOf(u);

      userList.remove(index);
      userRepo.saveAll(userList);
      return true;
    } catch(Exception e) {
      System.out.println("No user found");
      return false;
    }
  }

  public UserDto getUserById(long id) {
    List<User> users = userRepo.getAll();
    User u = users.stream().filter(user -> user.getId() == id).findFirst().orElseThrow();
    return new UserDto(u.getId(), u.getName());
  }

  public List<User> getAll() {
    return userRepo.getAll();
  }
}
