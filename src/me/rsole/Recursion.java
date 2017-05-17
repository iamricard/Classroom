package me.rsole;

class Recursion {
  static int h(int p) {
    int next = p - 1;

    return p == 2 ? 1 : next + h(next);
  }

  static double factorial(double n) {
    return n == 1 ? 1 : n * factorial(n - 1);
  }

  static double fib(double n) {
    if (n == 1 || n == 2) return n - 1;

    return fib(n - 1) + fib(n - 2);
  }
}
