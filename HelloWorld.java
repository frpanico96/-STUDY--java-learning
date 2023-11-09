import java.util.*;

public class HelloWorld {
  static int a = 1; // static variable
  int data = 99; // instance variable

  public static void main(String[] args) {
    System.out.println("HelloWorld");
    typeConversion();
    conditions();
  }

  static void typeConversion() {
    byte x;
    int a = 270;
    double b = 128.128;
    System.out.println("int converted to byte");
    x = (byte) a;
    System.out.println("a and x " + a + " " + x);
    System.out.println("double converted to int");
    a = (int) b;
    System.out.println("b and a " + b + " " + a);
    System.out.println("\ndouble converted to byte");
    x = (byte) b;
    System.out.println("b and x " + b + " " + x);
  }

  static void conditions() {
    int x = 10;
    int y = 20;
    if (x + y < 10) {
      System.out.println("x + y is less than 10");
    } else {
      System.out.println("x + y is greater than 10");
    }
    int num = 2;
    switch (num) {
      case 0:
        System.out.println("number is 0");
        break;
      case 1:
        System.out.println("number is 1");
        break;
      case 2:
        System.out.println("number is 2");
        break;
      case 3:
        System.out.println("number is 3");
        break;
      default:
        break;
    }
  }

}