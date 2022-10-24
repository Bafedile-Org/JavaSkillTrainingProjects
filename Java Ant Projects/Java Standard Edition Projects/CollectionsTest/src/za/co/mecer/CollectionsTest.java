package za.co.mecer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import za.co.mecer.person.Person;

/**
 *
 * @author Dimakatso Sebatane
 */
public class CollectionsTest {

    public static void main(String[] args) {
        new CollectionsTest().run();
    }

    private void run() {
        // listTest();
        // setTest();
        //mapTest();
        // stackTest();
        sortComparable();

    }

    private void listTest() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Dorcie", 14));
        list.add(new Person("Sponge", 35));
        list.add(new Person("Mercury", 23));
        list.add(new Person("Liz", 32));

//        list.stream().forEach((p) -> System.out.print(p));
//        Iterator<Person> it = list.iterator();
//        while (it.hasNext()) {
//            System.out.print(it.next());
//        }
        list.stream().forEach(System.out::println);
        System.out.println("/--------------------------------------\n");
        list.remove(2);
        list.stream().forEach(System.out::println);

        List<Person> list2 = new ArrayList<>();
        list2.add(new Person("Sponge3", 23));
        list2.add(new Person("Mercury", 32));
        list.addAll(0, list2);

        list2.stream().forEach(System.out::println);
        System.out.println("/--------------------------------------\n");

    }

    private void setTest() {
        Set<Person> set = new HashSet<>();
        set.add(new Person("Dorcie", 14));
        set.add(new Person("Sponge", 35));
        set.add(new Person("Mercury", 1));
        set.add(new Person("Liz", 32));
        set.add(new Person("Dorcie", 13));
        set.add(new Person("Anatoly", 13));
        set.stream().forEach(System.out::println);

        set.remove(new Person("Dorcie", 14));
        System.out.println("/-----------------------------------------\n");
        set.stream().forEach(System.out::println);

    }

    private void mapTest() {
        Map<Integer, Person> map = new HashMap<>();
        map.put(14, new Person("Dorcie", 14));
        map.put(35, new Person("Sponge", 35));
        map.put(1, new Person("Mercury", 1));
        map.put(32, new Person("Liz", 32));
        map.put(13, new Person("Dorcie", 13));
        map.put(13, new Person("Anatoly", 13));

        map.forEach((key, value) -> {
            System.out.printf("Key: %d%n"
                    + "Value: %s%n", key, value);
        });
//        for (Integer key : map.keySet()) {
//            for (Person value : map.values()) {
//                System.out.printf("Key: %d%n"
//                        + "Value: %s%n", key, value);
//            }
//        }

    }

    private void stackTest() {
        Stack<Character> stack = new Stack<>();
        stack.push('A');
        stack.push('B');
        stack.push('Q');
        stack.push('Z');
        stack.push('X');
        stack.push('M');
        stack.push('E');

        System.out.printf("Stack Empty? %s%n", stack.isEmpty());
        while (!stack.isEmpty()) {
            System.out.printf("%s Popped%n", stack.pop());
        }
//        stack.stream().forEach((st) -> System.out.printf("%s Popped%n", stack.pop()));
        System.out.printf("Stack Empty? %s%n", stack.isEmpty());
    }

    private void sortComparable() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Dorcie", 14));
        list.add(new Person("Sponge", 35));
        list.add(new Person("Mercury", 23));
        list.add(new Person("Liz", 32));
        list.stream().forEach((p) -> System.out.print(p));

        Collections.sort(list);
        System.out.println("==========================================");
        list.stream().forEach((p) -> System.out.print(p));

    }
}
