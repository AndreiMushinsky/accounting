package by.amushinsky.algorithms.basic;

import java.util.Iterator;

import by.amushinsky.algorithms.basic.api.GeneralizedQueue;

public class ResizingArrayGeneralizedQueue<T> implements GeneralizedQueue<T> {

  @SuppressWarnings("unchecked")
  private T[] items = (T[]) new Object[2];
  private int N = 0;
  private int head = 0;
  private int tail = 0;
  
  @Override
  public Iterator<T> iterator() {
    return new ArrayIterator();
  }

  @Override
  public void insert(T item) {
    if (N == items.length) {
      resize(items.length << 1);
    }
    items[tail] = item;
    tail = (tail + 1) % items.length;
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
    int index = (head + k - 1) % items.length;
    T item = items[index];
    for (int i = (index + 1) % items.length; i != tail; i = (i + 1) % items.length ) {
      int j = i == 0 ? items.length - 1 : i - 1;
      items[j] = items[i];
    }
    tail = tail == 0 ? items.length - 1 : tail - 1;
    items[tail] = null;
    N--;
    if (N > 0 && N == items.length >> 2) {
      resize(items.length >> 1);
    }
    return item;
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
    for (int i = head, j = 0; j < N; i = (i + 1) % items.length, j++) {
      tmp[j] = items[i];
    }
    items = tmp;
    head = 0;
    tail = N;
  }

  private class ArrayIterator implements Iterator<T> {

    private int counter = head;

    @Override
    public boolean hasNext() {
      return counter != tail;
    }

    @Override
    public T next() {
      T item = items[counter];
      counter = (counter + 1) % items.length;
      return item;
    }
  }

}
