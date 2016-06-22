package by.amushinsky.algorithms.basic;

import java.util.Iterator;

import by.amushinsky.algorithms.basic.api.Deque;

public class ResizingArrayDeque<T> implements Deque<T> {

  @SuppressWarnings("unchecked")
  private T[] items = (T[]) new Object[2];
  private int rightIndex = 0;
  private int leftIndex = items.length - 1;
  private int N = 0;

  @Override
  public Iterator<T> iterator() {
    return new RingArrayIterator();
  }

  @Override
  public void pushLeft(T item) {
    if (leftIndex == rightIndex) {
      resize(items.length << 1);
    }
    items[leftIndex] = item;
    leftIndex = leftIndex == 0 ? items.length - 1 : leftIndex - 1;
    N++;
  }

  @Override
  public void pushRight(T item) {
    if (leftIndex == rightIndex) {
      resize(items.length << 1);
    }
    items[rightIndex] = item;
    rightIndex = (rightIndex + 1) % items.length;
    N++;
  }

  @Override
  public T popLeft() {
    if (isEmpty()) {
      throw new IllegalStateException("Pop empty deque");
    }
    T item = items[leftIndex = (leftIndex + 1) % items.length];
    items[leftIndex] = null;
    N--;
    if (N > 0 && N == items.length >> 2) {
      resize(items.length >> 1);
    }
    return item;
  }

  @Override
  public T popRight() {
    if (isEmpty()) {
      throw new IllegalStateException("Pop empty deque");
    }
    T item = items[rightIndex = rightIndex == 0 ? items.length - 1 : rightIndex - 1];
    items[rightIndex] = null;
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
    for (int i = (leftIndex + 1) % items.length, j = 0; i != rightIndex; i = (i + 1) % items.length, j++) {
      tmp[j] = items[i];
    }
    items = tmp;
    leftIndex = items.length - 1;
    rightIndex = N;
  }

  private class RingArrayIterator implements Iterator<T> {

    private int i = (leftIndex + 1) % items.length;
    private int j = rightIndex;

    @Override
    public boolean hasNext() {
      return i != j;
    }

    @Override
    public T next() {
      T item = items[i];
      i = (i + 1) % items.length;
      return item;
    }
  }

}
