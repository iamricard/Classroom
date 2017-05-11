package uk.org.adacollege;

import java.util.Random;

public class Main {
  public static void main(String[] args) {
    int[] xs = numbers(1000000);

    System.out.printf("For an array of %d elements.\n", xs.length);
    System.out.printf("Bubble sort took %s.\n", Benchmark.run(() -> Sort.bubble(xs)));
    System.out.printf("Selection sort took %s.\n", Benchmark.run(() -> Sort.selection(xs)));
    System.out.printf("Insertion sort took %s.\n", Benchmark.run(() -> Sort.insertion(xs)));
  }

  private static int[] numbers(int length) {
    return new Random().ints(length).toArray();
  }
}
