package uk.org.adacollege.sort;

import org.jetbrains.annotations.Contract;

public class Insertion {
  @Contract(pure = true)
  public static int[] sort(int[] xs) {
    int[] ys = new int[xs.length];
    ys[0] = xs[0];

    for (int i = 1; i < xs.length; i++) {
      int current = xs[i];
      int idx = i;

      for (int j = 0; j < i; j++) {
        if (current < ys[j]) {
          idx = j;
          break;
        }
      }

      insertAt(ys, idx, i, current);
    }
    return ys;
  }

  private static void insertAt(int[] xs, int idx, int end, int value) {
    for (int i = end; i >= idx; i--) {
      if (i + 1 < xs.length) xs[i + 1] = xs[i];
      xs[i] = value;
    }
  }
}
