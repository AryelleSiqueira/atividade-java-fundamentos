package q7.entities;

public class User {

    public String name;
    public String username;
    public String password;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    /**
     * @return user's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param password to be compared to user's real password
     * @return boolean indicating if password is correct or not
     */
    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nUsername: " + username;
    }
}
