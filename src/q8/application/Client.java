package q8.application;

import q8.entities.Employee;
import q8.entities.InvalidValueException;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        List<Employee> employeeList = new LinkedList<>();

        // Asks for and reads number of employees to be registered
        Scanner sc = new Scanner(System.in);

        Integer nEmployees = null;

        while (nEmployees == null) { // repeats until a valid input is given
            System.out.print(">> Number of employees you want to register: ");
            try {
                nEmployees = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] Invalid input! Try again");
            }
            sc.nextLine();
        }
        System.out.println("----------------------------------------");

        // Reads and saves employee data
        for (int i = 0; i < nEmployees; i++) {
            System.out.println("Registering employee #" + (i + 1) + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();

            Double salary = null;
            Employee employee = null;

            // Reads salary
            while (salary == null || employee == null) { // repeats until a valid input is given
                System.out.print("Salary: ");
                try {
                    salary = sc.nextDouble();
                    employee = new Employee(name, salary);
                }
                catch (InputMismatchException e) { // input is not a double value
                    System.out.println("[ERROR] Invalid input! Try again");
                }
                catch (InvalidValueException e) { // negative salary
                    System.out.println("[ERROR] " + e.getMessage() + " Try again");
                }
                sc.nextLine();
            }
            employeeList.add(employee);

            System.out.println("----------------------------------------");
        }
        sc.close();

        // Prints list of employees
        for (Employee e : employeeList) {
            System.out.println(e + "\n");
        }
    }
}
