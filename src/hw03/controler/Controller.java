package hw03.controler;

import hw03.view.View;
import hw03.model.Model;

import java.util.Scanner;

public class Controller {
    Model model;
    View view;

    public Controller() {
        this.model = new Model();
        this.view = new View();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        NotebookEntry entry = new NotebookEntry(view,sc);
        entry.inputNote();
        model.addNewEntry(entry);
        model.print();

    }




}
