package by.amushinsky.algorithms.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import by.amushinsky.algorithms.basic.api.Queue;

public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {

  private int N = 0;
  private T[] items;
  private final Comparator<T> comp;

  @SuppressWarnings("unchecked")
  public PriorityQueue(Comparator<T> comp, int capacity) {
    this.items = (T[]) new Comparable[capacity + 1];
    this.comp = comp;
  }

  @SuppressWarnings("unchecked")
  public PriorityQueue(int capacity) {
    this.items = (T[]) new Comparable[capacity + 1];
    this.comp = (x, y) -> x.compareTo(y);
  }

  @Override
  public Iterator<T> iterator() {
    return new PriorityIterator();
  }

  @Override
  public void enqueue(T item) {
    if (N == items.length - 1) {
      resize(items.length << 1);
    }
    items[++N] = item;
    swim(N);
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("Dequeue an empty queue");
    }
    T top = items[1];
    exchange(1, N--);
    items[N + 1] = null;
    sink(1);
    if (N > 1 && N + 1 == items.length >> 2) {
      resize(items.length >> 1);
    }
    return top;
  }

  @Override
  public boolean isEmpty() {
    return N == 0;
  }

  @Override
  public int size() {
    return N;
  }

  private void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
      exchange(k / 2, k);
      k /= 2;
    }
  }

  private void sink(int k) {
    while (2 * k <= N) {
      int j = 2 * k;
      if (j < N && less(j, j + 1)) {
        j++;
      }
      if (!less(k, j)) {
        break;
      }
      exchange(k, j);
      k = j;
    }
  }

  private boolean less(int x, int y) {
    return comp.compare(items[x], items[y]) < 0;
  }

  private void exchange(int x, int y) {
    T tmp = items[x];
    items[x] = items[y];
    items[y] = tmp;
  }

  @SuppressWarnings("unchecked")
  private void resize(int max) {
    T[] tmp = (T[]) new Comparable[max];
    for (int i = 0; i <= N; i++) {
      tmp[i] = items[i];
    }
    items = tmp;
  }

  private class PriorityIterator implements Iterator<T> {

    private T[] elems = Arrays.copyOf(items, items.length);
    private int IN = N;

    @Override
    public boolean hasNext() {
      return IN > 0;
    }

    @Override
    public T next() {
      T top = elems[1];
      exchange(1, IN--);
      elems[IN + 1] = null;
      sink(1);
      return top;
    }
    
    private void sink(int k) {
      while (2 * k <= IN) {
        int j = 2 * k;
        if (j < IN && less(j, j + 1)) {
          j++;
        }
        if (!less(k, j)) {
          break;
        }
        exchange(k, j);
        k = j;
      }
    }

    private boolean less(int x, int y) {
      return comp.compare(elems[x], elems[y]) < 0;
    }

    private void exchange(int x, int y) {
      T tmp = elems[x];
      elems[x] = elems[y];
      elems[y] = tmp;
    }

  }
}
