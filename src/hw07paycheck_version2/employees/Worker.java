package hw07paycheck_version2.employees;

public class Worker extends Employee{

    public Worker(String name, String surname, int yearB, int monthB, int dateB, int yearW, int monthW, int dateW, String department) {
        super(name, surname, yearB, monthB, dateB, yearW, monthW, dateW, department);
    }

    public Worker(String name, String surname, UserDate birthday, UserDate startWorking, String department, double salary) {
        super(name, surname, birthday, startWorking, department, salary);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + super.getName() + '\'' +
                ", surname='" + super.getSurname() + '\'' +
                ", birthday=" + super.getBirthday().toString() +
                ", startWorking=" + super.getStartWorking().toString() +
                ", department='" + super.getDepartment() + '\'' +
                ", salary=" + super.getSalary() +
                '}';
    }




}
