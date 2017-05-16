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
  static int[] insertion(int[] xs) {
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
