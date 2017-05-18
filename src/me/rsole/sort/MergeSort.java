package me.rsole.sort;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class MergeSort {
  public static int[] exec(int[] xs) {
    if (xs.length <= 1) return xs;

    int[] left = Arrays.copyOfRange(xs, 0, xs.length / 2);
    int[] right = Arrays.copyOfRange(xs, xs.length / 2, xs.length);

    return merge(exec(left), exec(right));
  }

  private static int[] merge(int[] xs, int[] ys) {
    if (xs.length == 0) return ys;
    if (ys.length == 0) return xs;

    int hx = head(xs).get();
    int hy = head(ys).get();
    int[] tx = tail(xs);
    int[] ty = tail(ys);
    int[] merged = new int[1];

    if (hx < hy) {
      merged[0] = hx;

      return IntStream.concat(
        Arrays.stream(merged),
        Arrays.stream(merge(tx, ys))
      ).toArray();
    } else {
      merged[0] = hy;

      return IntStream.concat(
        Arrays.stream(merged),
        Arrays.stream(merge(xs, ty))
      ).toArray();
    }
  }

  private static Optional<Integer> head(int[] xs) {
    if (xs.length == 0) return Optional.empty();

    return Optional.of(xs[0]);
  }

  private static int[] tail(int[] xs) {
    if (xs.length < 2) return new int[]{};

    return Arrays.copyOfRange(xs, 1, xs.length);
  }
}
