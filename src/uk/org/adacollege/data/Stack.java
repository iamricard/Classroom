package uk.org.adacollege.data;

import java.util.Optional;

public class Stack<T> {
  private Node<T> head;
  private int size = 0;

  public void push(T x) {
    if (size == 0) {
      head = new Node<>(x);
    } else {
      head = new Node<>(x, head);
    }

    size++;
  }

  public Optional<T> peek() {
    if (size == 0) return Optional.empty();

    return Optional.of(head.data());
  }

  public Optional<T> pop() {
    if (size == 0) return Optional.empty();

    Node<T> node = head;
    head = head.next();

    return Optional.of(node.data());
  }

  public int size() {
    return size;
  }
}
