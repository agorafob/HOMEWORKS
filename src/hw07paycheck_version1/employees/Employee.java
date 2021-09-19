package hw07paycheck_version1.employees;

public class Employee {

    private String name;
    private String birthdayMonth;
    private String department;
    private double salary;


    public Employee(String name, String birthdayMonth, String department) {
        setName(name);
        setBirthdayMonth(birthdayMonth);
        setDepartment(department);

    }

    private void setName(String name) {
        this.name = name;
    }

    private void setBirthdayMonth(String birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }

    private void setDepartment(String department) {
        this.department = department;
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getBirthdayMonth() {
        return birthdayMonth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthdayMonth='" + birthdayMonth + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}