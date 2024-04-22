package Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private String code;
    private double salaryRate;

    public Employee(int id, String name, int age, String department, String code, double salaryRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.code = code;
        this.salaryRate = salaryRate;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
        System.out.println("Code: " + code);
        System.out.println("Salary Rate: " + salaryRate);
        System.out.println("-------------------------");
    }

    public int getId() {
        return id;
    }
}

public class EmployeeManagementApp {
    private List<Employee> employees;

    public EmployeeManagementApp() {
        employees = new ArrayList<>();
    }

    public void displayEmployeeList() {
        for (Employee employee : employees) {
            employee.displayInfo();
        }
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    public void removeEmployee(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employees.remove(employee);
                System.out.println("Employee removed successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void addInitialEmployees() {
        Employee employee1 = new Employee(1, "Hanh", 30, "IT", "JD001", 5000.0);
        Employee employee2 = new Employee(2, "Đuc", 35, "HR", "JS001", 4500.0);
        Employee employee3 = new Employee(3, "Son", 28, "Marketing", "DJ001", 4800.0);
        Employee employee4 = new Employee(4, "Kien", 32, "Finance", "ED001", 5200.0);
        Employee employee5 = new Employee(5, "Hoa", 33, "Operations", "MW001", 4900.0);

        addEmployee(employee1);
        addEmployee(employee2);
        addEmployee(employee3);
        addEmployee(employee4);
        addEmployee(employee5);
    }

    public static void main(String[] args) {
        EmployeeManagementApp app = new EmployeeManagementApp();
        app.addInitialEmployees();

        Scanner scanner = new Scanner(System.in);

        int choice = -1;
        while (choice != 3) {
            System.out.println("Menu:");
            System.out.println("0. Display Employee List");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự new line sau khi đọc số

            switch (choice) {
                case 0:
                    System.out.println("Employee List:");
                    app.displayEmployeeList();
                    break;
                case 1:
                    System.out.println("Enter information for the new employee:");

                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Department: ");
                    String department = scanner.nextLine();

                    System.out.print("Code: ");
                    String code = scanner.nextLine();

                    System.out.print("Salary Rate: ");
                    double salaryRate = scanner.nextDouble();
                    scanner.nextLine();

                    Employee newEmployee = new Employee(id, name, age, department, code, salaryRate);
                    app.addEmployee(newEmployee);
                    break;
                case 2:
                    System.out.print("Enter the ID of the employee to remove: ");
                    int employeeIdToRemove = scanner.nextInt();
                    app.removeEmployee(employeeIdToRemove);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
}