package q7.entities;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private Map<String, User> dataBase; // collection of registered users

    public Database() {
        dataBase = new HashMap<>();
    }

    /**
     * @param username the key whose associated user is to be returned
     * @return the user to which the specified key (username) is mapped, or null if user's not found
     */
    public User getUserByUsername(String username) {
        return this.dataBase.get(username);
    }

    /**
     * Adds user to database
     * @param user to be registered
     */
    public void registerUser(User user) {
        dataBase.put(user.getUsername(), user);
    }
}
