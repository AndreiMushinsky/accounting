package by.amushinsky.algorithms.basic;

import java.util.Iterator;

import by.amushinsky.algorithms.basic.api.Steque;

public class LinkedListSteque<T> implements Steque<T> {

  private Node first;
  private Node last;
  private int N;

  @Override
  public Iterator<T> iterator() {
    return new ListIterator();
  }

  @Override
  public void enqueue(T item) {
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
  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Pop an empty stack.");
    }

    T item = first.item;
    first = first.next;
    if (isEmpty()) {
      last = first;
    }
    N--;
    return item;
  }

  @Override
  public void push(T item) {
    Node oldFirst = first;
    if (isEmpty()) {
      first = last = new Node();
    } else {
      first = new Node();
    }
    first.item = item;
    first.next = oldFirst;
    N++;
  }

  @Override
  public boolean isEmpty() {
    return first == null;
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

}
