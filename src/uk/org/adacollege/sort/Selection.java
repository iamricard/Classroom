package uk.org.adacollege.sort;

import org.jetbrains.annotations.Contract;

public class Selection {
  @Contract(pure = true)
  public static int[] sort(int[] xs) {
    int[] ys = xs.clone();
    int minIdx = 0;

    for (int i = 0; i < ys.length; i++) {
      for (int j = i; j < ys.length; j++) {
        if (ys[j] < ys[minIdx]) {
          minIdx = j;
        }
      }

      int swap = ys[i];
      ys[i] = ys[minIdx];
      ys[minIdx] = swap;
      minIdx = i + 1;
    }

    return ys;
  }
}
