package by.amushinsky.algorithms.basic;

import java.util.Iterator;

import by.amushinsky.algorithms.basic.api.Stack;

public class ResizingArrayStack<T> implements Stack<T> {

  @SuppressWarnings("unchecked")
  private T[] items = (T[]) new Object[2];
  private int N = 0;

  @Override
  public Iterator<T> iterator() {
    return new ReverseArrayIterator();
  }

  @Override
  public void push(T item) {
    if (N == items.length) {
      resize(items.length << 1);
    }
    items[N++] = item;
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Pop an empty stack.");
    }

    T t = items[--N];
    items[N] = null;
    if (N > 0 && N == items.length >> 2) {
      resize(items.length >> 1);
    }
    return t;
  }
  
  @Override
  public T peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Pop an empty stack.");
    }

    return items[N-1];
  }

  @Override
  public boolean isEmpty() {
    return N == 0;
  }

  @Override
  public int size() {
    return N;
  }

  @SuppressWarnings("unchecked")
  private void resize(int max) {
    T[] tmp = (T[]) new Object[max];
    for (int i = 0; i < N; i++) {
      tmp[i] = items[i];
    }
    items = tmp;
  }

  private class ReverseArrayIterator implements Iterator<T> {

    private int i = N;

    @Override
    public boolean hasNext() {
      return i > 0;
    }

    @Override
    public T next() {
      return items[--i];
    }
  }

}
