package by.amushinsky.algorithms.sorting;

import by.amushinsky.algorithms.shuffle.FisherYates;

public class Quick {

  private static final int CUTOFF = 7;
  
  public static <T extends Comparable<T>> void sort(T[] ts) {
    FisherYates.shuffle(ts);
    sort(ts, 0, ts.length - 1);
  }

  private static <T extends Comparable<T>> void sort(T[] ts, int lo, int hi) {
    if (hi <= lo + CUTOFF) {
      Insertion.sort(ts, lo, hi);
    } else {
      int j = partition(ts, lo, hi);
      sort(ts, lo, j-1);
      sort(ts, j+1, hi);
    }
  }

  private static <T extends Comparable<T>> int partition(T[] ts, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    T value = ts[lo];
    while (true) {
      while (less(ts[++i], value)) {
        if (i == hi) {
          break;
        }
      }
      while (less(value, ts[--j])) {}
      if (i >= j) {
        break;
      }
      exchange(ts, i, j);
    }
    exchange(ts, lo, j);
    return j;
  }

  private static <T> void exchange(T[] ts, int i, int j) {
    T tmp = ts[i];
    ts[i] = ts[j];
    ts[j] = tmp;
  }

  private static <T extends Comparable<T>> boolean less(T x, T y) {
    return x.compareTo(y) < 0;
  }
}
