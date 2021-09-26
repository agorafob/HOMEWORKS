package hw07paycheck_version2.employees;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class AllEmployees {
    public static List<Employee> employeeList = new ArrayList<>();
    public static List<Employee> hr = new ArrayList<>();
    public static List<Employee> logistics = new ArrayList<>();
    public static List<Employee> otherWorkers = new ArrayList<>();
    private static int employeeNumber;

    static Worker alex = new Worker("Alex", "Petrov", 1998, 8, 23, 2018, 2, 20, "hr");
    static Worker yulia = new Worker("Yulia", "Ivanova", 1995, 6, 12, 2016, 7, 3, "hr");
    static Manager anna = new Manager("Anna", "Kuzmina", 1990, 4, 14, 2010, 9, 6, "hr");

    static Worker igor = new Worker("Igor", "Yarovoi", 1988, 7, 13, 2015, 4, 10, "logistics");
    static Worker vlad = new Worker("Vlad", "Orlov", 1989, 6, 3, 2015, 5, 20, "logistics");
    static Manager marina = new Manager("Marina", "Ivanova", 1986, 3, 14, 2010, 5, 14, "logistics");

    static OtherEmployees svetlana = new OtherEmployees("Svetlana", "Sorokina", 1999, 11, 28, 2019, 11, 3, "directorat", "secretary");
    static OtherEmployees vladimir = new OtherEmployees("Vladimir", "Vlasov", 1980, 11, 4, 2002, 6, 5, "directorat", "finansist");


    private static void addAll() {
        employeeList.add(alex);
        employeeList.add(yulia);
        employeeList.add(anna);
        employeeList.add(igor);
        employeeList.add(vlad);
        employeeList.add(marina);
        employeeList.add(svetlana);
        employeeList.add(vladimir);
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
                case ("directorat"):
                    otherWorkers.add(e);
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

    public static int numberOfEmployeesInDepartment(List<Employee> employees) {
        int counter = 0;
        for (Employee e : employees) {
            if (e != null) {
                counter++;
            }
        }
        return counter;
    }

    public static int numberOfDepartments() {
        String temp = "";
        int counter = 0;
        for (Employee e : employeeList) {
            if (!e.getDepartment().equals(temp)) {
                temp = e.getDepartment();
                counter++;
            }
        }
        return counter;
    }

    public static void addEmployee(Employee e) {
        employeeList.add(e);
        employeeNumber++;
        switch (e.getDepartment()) {
            case ("hr"):
                hr.add(e);
                break;
            case ("logistics"):
                logistics.add(e);
                break;
            case ("directorat"):
                otherWorkers.add(e);
                break;
        }
    }

    public static void deleteEmployee(Employee e) {
        employeeNumber--;
        employeeList.remove(e);
        hr.remove(e);
        logistics.remove(e);
        otherWorkers.remove(e);
    }

    public static void changeType(Employee e, String newPosition, String description) {
        switch (newPosition) {
            case ("worker"):
                deleteEmployee(e);
                Worker worker = new Worker(e.getName(), e.getSurname(), e.getBirthday(), e.getStartWorking(), e.getDepartment(), e.getSalary());
                addEmployee(worker);
                break;
            case ("manager"):
                deleteEmployee(e);
                Manager manager = new Manager(e.getName(), e.getSurname(), e.getBirthday(), e.getStartWorking(), e.getDepartment(), e.getSalary());
                manager.setWorkers(getWorkersInDepartment(manager));
                addEmployee(manager);
                break;
            case ("directorat"):
                deleteEmployee(e);
                OtherEmployees other = new OtherEmployees(e.getName(), e.getSurname(), e.getBirthday(), e.getStartWorking(), e.getDepartment(), e.getSalary());
                other.setDescription(description);
                addEmployee(other);
                break;
        }
    }

    private static List<Employee> getWorkersInDepartment(Manager manager) {
        List<Employee> workersInDepartment = new ArrayList<>();
        String departmentName = manager.getDepartment();
        int counter = -1;
        for (Employee e : employeeList) {
            if (e.getDepartment().equals(departmentName)) {
                workersInDepartment.add(e);
               counter++;
            }
        }
        manager.setNumberOfWorkers(counter);
        return workersInDepartment;
    }

    private static void sortWorkersToManagers() {
        for (Employee e : employeeList) {
            if (e instanceof Manager) {
                ((Manager) e).setWorkers(getWorkersInDepartment((Manager)e));
            }
        }
    }

    public void sortBySurname(List<Employee> employees){
        employees.sort(Comparator.comparing(Employee::getSurname));
    }

    public void sortByWorkDate(List<Employee> employees){
       Collections.sort(employees, Comparator.comparing(o -> o.getStartWorking().getDate()));
    }
    public void fireManager(List<Employee>employees){
        for (Employee e:employees) {
            if(e instanceof Manager){
                employees.remove(e);
                employeeList.remove(e);
                employeeNumber--;
            }
        }
        sortByWorkDate(employees);
        changeType(employees.get(numberOfEmployeesInDepartment(employees)-1),"manager","");
    }

    public static int numberOfWorkers(){
        int counter=0;
        for (Employee e:employeeList) {
            if(e instanceof Worker){
                counter++;
            }
        }
        return counter;
    }

    public static void start() {
        AllEmployees.sortEmployees();
        AllEmployees.setEmployeeNumber();
        AllEmployees.sortWorkersToManagers();
    }



}