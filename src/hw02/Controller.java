package hw02;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(){
        model=new Model();
        view = new View();
    }

    public void run(){
        try {
            view.print(view.CHOOSE_BOUNDARIES);
            Scanner sc = new Scanner(System.in);
            chooseRandom(userBoundariesOption(sc),sc);
            view.print(view.WELCOME_MESSAGE);
            gameTime(sc);
        }catch (Exception e){
            model.actions.clear();
            run();
        }

    }

    private int userBoundariesOption(Scanner sc){
        int answer = sc.nextInt();
        while (answer!=1&answer!=2){
            view.print(view.WRONG_ANSWER);
            answer=sc.nextInt();
        }
        return answer;
    }

    private void setBoundaries(Scanner sc){
        view.print(view.MIN);
        int min = sc.nextInt();
        while (min<0||min>99){
            view.print(view.WRONG_ANSWER);
            view.print(view.MIN);
            min = sc.nextInt();
        }
        model.setMin(min);
        view.print(view.MAX);
        int max = sc.nextInt();
        while (max<min||max>100){
            view.print(view.WRONG_ANSWER);
            view.print(view.MAX);
            max= sc.nextInt();
        }
        model.setMax(max);
    }

    private void chooseRandom (int answer, Scanner sc){
        switch (answer){
            case (1) :
                setBoundaries(sc);
                model.rand(model.getMin(), model.getMax());
                break;
            case (2): model.rand();break;
        }

    }

    private int userAnswer (Scanner sc){
        int answer = sc.nextInt();
        while (answer< model.getMin()||answer> model.getMax()){
            view.print(view.WRONG_ANSWER);
            answer=sc.nextInt();
        }
        return answer;
    }

    private void gameTime(Scanner sc){
        int answer = userAnswer(sc);
        while (!model.userWon){
            model.game(answer);
            answer=userAnswer(sc);
        }
        System.out.println(model.getTheDigit()+"напрямую");
    }


}
