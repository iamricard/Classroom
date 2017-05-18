package me.rsole;

import me.rsole.data.Stack;
import me.rsole.search.BinarySearch;
import me.rsole.search.LinearSearch;
import me.rsole.sort.BubbleSort;
import me.rsole.sort.InsertionSort;
import me.rsole.sort.SelectionSort;
import me.rsole.util.Benchmark;

import java.util.Random;

class Exercises {
  private final static int LIST_SIZE = 800000;

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
    b.add("BubbleSort Sort", () -> BubbleSort.exec(xs));
    b.add("SelectionSort Sort", () -> SelectionSort.exec(xs));
    b.add("InsertionSort Sort", () -> InsertionSort.exec(xs));
    b.run();
  }

  static void search() {
    int[] xs = InsertionSort.exec(numbers());
    int target = xs[new Random().nextInt(LIST_SIZE)];
    Benchmark b = new Benchmark();
    b.add("BinarySearch Search", () -> BinarySearch.exec(xs, target));
    b.add("LinearSearch Search", () -> LinearSearch.exec(xs, target));
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
