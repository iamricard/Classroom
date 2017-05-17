package me.rsole;

import me.rsole.data.Stack;
import me.rsole.search.Binary;
import me.rsole.sort.Bubble;
import me.rsole.sort.Insertion;
import me.rsole.sort.Selection;
import me.rsole.util.Benchmark;
import uk.org.adacollege.data.*;
import uk.org.adacollege.sort.*;
import uk.org.adacollege.search.*;

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
      "Bubble sort took %s.\n", Benchmark.run(() -> Bubble.sort(xs))
    ));
    Thread selectionT = new Thread(() -> System.out.printf(
      "Selection sort took %s.\n", Benchmark.run(() -> Selection.sort(xs))
    ));
    Thread insertionT = new Thread(() -> System.out.printf(
      "Insertion sort took %s.\n", Benchmark.run(() -> Insertion.sort(xs))
    ));

    bubbleT.start();
    selectionT.start();
    insertionT.start();
  }

  static void search() {
    int[] xs = Insertion.sort(numbers());
    int target = xs[new Random().nextInt(LIST_SIZE)];
    System.out.printf("Binary search took %s.\n", Benchmark.run(
      () -> System.out.printf(
        "Found %d: %b.\n", target, Binary.search(xs, target)
      )
    ));
  }

  private static int[] numbers() {
    return new Random().ints(LIST_SIZE).toArray();
  }

  private static boolean isPalindrome(String str) {
    String[] cs = str.toLowerCase().split("");
    String[] rev = new String[cs.length];
    Stack<String> s = new Stack<>();

    for (String c : cs) {
      s.push(c);
    }

    for (int i = 0; i < cs.length; i++) {
      rev[i] = s.pop().orElse("");
    }

    return String.join("", cs).equals(String.join("", rev));
  }
}
