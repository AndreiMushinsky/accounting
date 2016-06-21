package by.amushinsky.algorithms.basic;

import java.util.Iterator;

import by.amushinsky.algorithms.basic.api.Stack;

public class ResizingArrayStack<T> implements Stack<T> {

  @SuppressWarnings("unchecked")
  private T[] items = (T[]) new Object[1];
  private int N = 0;

  @Override
  public Iterator<T> iterator() {
    return new ReverseArrayIterator();
  }

  @Override
  public void push(T item) {
    if (N == items.length) {
      resize(2 * items.length);
    }
    items[N++] = item;
  }

  @Override
  public T pop() {
    T t = items[--N];
    items[N] = null;
    if (N > 0 && N == items.length/4) {
      resize(items.length/2);
    }
    return t;
  }
  
  @Override
  public T peek() {
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
