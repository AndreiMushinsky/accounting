package by.amushinsky.algorithms.basic;

import java.util.Iterator;
import java.util.Random;

import by.amushinsky.algorithms.basic.api.RandomQueue;

public class ResizingArrayRandomQueue<T> implements RandomQueue<T> {

  @SuppressWarnings("unchecked")
  private T[] items = (T[]) new Object[2];
  private int N = 0;
  private int head = 0;
  private int tail = 0;
  
  @Override
  public Iterator<T> iterator() {
    return new RandomArrayIterator();
  }

  @Override
  public void enqueue(T item) {
    if (N == items.length) {
      resize(items.length << 1);
    }
    items[tail] = item;
    tail = (tail + 1) % items.length;
    N++;
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("Enqueue an empty random queue");
    }
    T item = items[head];
    items[head] = null;
    head = (head + 1) % items.length;
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

  private class RandomArrayIterator implements Iterator<T> {

    private T[] iterable;
    private int bound;
    private Random random;

    @SuppressWarnings("unchecked")
    public RandomArrayIterator() {
      iterable = (T[]) new Object[N];
      bound = N;
      random = new Random(System.currentTimeMillis());
      for (int i = head, j = 0; j < N; i = (i + 1) % items.length, j++) {
        iterable[j] = items[i];
      }
    }

    @Override
    public boolean hasNext() {
      return bound > 0;
    }

    @Override
    public T next() {
      int i = random.nextInt(bound);
      T item = iterable[i];
      move(--bound, i);
      return item;
    }

    private void move(int from, int to) {
      iterable[to] = iterable[from];
    }
  }

}
