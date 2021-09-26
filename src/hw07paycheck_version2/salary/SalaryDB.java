package hw07paycheck_version2.salary;

import hw07paycheck_version2.employees.AllEmployees;

public abstract class SalaryDB {
    public static final double SALARY_FUND = 5000.0;
    public static final double TAX = 0.195;
    public static final double BIRTHDAY_GIFT = 0.005;
    public static final double MANAGERS_BONUS = 0.005;
    private static double BIRTHDAY_FUND;
    private static double MANAGERS_FUND;


    public static void setBirthdayFund() {
        int employeeNumber = AllEmployees.getEmployeeNumber();
        BIRTHDAY_FUND = (SALARY_FUND * BIRTHDAY_GIFT) * employeeNumber;
    }

    public static double getBirthdayFund() {
        return BIRTHDAY_FUND;
    }

    public static void setManagersFund() {
        MANAGERS_FUND = AllEmployees.numberOfWorkers()* MANAGERS_BONUS;
    }

    public static double getManagersFund() {
        return MANAGERS_FUND;
    }
}