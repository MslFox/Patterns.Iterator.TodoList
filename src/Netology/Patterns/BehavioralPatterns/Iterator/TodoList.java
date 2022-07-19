package Netology.Patterns.BehavioralPatterns.Iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TodoList implements Iterable<String> {
    private List<String> primaryList = new ArrayList<>();
    private List<String> secondaryList = new ArrayList<>();

    public TodoList addPrimary(String task) {
        primaryList.add(task);
        return this;
    }

    public TodoList addSecondary(String task) {
        secondaryList.add(task);
        return this;
    }

    public List<String> getPrimary() {

        return Collections.unmodifiableList(primaryList);
    }

    public List<String> getSecondary() {
        return Collections.unmodifiableList(secondaryList);
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            boolean isPrimary = true;
            int nextItem = 0;

            @Override
            public boolean hasNext() {
                if (isPrimary) {
                    if (nextItem < primaryList.size()) {
                        return true;
                    } else {
                        return !secondaryList.isEmpty();
                    }
                } else {
                    return nextItem < secondaryList.size();
                }
            }

            @Override
            public String next() {
                if (isPrimary) {
                    if (nextItem < primaryList.size()) {
                        return primaryList.get(nextItem++);
                    } else {
                        isPrimary = false;
                        nextItem = 0;
                        return secondaryList.get(nextItem++);
                    }
                } else {
                    return secondaryList.get(nextItem++);
                }
            }
        };
    }
}
