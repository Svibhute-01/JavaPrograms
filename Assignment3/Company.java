import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected String address;
    protected double salary;
    protected String jobTitle;

    public Employee(String n, String a, double s, String j) {
        name = n;
        address = a;
        salary =s;
        jobTitle = j;
    }

    public abstract double calculateBonus();
    public abstract String generatePerformanceReport();
}

class Manager extends Employee {
    private int managedProjects;

    public Manager(String name, String address, double salary, int managedProjects) {
        super(name, address, salary, "Manager");
        managedProjects = managedProjects;
    }

    public double calculateBonus() {
        return salary * 0.2 + managedProjects * 500;
    }

    public String generatePerformanceReport() {
        return name + " is managing " + managedProjects + " projects with high efficiency.";
    }
}

class Developer extends Employee {
    private int completedTasks;

    public Developer(String name, String address, double salary, int completedTasks) {
        super(name, address, salary, "Developer");
        completedTasks = completedTasks;
    }

    public double calculateBonus() {
        return salary * 0.15 + completedTasks * 200;
    }

    public String generatePerformanceReport() {
        return name + " has successfully completed " + completedTasks + " tasks this quarter.";
    }
}

class Programmer extends Employee {
    private int codeLines;

    public Programmer(String name, String address, double salary, int codeLines) {
        super(name, address, salary, "Programmer");
        codeLines = codeLines;
    }

    public double calculateBonus() {
        return salary * 0.1 + codeLines * 0.1;
    }

    public String generatePerformanceReport() {
        return name + " has written " + codeLines + " lines of code with great efficiency.";
    }
}

public class Company {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Manager Name: ");
        String managerName = scanner.nextLine();
        System.out.print("Enter Manager Address: ");
        String managerAddress = scanner.nextLine();
        System.out.print("Enter Manager Salary: ");
        double managerSalary = scanner.nextDouble();
        System.out.print("Enter Number of Managed Projects: ");
        int managedProjects = scanner.nextInt();
        scanner.nextLine();
        Manager manager = new Manager(managerName, managerAddress, managerSalary, managedProjects);

        System.out.print("Enter Developer Name: ");
        String devName = scanner.nextLine();
        System.out.print("Enter Developer Address: ");
        String devAddress = scanner.nextLine();
        System.out.print("Enter Developer Salary: ");
        double devSalary = scanner.nextDouble();
        System.out.print("Enter Number of Completed Tasks: ");
        int completedTasks = scanner.nextInt();
        scanner.nextLine();
        Developer developer = new Developer(devName, devAddress, devSalary, completedTasks);

        System.out.print("Enter Programmer Name: ");
        String progName = scanner.nextLine();
        System.out.print("Enter Programmer Address: ");
        String progAddress = scanner.nextLine();
        System.out.print("Enter Programmer Salary: ");
        double progSalary = scanner.nextDouble();
        System.out.print("Enter Number of Lines of Code Written: ");
        int codeLines = scanner.nextInt();
        Programmer programmer = new Programmer(progName, progAddress, progSalary, codeLines);

        System.out.println(manager.generatePerformanceReport());
        System.out.println("Bonus: " + manager.calculateBonus());
        
        System.out.println(developer.generatePerformanceReport());
        System.out.println("Bonus: " + developer.calculateBonus());
        
        System.out.println(programmer.generatePerformanceReport());
        System.out.println("Bonus: " + programmer.calculateBonus());
        
        scanner.close();
    }
}
