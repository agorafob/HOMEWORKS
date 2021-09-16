package hw03.model;

import hw03.controler.NotebookEntry;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<NotebookEntry> notebook = new ArrayList<>();

    public void addNewEntry(NotebookEntry entry){
        notebook.add(entry);
    }

    public void print(){
        for (NotebookEntry entry:notebook) {
            System.out.println(entry.toString());
        }
    }
}
