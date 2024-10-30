package tugas_2;

public class Main {

    public static void main(String[] args) {
        Employee emp = new Employee("John Dee", 12345, 75000, "Engineering");
        Project proj = new Project("AI Development", "2024-12-31", emp, 100000);
        Client client = new Client("Acme Corp", "contact@acme.com", proj);
        client.printClientDetails();
        emp.applyBonus();
        emp.updateDepartment("Research and Development");
        proj.updateBudget(120000);
    }

}
