public class Employee {
    private String name;
    private int id;
    private double salary;
    private String department;
    private static final double BONUS_RATE = 0.1;

    public Employee(String name, int id, double salary, String department) {
        this.name = name;  
        this.id = id;
        this.salary = salary;
        this.department = department;
    }

    public void printDetails() {
        System.out.println("Employee ID: " + id);  
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
    }

    public void applyBonus() {
        salary += getBonus();
        System.out.println("Bonus applied! New salary: " + salary);
    }

    private double getBonus() {
        double bonus = salary * BONUS_RATE;
        return bonus;
    }

    public void updateDepartment(String newDepartment) {
        department = newDepartment;  
        System.out.println("Department updated to: " + department);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
