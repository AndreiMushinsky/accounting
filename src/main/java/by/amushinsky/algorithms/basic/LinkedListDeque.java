package by.amushinsky.algorithms.basic;

import java.util.Iterator;

import by.amushinsky.algorithms.basic.api.Deque;

public class LinkedListDeque<T> implements Deque<T> {

  private Node left;
  private Node right;
  private int N;

  @Override
  public Iterator<T> iterator() {
    return new ListIterator();
  }

  @Override
  public void pushLeft(T item) {
    Node oldLeft = left;
    left = new Node();
    left.item = item;
    left.nextRight = oldLeft;
    if (oldLeft == null) {
      right = left;
    } else {
      oldLeft.nextLeft = left;
    }
    N++;
  }

  @Override
  public void pushRight(T item) {
    Node oldRight = right;
    right = new Node();
    right.item = item;
    right.nextLeft = oldRight;
    if (oldRight == null) {
      left = right;
    } else {
      oldRight.nextRight = right;
    }
    N++;
  }

  @Override
  public T popLeft() {
    if (isEmpty()) {
      throw new IllegalStateException("Pop an empty deque.");
    }

    T item = left.item;
    left = left.nextRight;
    if (left == null) {
      right = left;
    } else {
      left.nextLeft = null;
    }
    N--;
    return item;
  }

  @Override
  public T popRight() {
    if (isEmpty()) {
      throw new IllegalStateException("Pop an empty deque.");
    }

    T item = right.item;
    right = right.nextLeft;
    if (right == null) {
      left = right;
    } else {
      right.nextRight = null;
    }
    N--;
    return item;
  }

  @Override
  public boolean isEmpty() {
    return left == null;
  }

  @Override
  public int size() {
    return N;
  }

  private class Node {
    T item;
    Node nextRight;
    Node nextLeft;
  }

  private class ListIterator implements Iterator<T> {

    private Node current = left;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public T next() {
      T item = current.item;
      current = current.nextRight;
      return item;
    } 
  }
}
