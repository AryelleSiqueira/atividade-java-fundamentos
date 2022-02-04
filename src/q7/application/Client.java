package q7.application;

import q7.entities.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        // Register users
        Database db = new Database();
        db.registerUser(new User("Maria Ribeiro", "maria37", "123456"));
        db.registerUser(new User("Aryelle Gomes", "aryelle","123456"));
        db.registerUser(new User("Matheus Fernandes", "matheus", "123456"));
        db.registerUser(new User("Ana Peixoto", "ana123", "123456"));

        InternalSystem sys = new InternalSystem(db);

        // Reads user's login and password
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your login: ");
        String username = sc.nextLine();

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        // Logs in to system
        try {
            sys.logIn(username, password);
            System.out.println(getMessage() + ", you've successfully logged in to our system.");
        }
        catch (FailedToLogInException e) {      // login and/or password invalid
            System.out.println(e.getMessage());
        }

        sc.close();
    }


    public static String getMessage() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
        String[] time = LocalTime.now().format(df).split(":");
        int hour = Integer.parseInt(time[0]);

        if (hour >= 0 && hour < 6) {
            return "Good madrugation";
        }
        else if (hour < 12) {
            return "Good mourning";
        }
        else if (hour < 18) {
            return "Good afternoon";
        }
        else {
            return "Good evening";
        }
    }

}