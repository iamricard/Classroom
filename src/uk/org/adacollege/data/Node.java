package uk.org.adacollege.data;

class Node<T> {
  private T data;
  private Node<T> next;

  Node(T d) {
    data = d;
  }

  Node(T d, Node<T> n) {
    data = d;
    next = n;
  }

  void setNext(Node<T> n) {
    next = n;
  }

  T data() {
    return data;
  }

  Node<T> next() {
    return next;
  }

  boolean isEmpty() {
    return data == null;
  }

  @Override
  public String toString() {
    if (data != null) return data.toString();

    return "NULL";
  }
}
