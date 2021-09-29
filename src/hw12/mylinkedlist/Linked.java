package hw12.mylinkedlist;

public interface Linked <E>{
    void addFirst(E e);
    void addLast(E e);
    int size();
    E getElementByIndex(int counter);

}
