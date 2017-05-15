package uk.org.adacollege;

import java.util.Random;

class Exercises {
  private final static int LIST_SIZE = 100000;

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

    Thread bubbleT = new Thread(() -> System.out.printf(
      "Bubble sort took %s.\n", Benchmark.run(() -> Sort.bubble(xs))
    ));
    Thread selectionT = new Thread(() -> System.out.printf(
      "Selection sort took %s.\n", Benchmark.run(() -> Sort.selection(xs))
    ));
    Thread insertionT = new Thread(() -> System.out.printf(
      "Insertion sort took %s.\n", Benchmark.run(() -> Sort.insertion(xs))
    ));

    bubbleT.start();
    selectionT.start();
    insertionT.start();
  }

  static void search() {
    int[] xs = Sort.insertion(numbers());
    int target = xs[new Random().nextInt(LIST_SIZE)];
    System.out.printf("Binary search took %s.\n", Benchmark.run(
      () -> System.out.printf(
        "Found %d at position %d.\n",
        target,
        Search.binary(xs, target)
      )
    ));
  }

  private static int[] numbers() {
    return new Random().ints(LIST_SIZE).toArray();
  }

  private static boolean isPalindrome(String str) {
    String[] cs = str.toLowerCase().split("");
    String[] rev = new String[cs.length];
    Stack<String> s = new Stack<>(String.class);

    for (String c : cs) {
      s.push(c);
    }

    for (int i = 0; i < cs.length; i++) {
      rev[i] = s.pop().orElse("");
    }

    return String.join("", cs).equals(String.join("", rev));
  }
}
