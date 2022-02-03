package q8.entities;

public class Employee {

    String name;
    double salary;


    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    /**
     * @return employee's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return employee's salary
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * @return employee's liquid salary
     */
    public double getLiquidSalary() {
        return this.salary + this.getBonification();
    }

    /**
     * @return -
     */
    public double getBonification() {
        if (this.salary <= 1000.0) {
            return this.salary * 0.2;
        }
        if (this.salary <= 2000.0) {
            return this.salary * 0.1;
        }
        return this.salary * -0.1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Employee ");
        sb.append(this.name);
        sb.append("\nSalary: ");
        sb.append(String.format("%.2f", this.salary));

        double bonus = getBonification();
        if (bonus < 0) {
            sb.append("\nDiscount: ");
            bonus *= -1;
        } else {
            sb.append("\nBonus: ");
        }
        sb.append(String.format("%.2f", bonus));
        sb.append("\nLiquid salary: ");
        sb.append(String.format("%.2f", this.getLiquidSalary()));

        return sb.toString();
    }
}
