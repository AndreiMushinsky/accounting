package by.amushinsky.algorithms.sorting;

import by.amushinsky.algorithms.shuffle.FisherYates;

public class Quick3Way {

  private static final int CUTOFF = 7;
  
  public static <T extends Comparable<T>> void sort(T[] ts) {
    FisherYates.shuffle(ts);
    sort(ts, 0, ts.length - 1);
  }

  private static <T extends Comparable<T>> void sort(T[] ts, int lo, int hi) {
    if (hi <= lo + CUTOFF) {
      Insertion.sort(ts, lo, hi);
    } else {
      int lt = lo;
      int i = lo + 1;
      int gt = hi;
      T value = ts[lo];
      while (i <= gt) {
        int cmp = ts[i].compareTo(value);
        if (cmp < 0) {
          exchange(ts, lt++, i++);
        } else if (cmp > 0) {
          exchange(ts, i, gt--);
        } else {
          i++;
        }
      }
      sort(ts, lo, lt-1);
      sort(ts, gt+1, hi);
    }
  }
  private static <T> void exchange(T[] ts, int i, int j) {
    T tmp = ts[i];
    ts[i] = ts[j];
    ts[j] = tmp;
  }
}
