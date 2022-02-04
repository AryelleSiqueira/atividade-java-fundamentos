package q7.entities;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private Map<String, User> dataBase;

    public Database() {
        dataBase = new HashMap<>();
    }

    public User getUserByUsername(String username) {
        return this.dataBase.get(username);
    }

    public void registerUser(User user) {
        dataBase.put(user.getUsername(), user);
    }
}
