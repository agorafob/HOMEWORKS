package hw02;

public class View {
    public final String CHOOSE_BOUNDARIES = "Хотите выбрать границы? 1 - Да / 2 - Нет";
    public final String WELCOME_MESSAGE = "Угадайте задуманное число";
    public final String WRONG_ANSWER = "Вы ввели неверную цифру";
    public final String MIN = "Напишите нижнюю границу, не меньше 0 и не больше 99";
    public final String MAX = "Напишите верхнюю границу, не меньше минимума и не больше 100";



    public void print(String message) {
        System.out.println(message);
    }


}
