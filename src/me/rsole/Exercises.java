package me.rsole;

import me.rsole.data.Stack;
import me.rsole.search.Binary;
import me.rsole.sort.Bubble;
import me.rsole.sort.Insertion;
import me.rsole.sort.Selection;
import me.rsole.util.Benchmark;

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
    Benchmark b = new Benchmark();
    System.out.printf("For an array of %d elements.\n", xs.length);
    b.add("Bubble Sort", () -> Bubble.sort(xs));
    b.add("Selection Sort", () -> Selection.sort(xs));
    b.add("Insertion Sort", () -> Insertion.sort(xs));
    b.run();
  }

  static void search() {
    int[] xs = Insertion.sort(numbers());
    int target = xs[new Random().nextInt(LIST_SIZE)];
    Benchmark b = new Benchmark();
    b.add("Binary Search", () -> Binary.search(xs, target));
    b.run();
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
