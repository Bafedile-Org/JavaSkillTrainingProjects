package za.co.mecer.library.utils;

public class Calculator{
  public boolean isEvenNumber(int number){
    return number % 2 == 0;
  }

  public int add(int a, int b){
    return a + b;
  }

  public int subtract(int a, int b){
    return a - b;
  }

  public int multiply(int a, int b){
    return a * b;
  }

  public int divide(int a, int b){
    return a / b;
  }

  public double computeCircleArea(double radius){
    return Math.PI * radius * radius;
  }
}
