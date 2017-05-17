package me.rsole.search;

public class LinearSearch {
  public static boolean exec(int[] xs, int t) {
    for (int x : xs) {
      if (x == t) return true;
    }

    return false;
  }
}
