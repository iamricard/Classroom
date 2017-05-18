package me.rsole.data;

import java.util.Optional;

public class LinkedList<T> {
  private Node<T> head;
  private int size = 0;

  public void add(T x) {
    add(x, 0);
  }

  public void add(T x, int pos) {
    Node<T> current = head;

    if (pos > size) pos = size;
    if (pos == 0) {
      head = new Node<>(x, current);
    } else {
      while (pos > 1) {
        current = current.next();
        pos--;
      }

      current.setNext(new Node<>(x, current.next()));
    }

    size++;
  }

  public Optional<T> remove() {
    return remove(0);
  }

  public Optional<T> remove(int pos) {
    Node<T> current = head;
    Node<T> target;

    if (size == 0) return Optional.empty();
    if (pos > size) pos = size;
    if (pos == 0) {
      target = head;
      head = target.next();
    } else {
      while (pos > 1) {
        current = current.next();
        pos--;
      }

      target = current.next();
      current.setNext(target.next());
    }

    size--;
    return Optional.of(target.data());
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    Node<T> current = head;

    for (int i = 0; i < size; i++) {
      s.append(String.format("%s -> ", current.data()));
      current = current.next();
    }

    s.append("END");

    return s.toString();
  }
}
