package za.co.mecer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import za.co.mecer.person.Person;

/**
 *
 * @author Dimakatso Sebatane
 */
public class StreamsTest {

    public static void main(String[] args) {
        new StreamsTest().run();
    }

    private void run() {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
        test6();
    }

    private void test1() {
        Integer[] ints = {1, 3, 5, 1, 3, 6, 3, 8, 9, 1, 3, 6, 1, 3, 7, 4, 7, 3};
        System.out.printf("Numbers are: %d%n", Arrays.stream(ints).filter((num) -> num > 3).count());
        Arrays.stream(ints)
                .filter((num) -> (num > 3 && num < 7))
                .distinct().forEach(num -> System.out.printf("%d  ", num));

    }

    private void test2() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Jessie Michaels", 32, 'F', 17388.33));
        list.add(new Person("Nathalie Newton", 29, 'F', 27818.23));
        list.add(new Person("Molly Jean", 34, 'F', 12737.32));
        list.add(new Person("Jim Micha", 19, 'M', 8964.32));
        list.add(new Person("Anatoly Chuchkluck", 25, 'M', 5643.32));
        list.add(new Person("Will Meghan", 23, 'M', 12779.32));

        System.out.println("\n--------------------------------------\n"
                + "Filter by Age and Name Length"
                + "\n--------------------------------------\n");
        list.stream()
                .filter(p -> (p.getAge() > 18 && p.getName()
                .split(" ")[0].length() > 5))
                .sorted().forEach(System.out::println);

        System.out.println("\n--------------------------------------\n"
                + "Filter by Salary and Gender"
                + "\n--------------------------------------\n");
        list.stream()
                .filter(p -> p.getGender() == 'M' && p.getSalary() > 10000)
                .forEach(System.out::println);

        List<Person> people = new ArrayList<>();
        System.out.println("\n--------------------------------------\n"
                + "Collected People"
                + "\n--------------------------------------\n");
        people.addAll(list.stream()
                .filter(p -> p.getAge() > 25)
                .collect(Collectors.toList()));
        people.stream().forEach(System.out::println);
    }

    private void test3() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Jessie Michaels", 32, 'F', 17388.33));
        list.add(new Person("Jassie Mich", 18, 'F', 16453.33));
        list.add(new Person("Nathalie Newton", 29, 'F', 27818.23));
        list.add(new Person("Molly Jean", 34, 'F', 12737.32));
        list.add(new Person("Jim Micha", 19, 'M', 8964.32));
        list.add(new Person("Anatoly Chuchkluck", 25, 'M', 5643.32));
        list.add(new Person("Will Meghan", 23, 'M', 12779.32));

        list.stream().map(p -> p.getName()).sorted().forEach(System.out::println);
        System.out.println("");
//        list.stream().map(p -> p.getAge()).sorted().forEach(System.out::println);
//        System.out.println("");
//        list.stream().sorted().forEach(System.out::println);
        System.out.println("================SORTED---BY---AGE==================\n");
        list.stream().sorted((p1, p2) -> {
            return p1.getAge() == p2.getAge() ? 0 : p1.getAge() > p2.getAge() ? 1 : -1;
        }).forEach(System.out::println);

    }

    private void test4() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Jessie Michaels", 32, 'F', 17388.33));
        list.add(new Person("Jassie Mich", 18, 'F', 16453.33));
        list.add(new Person("Nathalie Newton", 29, 'F', 27818.23));
        list.add(new Person("Molly Jean", 34, 'F', 12737.32));
        list.add(new Person("Jim Micha", 19, 'M', 8964.32));
        list.add(new Person("Anatoly Chuchkluck", 25, 'M', 5643.32));
        list.add(new Person("Will Meghan", 23, 'M', 12779.32));

        System.out.printf("Salary Sum : %.2f%n", list.stream()
                .map(p -> p.getSalary())
                .reduce(0.0, (sum, salary) -> sum += salary));

        System.out.printf("Average Salary : %.2f%n", (list.stream()
                .map(p -> p.getSalary())
                .reduce(0.0, (sum, salary) -> sum += salary)) / list.size());
    }

    private void test5() {
        try {
            Stream<String> stream = Files.lines(Paths.get("words.txt"));
            stream.forEach(line -> {
                String[] str = line.trim().split(" ");
                Arrays.stream(str).forEach(System.out::println);
            });
        } catch (IOException iox) {
            System.out.printf("Error: %s%n", iox.getMessage());
        }
    }

    private void test6() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Jessie Michaels", 32, 'F', 17388.33));
        list.add(new Person("Jassie Mich", 18, 'F', 16453.33));
        list.add(new Person("Nathalie Newton", 29, 'F', 27818.23));
        list.add(new Person("Molly Jean", 34, 'F', 12737.32));
        list.add(new Person("Jim Micha", 19, 'M', 8964.32));
        list.add(new Person("Anatoly Chuchkluck", 25, 'M', 5643.32));
        list.add(new Person("Will Meghan", 23, 'M', 12779.32));

        OptionalDouble avg = list.stream()
                .filter((p) -> p.getSalary() < 3000)
                .mapToDouble((p) -> p.getSalary())
                .average();
        System.out.println(avg.isPresent()
                ? String.format("The total average is %.2f%n", avg.getAsDouble())
                : "Optional has no value and is empty");
    }

}
