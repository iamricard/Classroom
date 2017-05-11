package uk.org.adacollege;

import org.jetbrains.annotations.Contract;

class Sort {
  @Contract(pure = true)
  static int[] bubble(int[] xs) {
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

  @Contract(pure = true)
  static int[] selection(int[] xs) {
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

  @Contract(pure = true)
  public static int[] insertion(int[] xs) {
    int[] ys = xs.clone();
    return ys;
  }
}
