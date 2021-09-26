package hw07paycheck_version1.salary;

import hw07paycheck_version1.employees.AllEmployees;
import hw07paycheck_version1.employees.Employee;

import java.util.List;

public abstract class SalaryDB {
    public static final double SALARY_FUND = 5000.0;
    public static final double TAX = 0.195;
    public static final double BIRTHDAY_GIFT = 0.01;
    private static double BIRTHDAY_FUND;

    public static void setBirthdayFund(List<Employee> employees) {
        int employeeNumber = AllEmployees.getEmployeeNumber();
        BIRTHDAY_FUND = (SALARY_FUND * BIRTHDAY_GIFT) * employeeNumber;
    }

    public static double getBirthdayFund() {
        return BIRTHDAY_FUND;
    }
}