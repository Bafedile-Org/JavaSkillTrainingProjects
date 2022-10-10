package za.co.mecer.priorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Dimakatso Sebatane
 */
public class PriorityQ implements Comparable<PriorityQ> {

    private String value;
    int priority;
    public static List<PriorityQ> list = new ArrayList<>();

    public PriorityQ(String value, int priority) {
        add(value, priority);

    }

    public void add(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public void remove() {
        if (!list.isEmpty()) {
            list.remove(list.stream().sorted().collect(Collectors.toList()).get(0));
        }
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(PriorityQ pq) {
        if (this.getPriority() == pq.getPriority()) {
            return 0;
        }
        if (this.getPriority() < pq.getPriority()) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return String.format("Item : %s%n"
                + "Priority: %d%n%n", value, priority);
    }
}
