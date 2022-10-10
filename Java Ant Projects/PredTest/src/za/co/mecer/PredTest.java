package za.co.mecer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import za.co.mecer.person.Person;

/**
 *
 * @author Dimakatso Sebatane
 */
public class PredTest {

    private BiPredicate<String, String> isNumberValid
            = (number1, number2) -> number1.startsWith("hi") && number2.length() > 4;
    private BiPredicate<Integer, Integer> isNumberGreater
            = (number1, number2) -> number1 > number2;

    private BiConsumer<Person, Person> personConsumer = (person1, person2) -> System.out.printf("%s%n%s%n", person1.toString(), person2.toString());

    private Consumer<Person> greetPerson = (person) -> {
        String str = person.getAge() > 30 ? String.format("Hello %S %d years old,%nWelcome to the software version of HELL.%n",
                person.getName(), person.getAge()) : "Hell NO";
        System.out.println(str);
    };

    private Supplier< List<Person>> people = () -> {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Jessie Michaels", 32));
        list.add(new Person("Nathalie Newton", 29));
        list.add(new Person("Molly Jean", 34));
        list.add(new Person("Jim Micha", 42));
        return list;
    };

    Function<Integer, Integer> multiply = (num1) -> {
        int num2 = 8;
        return num1 * num2;
    };

    Function<Integer, Integer> add = num1 -> multiply.apply(num1) + 3;
    Function<Integer, Integer> mul = multiply.andThen(add);

    BiFunction<Integer, Integer, Double> biFun = (num1, num2) -> (double) (num1 * num2);

    public static void main(String[] args) {
        new PredTest().run();

    }

    private void runBiPred2() {
        System.out.printf("Is it greater: %s%n", isNumberGreater.test(5, 5));
        System.out.printf("Is it greater: %s%n", isNumberGreater.test(9, 5));
        System.out.printf("Is it greater: %s%n", isNumberGreater.test(2, 5));
    }

    private void runBiPred1() {
        System.out.printf("Is it valid 3: %s%n", isNumberValid.test("hi there", "hello"));
        System.out.printf("Is it valid 3: %s%n", isNumberValid.test("hello there", "hi"));
        System.out.printf("Is it valid 3: %s%n%n", isNumberValid.test("hey ", "there"));

    }

    private void runBiCon1() {
        personConsumer.accept(new Person("Molly Jean", 34), new Person("Jim Micha", 42));
        greetPerson.accept(new Person("Nathalie Newton", 29));
        greetPerson.accept(new Person("Jessie Michaels", 32));
    }

    private void runSub() {
        people.get().stream().forEach(System.out::println);
    }

    private void run() {
//        runBiPred1();
//        runBiPred2();
//        runBiCon1();
//        runSub();
        runFun();
    }

    private void runFun() {
//        for (int i = 0; i < 10; i++) {
//            System.out.printf("MULTIPLY::: Ans: %d * %d = %d%n", (i + 1), 8, multiply.apply((i + 1)));
//            System.out.printf("ADD::: Ans: %d%n", add.apply((i + 1)));
//            System.out.printf("MUL::: Ans: %d%n%n%n", mul.apply((i + 1)));
//        }

        System.out.printf("Result: %.2f%n", biFun.apply(mul.apply(12), add.apply(3)));
        System.out.printf("Result: %.2f%n", biFun.apply(3, 2));
    }
}
