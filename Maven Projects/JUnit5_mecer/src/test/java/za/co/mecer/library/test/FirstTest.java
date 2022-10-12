package za.co.mecer.library.test;

import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 * @author Dimakatso Sebatane
 */
public class FirstTest {

    public FirstTest() {
    }

    @Test
    public void hello() {
        fail("Oops, Test Failed!!");
    }

    @Test
    public void test() {
        System.out.println("Please enter a value: ");
        int a = 3;
        assertEquals(3, a);
    }
}
