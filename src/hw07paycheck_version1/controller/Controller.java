package hw07paycheck_version1.controller;

import hw07paycheck_version1.view.View;


import java.util.Scanner;

public class Controller {

    public static String correctMonth(Scanner sc) {
        String month = "";
            boolean correct = false;
            while (!correct) {
                month = sc.nextLine();
                for (Months m : Months.values()) {
                    if (m.title.equals(month)) {
                        correct = true;
                        break;
                    }
                }
                if (correct) {
                    break;
                } else {
                    View.print(View.WARNING);
                    View.print(View.START_MESSAGE);
                }
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