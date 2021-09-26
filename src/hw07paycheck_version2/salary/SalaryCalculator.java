package hw07paycheck_version2.salary;

import hw07paycheck_version2.employees.AllEmployees;
import hw07paycheck_version2.employees.Employee;
import hw07paycheck_version2.employees.Manager;

import java.util.Calendar;
import java.util.List;


public abstract class SalaryCalculator {

    public static void start(int currentMonth, int option) {
        SalaryDB.setBirthdayFund();
        SalaryDB.setManagersFund();
        chooseOption(option, currentMonth);
    }

    private static double salaryCalculatorEven(Employee e, int currentMonth) {
        double salaryFinal;
        if (e instanceof Manager) {
            double salaryWithBirthdayAndBonus;
            double bonus = SalaryDB.MANAGERS_BONUS * ((Manager) e).getNumberOfWorkers();
            double salaryWithoutBirthdayAndBonus = (SalaryDB.SALARY_FUND - SalaryDB.getBirthdayFund() - SalaryDB.getManagersFund()) / AllEmployees.getEmployeeNumber();
            if (e.getBirthday().getDate().get(Calendar.MONTH) + 1 == currentMonth) {
                salaryWithBirthdayAndBonus = salaryWithoutBirthdayAndBonus + bonus + (SalaryDB.SALARY_FUND * SalaryDB.BIRTHDAY_GIFT);
                salaryFinal = salaryWithBirthdayAndBonus - (salaryWithBirthdayAndBonus * SalaryDB.TAX);
            } else {
                salaryFinal = (salaryWithoutBirthdayAndBonus + bonus) - ((salaryWithoutBirthdayAndBonus + bonus) * SalaryDB.TAX);
            }
        } else {
            double salaryWithBirthday;
            double salaryWithoutBirthday = (SalaryDB.SALARY_FUND - SalaryDB.getBirthdayFund() - SalaryDB.getManagersFund()) / AllEmployees.getEmployeeNumber();
            if (e.getBirthday().getDate().get(Calendar.MONTH) + 1 == currentMonth) {
                salaryWithBirthday = salaryWithoutBirthday + (SalaryDB.SALARY_FUND * SalaryDB.BIRTHDAY_GIFT);
                salaryFinal = salaryWithBirthday - (salaryWithBirthday * SalaryDB.TAX);
            } else {
                salaryFinal = salaryWithoutBirthday - (salaryWithoutBirthday * SalaryDB.TAX);
            }
        }
        return salaryFinal;
    }


    private static double salaryCalculatorProportion(List<Employee> employees, Employee e, int currentMonth) {
        int numberOfEmployees = AllEmployees.numberOfEmployeesInDepartment(employees);
        int numberOfDepartments = AllEmployees.numberOfDepartments();
        double salaryFinal;
        if (e instanceof Manager) {
            double salaryWithBirthdayAndBonus;
            double bonus = SalaryDB.MANAGERS_BONUS * ((Manager) e).getNumberOfWorkers();
            double salaryWithoutBirthdayAndBonus = ((SalaryDB.SALARY_FUND - SalaryDB.getBirthdayFund() - SalaryDB.getManagersFund()) / numberOfDepartments / numberOfEmployees);
            if (e.getBirthday().getDate().get(Calendar.MONTH) + 1 == currentMonth) {
                salaryWithBirthdayAndBonus = salaryWithoutBirthdayAndBonus + bonus + (SalaryDB.SALARY_FUND * SalaryDB.BIRTHDAY_GIFT);
                salaryFinal = salaryWithBirthdayAndBonus - (salaryWithBirthdayAndBonus * SalaryDB.TAX);
            } else {
                salaryFinal = (salaryWithoutBirthdayAndBonus + bonus) - ((salaryWithoutBirthdayAndBonus + bonus) * SalaryDB.TAX);
            }
        } else {
            double salaryWithBirthday;
            double salaryWithoutBirthday = (SalaryDB.SALARY_FUND - SalaryDB.getBirthdayFund() - SalaryDB.getManagersFund()) / numberOfDepartments / numberOfEmployees;
            if (e.getBirthday().getDate().get(Calendar.MONTH) + 1 == currentMonth) {
                salaryWithBirthday = salaryWithoutBirthday + (SalaryDB.SALARY_FUND * SalaryDB.BIRTHDAY_GIFT);
                salaryFinal = salaryWithBirthday - (salaryWithBirthday * SalaryDB.TAX);
            } else {
                salaryFinal = salaryWithoutBirthday - (salaryWithoutBirthday * SalaryDB.TAX);
            }
        }
        return salaryFinal;
    }


//
    private static void distributeSalaryEvenly(List<Employee> employees, int currentMonth) {
        for (int i = 0; i < AllEmployees.getEmployeeNumber(); i++) {
            employees.get(i).setSalary(salaryCalculatorEven(employees.get(i), currentMonth));
        }
    }

    private static void distributeSalaryProportion(List<Employee> employees, int currentMonth) {
        for (int i = 0; i < AllEmployees.numberOfEmployeesInDepartment(employees); i++) {
            employees.get(i).setSalary(salaryCalculatorProportion(employees,employees.get(i), currentMonth));
        }
    }

    private static void chooseOption(int option,int currentMonth){
        switch (option){
            case (1):
                distributeSalaryEvenly(AllEmployees.employeeList, currentMonth);break;
            case (2):
                distributeSalaryProportion(AllEmployees.hr,currentMonth);
                distributeSalaryProportion(AllEmployees.logistics,currentMonth);
                distributeSalaryProportion(AllEmployees.otherWorkers,currentMonth);
        }
    }


}