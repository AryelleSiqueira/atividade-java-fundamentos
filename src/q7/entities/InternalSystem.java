package q7.entities;

public class InternalSystem {

    private Database database;

    public InternalSystem(Database database) {
        this.database = database;
    }

    public void logIn(String username, String password) {
        User user = database.getUserByUsername(username);

        if (user == null) {
            throw new FailedToLogInException("Invalid username and/or password");
        }
        if (!user.authenticate(password)) {
            throw new FailedToLogInException("Invalid username and/or password");
        }
    }
}
