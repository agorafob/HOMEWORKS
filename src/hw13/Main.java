package hw13;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 3, 0, 25, 6, 98, 17};
        System.out.println(Arrays.toString(arr));
        double avg = Arrays.stream(arr).average().getAsDouble();
        System.out.println("Среднее значение массива: " + avg);
        getMinAndIndex(arr);
        int countZero = Arrays.stream(arr).filter(i -> i == 0).toArray().length;
        System.out.println("Количество нулей: " + countZero);
        int countMoreThanZero = Arrays.stream(arr).filter(i -> i > 0).toArray().length;
        System.out.println("Число элментов больше нуля: " + countMoreThanZero);
        int multiplyDigit = 5;
        int[] newArr = Arrays.stream(arr).map(i->i*multiplyDigit).toArray();
        System.out.println("Массив, увеличеный на " + multiplyDigit);
        System.out.println(Arrays.toString(newArr));
    }

    public static void getMinAndIndex(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        int index = IntStream.range(0, arr.length).filter(i -> min == arr[i]).findFirst().getAsInt();
        System.out.println("Минимальное значение: " + min + " Его индекс: " + index);
    }
}
