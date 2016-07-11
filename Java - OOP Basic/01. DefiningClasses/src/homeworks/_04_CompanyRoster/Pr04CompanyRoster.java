package homeworks._04_CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Employee{
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department, email, -1);
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }

    public Employee(String name, double salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Pr04CompanyRoster {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());
        Map<String, LinkedList<Employee>> employeesByDepartments = new LinkedHashMap<>();
        for (int i = 0; i < lines; i++) {
            String[] input = reader.readLine().split("\\s+");
            Employee currentEmployee = createEmployee(input);

            if (!employeesByDepartments.containsKey(currentEmployee.getDepartment())){
                employeesByDepartments.put(currentEmployee.getDepartment(), new LinkedList<>());
            }

            employeesByDepartments.get(currentEmployee.getDepartment()).add(currentEmployee);
        }

        String maxAverageSalaryDepartmentName = getMaxAverageSalaryDepartmentName(employeesByDepartments);
        employeesByDepartments.get(maxAverageSalaryDepartmentName)
                .sort((firstEmployee, secondEmployee) -> {
                    Double firstEmployeeSalary = firstEmployee.getSalary();
                    Double secondEmployeeSalary = secondEmployee.getSalary();

                    return secondEmployeeSalary.compareTo(firstEmployeeSalary);
                });

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartmentName);
        for (Employee employee : employeesByDepartments.get(maxAverageSalaryDepartmentName)) {
            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
        }
    }

    private static Employee createEmployee(String[] input){
        String name = input[0];
        Double salary = Double.parseDouble(input[1]);
        String position = input[2];
        String department = input[3];
        String email = "n/a";
        Integer age = -1;

        if (input.length == 5){
            if (input[4].contains("@")){
                email = input[4];
            } else {
                age = Integer.parseInt(input[4]);
            }
        }

        if (input.length == 6){
            email = input[4];
            age = Integer.parseInt(input[5]);
        }

        return new Employee(name, salary, position, department, email, age);
    }

    private static Double calculateDepartmentAverageSalary(List<Employee> departmentMembers){
        Double departmentTotalSalary = 0d;
        for (Employee employee : departmentMembers) {
            departmentTotalSalary += employee.getSalary();
        }

        return departmentTotalSalary / departmentMembers.size();
    }

    private static String getMaxAverageSalaryDepartmentName(Map<String, LinkedList<Employee>> departments){
        Double maxAverage = Double.MIN_VALUE;
        String departmentMaxAverageName = null;
        for (Map.Entry<String,LinkedList<Employee>> department : departments.entrySet()) {
            Double departmentAverageSalay = calculateDepartmentAverageSalary(department.getValue());
            if (departmentAverageSalay > maxAverage){
                maxAverage = departmentAverageSalay;
                departmentMaxAverageName = department.getKey();
            }
        }

        return departmentMaxAverageName;
    }
}
