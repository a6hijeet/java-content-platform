package repository.impl;

import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import model.User;
import util.JsonFile;

public class UserRepository {
    private static final String FILE = "storage/users.json";
    
    public List<User> getAll() {
        List<User> users = JsonFile.readList(FILE, new TypeReference<List<User>>() {});
        return users;
    }

   public void saveAll(List<User> users) {
    JsonFile.writeList(FILE, users);
   }
}
