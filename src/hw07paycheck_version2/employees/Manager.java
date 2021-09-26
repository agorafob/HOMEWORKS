package hw07paycheck_version2.employees;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee{
    private List<Employee> workers = new ArrayList<>();
    private int numberOfWorkers;


    public Manager(String name, String surname, int yearB, int monthB, int dateB, int yearW, int monthW, int dateW, String department) {
        super(name, surname, yearB, monthB, dateB, yearW, monthW, dateW, department);
    }

    public Manager(String name, String surname, UserDate birthday, UserDate startWorking, String department, double salary) {
        super(name, surname, birthday, startWorking, department, salary);
    }

    public void setWorkers(List<Employee> workers) {
        this.workers = workers;
    }

    public void addWorkers(Worker worker){
        workers.add(worker);
    }

    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public void setNumberOfWorkers(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + super.getName() + '\'' +
                ", surname='" + super.getSurname() + '\'' +
                ", birthday=" + super.getBirthday().toString() +
                ", startWorking=" + super.getStartWorking().toString() +
                ", department='" + super.getDepartment() + '\'' +
                ", salary=" + super.getSalary() +'\'' +
                ", numberOfWorkers=" + numberOfWorkers +
                '}';
    }
}
