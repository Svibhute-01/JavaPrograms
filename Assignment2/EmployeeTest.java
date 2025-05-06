import java.util.*;

class Employee {
    
    String fname;
    String lname;
    double m_salary;

    public Employee() {
        fname = "";
        lname = "";
        m_salary = 0.0;
    }
    public void checkSalary(double M_salary){    
        if (m_salary<0){
            m_salary = 0.0;
        }
        else{
            this.m_salary = M_salary;
        }
    }
    
    public void getInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first name:");
        fname = sc.nextLine();
        System.out.println("Enter the last name:");
        lname = sc.nextLine();
        System.out.println("Enter the monthly salary:");
        m_salary = sc.nextDouble();
        sc.close();
    
    }
    public double getYearlySalary() {
        return m_salary * 12;
    }

    public double giveRaise() {
        return m_salary *= 1.10; 
    }
    public void displayInfo() {
        System.out.println("First Name: " + fname);
        System.out.println("Last Name: " + lname);
        System.out.println("Monthly Salary: " + m_salary);
        System.out.println("Yearly salary:"+ getYearlySalary());
        System.out.println("Monthly raise salary:"+ giveRaise());

    }
}

class EmployeeTest{
    public static void main(String args[]){
        Employee ob1 = new Employee();
        ob1.getInfo();
        ob1.getYearlySalary();
        ob1.giveRaise();
        ob1.displayInfo();
    }
}

