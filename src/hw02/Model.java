package hw02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    private int min = 0;
    private int max = 100;
    private int theDigit;
    protected List<Integer> actions = new ArrayList<>();
    protected boolean userWon=false;

    public void rand(int min, int max) {
        Random r = new Random();
        theDigit = r.nextInt(max - min + 1) + min;
    }

    public void rand() {
        Random r = new Random();
        theDigit = r.nextInt(this.max - this.min + 1) + this.min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getTheDigit() {
        return theDigit;
    }

    public void printActions(){
        System.out.println("Ваши действия:");
        System.out.println(actions.toString());
    }

    public void currentBoundaries(){
        System.out.println("Число в диапазоне "+'['+min+';'+max+']');
    }

    public void game (int answer){
            if(answer==theDigit){
                System.out.println("Вы угадали!");
                userWon=true;
                actions.add(answer);
                printActions();
                System.exit(0);
            }
            if (answer<theDigit){
                min=answer;
                currentBoundaries();
                actions.add(answer);
                printActions();
            }
            if(answer>theDigit){
                max=answer;
                currentBoundaries();
                actions.add(answer);
                printActions();
            }
        }
    }


