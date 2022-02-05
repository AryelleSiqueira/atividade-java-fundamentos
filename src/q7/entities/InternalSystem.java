package q7.entities;

public class InternalSystem {

    private Database database;

    public InternalSystem(Database database) {
        this.database = database;
    }

    /**
     * Logs user in to the system if credentials are correct.
     * @param username user's username/login
     * @param password user's password
     * @throws FailedToLogInException if credentials (username and/or password) are incorrect
     */
    public User logIn(String username, String password) {
        User user = database.getUserByUsername(username); // searches for user in database

        if (user == null) {     // if user is not found
            throw new FailedToLogInException("Invalid username and/or password");
        }
        if (!user.authenticate(password)) { // if password is incorrect
            throw new FailedToLogInException("Invalid username and/or password");
        }
        return user;
    }
}
