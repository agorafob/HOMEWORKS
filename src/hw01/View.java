package hw01;

public class View {
    public static final String INPUT_HELLO = "Input 'Hello' ";
    public static final String INPUT_WORLD = "Input 'World!' ";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String RESULT = "Result is: ";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printWholeMessage(String firstWord, String secondWord) {
        System.out.println(firstWord + " " + secondWord);
    }
}
