package za.co.mecer;

import za.co.mecer.doubles.DoubleClass;
import za.co.mecer.generic.GenMethodClass;
import za.co.mecer.generic.GenericArrClass;
import za.co.mecer.generic.GenericClass;
import za.co.mecer.integer.IntegerClass;
import za.co.mecer.string.StringClass;

/**
 *
 * @author Dimakatso Sebatane
 */
public class GenericsTest {

    public static void main(String[] args) {
//        new GenericsTest().runTest1();
//        new GenericsTest().runTest2();
        new GenericsTest().runTest3();
    }

    private void runTest1() {
        new IntegerClass(3).printValue();
        new DoubleClass(5.2).printValue();
        new StringClass("Hello There").printValue();

        System.out.println("/-----------------------------------------\n");

        coolMethod(new GenericClass<>(2));
        coolMethod(new GenericClass<>(2.5));
        coolMethod(new GenericClass<>("Hi"));
        coolMethod(new GenericClass<>(90L));
        coolMethod(new GenericClass<>(true));

    }

    private void coolMethod(GenericClass gen) {
        gen.printValue();
    }

    private void runTest2() {
        GenMethodClass gen = new GenMethodClass();
        gen.<String, Integer>foo("Hello", 2382);
        gen.<Long, Boolean>foo(234324L, true);
        gen.<Boolean, Character>foo(false, 'A');
        gen.<Integer>foo(238);
    }

    private void runTest3() {
//        new GenericBound<>(89).printValue();
        String[] arr1 = {"hello", "world", "the", "at", "me", "them", "they"};
        Integer[] arr2 = {2, 31, 1, 38, 3, 0, 2, 17, 37, 12};
        Boolean[] arr3 = {true, false, false, false, true, false, false, true, true};

        coolMethod(new GenericArrClass<>(arr1));

        coolMethod(new GenericArrClass<>(), arr2);
        coolMethod(new GenericArrClass<>(), arr3);
    }

    private void coolMethod(GenericArrClass gen) {
        gen.displayArray();
        System.out.println("----------------------------------------------\n");
    }

    private <T> void coolMethod(GenericArrClass gen, T[] arr) {
        gen.displayArray(arr);
        System.out.println("----------------------------------------------\n");
    }
}
