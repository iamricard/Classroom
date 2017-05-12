package uk.org.adacollege;

import java.util.Arrays;
import java.util.Random;

class Exercises {
  static void palindrome() {
    String[] palindromes = {"madam", "potato", "london", "google", "poop"};

    for (String p : palindromes) {
      System.out.printf(
        "%s is %sa palindrome\n", p, Exercises.isPalindrome(p) ? "" : "not "
      );
    }
  }

  static void sort() {
    int[] xs = numbers();

    System.out.printf("For an array of %d elements.\n", xs.length);
    System.out.printf("Bubble sort took %s.\n", Benchmark.run(() -> Sort.bubble(xs)));
    System.out.printf("Selection sort took %s.\n", Benchmark.run(() -> Sort.selection(xs)));
    System.out.printf("Insertion sort took %s.\n", Benchmark.run(() -> Sort.insertion(xs)));
  }

  static void search() {
    int[] xs = {1, 2, 3, 10, 20, 50, 60};
    int t = 20;
    System.out.printf(
      "In array %s, found %d in position %d\n",
      Arrays.toString(xs),
      t,
      Search.binary(xs, t)
    );

    t = 21;
    System.out.printf(
      "In array %s, could not find %d (%d)\n",
      Arrays.toString(xs),
      t,
      Search.binary(xs, t)
    );
  }

  private static int[] numbers() {
    return new Random().ints(1000000).toArray();
  }

  private static boolean isPalindrome(String str) {
    String[] cs = str.toLowerCase().split("");
    String[] rev = new String[cs.length];
    Stack<String> s = new Stack<>(String.class);

    for (String c : cs) {
      s.push(c);
    }

    for (int i = 0; i < cs.length; i++) {
      rev[i] = s.pop();
    }

    return String.join("", cs).equals(String.join("", rev));
  }
}
