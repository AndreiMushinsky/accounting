package by.amushinsky.algorithms.basic;

import java.util.Iterator;

import by.amushinsky.algorithms.basic.api.Stack;

public class LinkedListStack<T> implements Stack<T> {

  private Node first;
  private int N;
  
  @Override
  public Iterator<T> iterator() {
    return new ListIterator();
  }

  @Override
  public void push(T item) {
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    N++;
  }

  @Override
  public T pop() {
    T item = first.item;
    first = first.next;
    N--;
    return item;
  }

  @Override
  public T peek() {
    return first.item;
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
