package me.rsole.sort;

import org.jetbrains.annotations.Contract;

public class Bubble {
  @Contract(pure = true)
  public static int[] sort(int[] xs) {
    int[] ys = xs.clone();
    boolean sorted;

    do {
      sorted = true;

      for (int i = 0; i < (ys.length - 1); i++) {
        int left = ys[i], right = ys[i + 1];

        if (left > right) {
          ys[i] = right;
          ys[i + 1] = left;
          sorted = false;
        }
      }
    } while (!sorted);

    return ys;
  }
}
