package hw01;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        String a = checkFirstWord(sc);
        String b = checkSecondWord(sc);
        sc.close();
        view.printWholeMessage(a, b);
    }

    private String checkFirstWord(Scanner sc) {
        view.printMessage(View.INPUT_HELLO);
        while (!sc.next().equals(Model.hello)) {
            view.printMessage(View.WRONG_INPUT_INT_DATA + View.INPUT_HELLO);
            sc.nextLine();
        }
        return Model.hello;
    }

    private String checkSecondWord(Scanner sc) {
        view.printMessage(View.INPUT_WORLD);
        while (!sc.next().equals(Model.world)) {
            view.printMessage(View.WRONG_INPUT_INT_DATA + View.INPUT_WORLD);
            sc.nextLine();
        }
        return Model.world;
    }
}
