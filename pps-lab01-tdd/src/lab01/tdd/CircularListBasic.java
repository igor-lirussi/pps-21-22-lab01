package lab01.tdd;

import java.util.LinkedList;
import java.util.Optional;

public class CircularListBasic implements CircularList {

    LinkedList<Integer> list;

    int index=-1;

    public CircularListBasic(){
        list = new LinkedList<>();
    }

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if (list.isEmpty())  {
            return Optional.empty();
        }
        index++;
        index = index % list.size();
        return Optional.of(list.get(index));
    }

    @Override
    public Optional<Integer> previous() {
        if (list.isEmpty())  {
            return Optional.empty();
        }
        index--;
        if (index<0) index=-index;
        index = index % list.size();
        return Optional.of(list.get(index));
    }

    @Override
    public void reset() {
            index=-1;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        if (list.isEmpty())  {
            return Optional.empty();
        }
        int counter = 0;
        do {
            this.next();
            counter++;
            if (counter > list.size()) return Optional.empty();
        } while ( ! strategy.apply(list.get(index)) );
        return Optional.of(list.get(index));
    }
}
