package uk.org.adacollege;

import java.util.Optional;

class Stack<T> {
  private Node<T> head;
  private int size = 0;

  void push(T x) {
    if (size == 0) {
      head = new Node<>(x);
    } else {
      head = new Node<>(x, head);
    }

    size++;
  }

  Optional<T> peek() {
    if (size == 0) return Optional.empty();

    return Optional.of(head.data());
  }

  Optional<T> pop() {
    if (size == 0) return Optional.empty();

    Node<T> node = head;
    head = head.next();

    return Optional.of(node.data());
  }

  int size() {
    return size;
  }
}
