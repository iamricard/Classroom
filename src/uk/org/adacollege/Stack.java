package uk.org.adacollege;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;

public class Stack<T> {
  private T[] memory;
  private int count = 0;

  Stack(Class<T> c) {
    @SuppressWarnings("unchecked")
    T[] memory = (T[]) Array.newInstance(c, 1);
    this.memory = memory;
  }

  void push(T x) {
    if (memory.length <= count) {
      memory = Arrays.copyOf(memory, count * 2);
    }

    count++;

    memory[count - 1] = x;
  }

  Optional<T> peek() {
    if (count == 0) return Optional.empty();
    
    return Optional.of(memory[count]);
  }

  Optional<T> pop() {
    if (count == 0) {
      return Optional.empty();
    }

    T x = memory[count - 1];
    count--;

    if (count < memory.length / 2) {
      memory = Arrays.copyOf(memory, memory.length / 2);
    }

    return Optional.of(x);
  }

  int size() {
    return count;
  }

  int memorySize() {
    return memory.length;
  }

  public String toString() {
    return Arrays.toString(memory);
  }
}
