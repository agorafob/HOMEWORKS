package hw07paycheck_version2.controller;

import hw07paycheck_version2.view.View;

import java.util.Scanner;

public class Controller {

    public static int correctMonth(Scanner sc) {
        String temp = "";
        int month = 0;
        try {
            temp=sc.nextLine();
            while (Integer.parseInt(temp) <=0 & Integer.parseInt(temp) >12) {
                View.print(View.WARNING);
                View.print(View.OPTION_MESSAGE);
                temp = sc.nextLine();
            }
            month = Integer.parseInt(temp);
        } catch (Exception e) {
            View.print(View.WARNING);
            System.exit(0);
        }
        return month;
    }


    public static int correctOption(Scanner sc) {
        String temp = "";
        int option = 0;
        try {
            temp=sc.nextLine();
            while (Integer.parseInt(temp) != 1 & Integer.parseInt(temp) != 2) {
                View.print(View.WARNING);
                View.print(View.OPTION_MESSAGE);
                temp = sc.nextLine();
            }
            option = Integer.parseInt(temp);
        } catch (Exception e) {
            View.print(View.WARNING);
            System.exit(0);
        }
        return option;
    }
}