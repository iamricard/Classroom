package uk.org.adacollege;

class Search {
  static boolean binary(int[] xs, int x) {
    int hi = xs.length - 1;
    int lo = 0;
    int pivot = hi / 2;

    while (true) {
      if (x == xs[pivot]) {
        return true;
      } else if (pivot == hi && pivot == lo) {
        return false;
      } else if (x < xs[pivot]) {
        hi = pivot - 1;
      } else {
        lo = pivot + 1;
      }

      pivot = (hi + lo) / 2;
    }
  }
}
