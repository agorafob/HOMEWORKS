package hw07paycheck_version2.employees;

public class OtherEmployees extends Employee {
    private String description;


    public OtherEmployees(String name, String surname, int yearB, int monthB, int dateB, int yearW, int monthW, int dateW, String department,String description) {
        super(name, surname, yearB, monthB, dateB, yearW, monthW, dateW, department);
        setDescription(description);
    }

    public OtherEmployees(String name, String surname, UserDate birthday, UserDate startWorking, String department, double salary) {
        super(name, surname, birthday, startWorking, department, salary);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "OtherEmployees{" +
                "name='" + super.getName() + '\'' +
                ", surname='" + super.getSurname() + '\'' +
                ", birthday=" + super.getBirthday().toString() +
                ", startWorking=" + super.getStartWorking().toString() +
                ", department='" + super.getDepartment() + '\'' +
                ", salary=" + super.getSalary() +'\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
