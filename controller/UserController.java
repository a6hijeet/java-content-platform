package controller;

import java.util.List;

import model.User;
import model.dto.UserDto;
import service.UserService;

public class UserController {
     UserService ps = new UserService();
    public List<User> getAll() {
        List<User> userList =  ps.getAll();
        return userList;
    }

    public UserDto getUserById(long userId){
        return ps.getUserById(userId);
    }

    public boolean createUser(long id, String title, String password) {
        return ps.createUser(id, title, password);
    }

    public boolean updateUSer(long id, String name) {
        return ps.updateUser(id, name);
    }

    public boolean deleteUSer(long id) {
        return ps.deleteUser(id);
    }

}
