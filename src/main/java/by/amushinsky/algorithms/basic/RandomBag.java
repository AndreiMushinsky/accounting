package by.amushinsky.algorithms.basic;

import java.util.Iterator;
import java.util.Random;

import by.amushinsky.algorithms.basic.api.Bag;

public class RandomBag<T> implements Bag<T> {

  @SuppressWarnings("unchecked")
  private T[] items = (T[]) new Object[2];
  private int N = 0;

  @Override
  public Iterator<T> iterator() {
    return new RandomArrayIterator();
  }

  @Override
  public void add(T item) {
    if (N == items.length) {
      resize(items.length << 1);
    }
    items[N++] = item;
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

  private class RandomArrayIterator implements Iterator<T> {

    private T[] iterable;
    private int bound;
    private Random random;

    @SuppressWarnings("unchecked")
    public RandomArrayIterator() {
      iterable = (T[]) new Object[N];
      bound = N;
      random = new Random(System.currentTimeMillis());
      for (int i = 0; i < N; i++) {
        iterable[i] = items[i];
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
