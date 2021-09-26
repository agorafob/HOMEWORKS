package hw07paycheck_version2.runner;

import hw07paycheck_version2.controller.Controller;
import hw07paycheck_version2.employees.AllEmployees;
import hw07paycheck_version2.salary.SalaryCalculator;
import hw07paycheck_version2.view.View;

import java.util.Scanner;

public class Runner {

    public void run() {
        View.print(View.START_MESSAGE);
        Scanner sc = new Scanner(System.in);
        int currentMonth = Controller.correctMonth(sc);
        View.print(View.OPTION_MESSAGE);
        int option = Controller.correctOption(sc);
        AllEmployees.start();
        SalaryCalculator.start(currentMonth,option);
        AllEmployees.print();
    }
}