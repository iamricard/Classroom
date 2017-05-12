package uk.org.adacollege;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Stack<T> {
  private T[] memory;
  private int count = 0;

  Stack(Class<T> c) {
    @SuppressWarnings("unchecked")
    T[] memory = (T[]) Array.newInstance(c, 0);
    this.memory = memory;
  }

  void push(T x) {
    count++;
    memory = Arrays.copyOf(memory, count);
    memory[count - 1] = x;
  }

  T peek() {
    return memory[count];
  }

  T pop() {
    T x = memory[count - 1];
    count--;
    memory = Arrays.copyOf(memory, count);
    return x;
  }

  int size() {
    return count;
  }

  public String toString() {
    return Arrays.toString(memory);
  }
}
