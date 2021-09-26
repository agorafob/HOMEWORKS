package hw07paycheck_version1.salary;

import hw07paycheck_version1.employees.AllEmployees;
import hw07paycheck_version1.employees.Employee;

import java.util.List;

public abstract class SalaryCalculator {

    public static void start(String currentMonth, int option) {
        SalaryDB.setBirthdayFund(AllEmployees.employeeList);
        chooseOption(option, currentMonth);
    }

    private static double salaryCalculatorEven(Employee employee, String currentMonth) {
        double salaryWithoutBirthday = (SalaryDB.SALARY_FUND - SalaryDB.getBirthdayFund()) / AllEmployees.getEmployeeNumber();
        double salaryWithBirthday;
        double salaryFinal;
        if (employee.getBirthdayMonth().equals(currentMonth)) {
            salaryWithBirthday = salaryWithoutBirthday + (SalaryDB.SALARY_FUND * SalaryDB.BIRTHDAY_GIFT);
            salaryFinal = salaryWithBirthday - (salaryWithBirthday * SalaryDB.TAX);
        } else {
            salaryFinal = salaryWithoutBirthday - (salaryWithoutBirthday * SalaryDB.TAX);
        }
        return salaryFinal;
    }

    private static double salaryCalculatorProportion(List<Employee> employees,Employee employee, String currentMonth){
        int numberOfEmployees = AllEmployees.numberOfEmployeesInDepartment(employees);
        int numberOfDepartments = AllEmployees.numberOfDepartments();
        double salaryWithoutBirthday = (SalaryDB.SALARY_FUND - SalaryDB.getBirthdayFund()) / numberOfDepartments/numberOfEmployees;
        double salaryWithBirthday;
        double salaryFinal;
        if (employee.getBirthdayMonth().equals(currentMonth)) {
            salaryWithBirthday = salaryWithoutBirthday + (SalaryDB.SALARY_FUND * SalaryDB.BIRTHDAY_GIFT);
            salaryFinal = salaryWithBirthday - (salaryWithBirthday * SalaryDB.TAX);
        } else {
            salaryFinal = salaryWithoutBirthday - (salaryWithoutBirthday * SalaryDB.TAX);
        }
        return salaryFinal;
    }

    private static void distributeSalaryEvenly(List<Employee> employees, String currentMonth) {
        for (int i = 0; i < AllEmployees.getEmployeeNumber(); i++) {
            employees.get(i).setSalary(salaryCalculatorEven(employees.get(i), currentMonth));
        }
    }

    private static void distributeSalaryProportion(List<Employee> employees, String currentMonth) {
        for (int i = 0; i < AllEmployees.numberOfEmployeesInDepartment(employees); i++) {
            employees.get(i).setSalary(salaryCalculatorProportion(employees,employees.get(i), currentMonth));
        }
    }

    private static void chooseOption(int option,String currentMonth){
        switch (option){
            case (1):
                distributeSalaryEvenly(AllEmployees.employeeList, currentMonth);break;
            case (2):
                distributeSalaryProportion(AllEmployees.hr,currentMonth);
                distributeSalaryProportion(AllEmployees.logistics,currentMonth);
                distributeSalaryProportion(AllEmployees.workers,currentMonth);break;
        }
    }




}