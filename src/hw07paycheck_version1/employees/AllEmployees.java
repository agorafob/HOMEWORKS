package hw07paycheck_version1.employees;

import java.util.ArrayList;
import java.util.List;

public abstract class AllEmployees {
    public static List<Employee> employeeList = new ArrayList<>();
    public static List<Employee> hr = new ArrayList<>();
    public static List<Employee> logistics = new ArrayList<>();
    public static List<Employee> workers = new ArrayList<>();
    private static int employeeNumber;

    static Employee alex = new Employee("Alex", "january", "hr");
    static Employee yulia = new Employee("Yulia", "february", "hr");
    static Employee anna = new Employee("Anna", "march", "hr");

    static Employee igor = new Employee("Igor", "april", "logistics");
    static Employee vlad = new Employee("Vlad", "april", "logistics");

    static Employee sergey = new Employee("Sergey", "may", "worker");
    static Employee maxim = new Employee("Maksim", "june", "worker");
    static Employee ivan = new Employee("Ivan", "june", "worker");
    static Employee anton = new Employee("Anton", "april", "worker");


    private static void addAll() {
        employeeList.add(alex);
        employeeList.add(yulia);
        employeeList.add(anna);
        employeeList.add(igor);
        employeeList.add(vlad);
        employeeList.add(sergey);
        employeeList.add(maxim);
        employeeList.add(ivan);
        employeeList.add(anton);
    }

    private static void sortEmployees() {
        addAll();
        for (Employee e : employeeList) {
            switch (e.getDepartment()) {
                case ("hr"):
                    hr.add(e);
                    break;
                case ("logistics"):
                    logistics.add(e);
                    break;
                case ("worker"):
                    workers.add(e);
                    break;
            }
        }
    }

    private static void setEmployeeNumber() {
        for (Employee employee : employeeList) {
            if (employee != null) {
                employeeNumber++;
            }
        }
    }

    public static int getEmployeeNumber() {
        return employeeNumber;
    }

    public static void print() {
        for (Employee e : employeeList) {
            System.out.println(e.toString());

        }
    }

    public static int numberOfEmployeesInDepartment(List<Employee> employees){
        int counter=0;
        for (Employee e:employees) {
            if(e!=null){
                counter++;
            }
        }
        return counter;
    }

    public static int numberOfDepartments(){
        String temp="";
        int counter=0;
        for (Employee e:employeeList) {
            if(!e.getDepartment().equals(temp)){
                temp=e.getDepartment();
                counter++;
            }
        }
        return counter;
    }


    public static void start() {
        AllEmployees.sortEmployees();
        AllEmployees.setEmployeeNumber();
    }
}