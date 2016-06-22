package by.amushinsky.algorithms.basic;

import java.util.Iterator;

import by.amushinsky.algorithms.basic.api.GeneralizedQueue;

public class LinkedListGeneralizedQueue<T> implements GeneralizedQueue<T> {

  private Node first;
  private Node last;
  private int N;

  @Override
  public void insert(T item) {
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }
    N++;
  }

  @Override
  public T delete(int k) {
    if (isEmpty()) {
      throw new IllegalStateException("Delete from an empty queue.");
    }
    if (k < 1 || k > N) {
      throw new IllegalArgumentException("Index should be positive integer less or equal queue size.");
    }
    Node node = first;
    if(size() == 1) {
      first = last = null;
    } else if (k == 1) {
      first = node.next;
    } else {
      for (int i = 1; i < k - 1; i++) {
        node = node.next;
      }
      Node tmp = node.next;
      node.next = tmp.next;
      node = tmp;
    }
    N--;
    return node.item;
  }

  @Override
  public boolean isEmpty() {
    return N == 0;
  }

  @Override
  public int size() {
    return N;
  }

  private class Node {
    T item;
    Node next;
  }

  private class ListIterator implements Iterator<T> {

    private Node current = first;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public T next() {
      T item = current.item;
      current = current.next;
      return item;
    } 
  }

  @Override
  public Iterator<T> iterator() {
    return new ListIterator();
  }
}
