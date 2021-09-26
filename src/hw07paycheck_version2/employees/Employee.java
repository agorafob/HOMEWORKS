package hw07paycheck_version2.employees;

public abstract class Employee {

    private String name;
    private String surname;
    private UserDate birthday;
    private UserDate startWorking;
    private String department;
    private double salary;

    public Employee(String name, String surname, int yearB, int monthB, int dateB, int yearW, int monthW, int dateW, String department) {
        setName(name);
        setSurname(surname);
        setBirthday(yearB, monthB, dateB);
        setStartWorking(yearW, monthW, dateW);
        setDepartment(department);
    }

    public Employee(String name, String surname, UserDate birthday, UserDate startWorking, String department, double salary) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.startWorking = startWorking;
        this.department = department;
        this.salary = salary;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    private void setBirthday(int year, int month, int date) {
        this.birthday = new UserDate(year, month, date);
    }

    private void setStartWorking(int year, int month, int date) {
        this.startWorking = new UserDate(year, month, date);
    }

    private void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public UserDate getBirthday() {
        return birthday;
    }

    public UserDate getStartWorking() {
        return startWorking;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }



}