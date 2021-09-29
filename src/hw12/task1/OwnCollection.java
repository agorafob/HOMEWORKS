package hw12.task1;

import java.util.*;
import java.util.function.Predicate;

public class OwnCollection extends ArrayList{

    @Override
    public Object remove(int index) {
        System.out.println("You can not remove objects from this collection");
        return null;
    }

    @Override
    public boolean remove(Object o) {
        System.out.println("You can not remove objects from this collection");
        return false;
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        System.out.println("You can not remove objects from this collection");
    }

    @Override
    public boolean removeAll(Collection c) {
        System.out.println("You can not remove objects from this collection");
        return false;
    }

    @Override
    public boolean removeIf(Predicate filter) {
        System.out.println("You can not remove objects from this collection");
        return false;
    }

}
