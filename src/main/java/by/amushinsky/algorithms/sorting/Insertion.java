package by.amushinsky.algorithms.sorting;

public class Insertion {

  public static <T extends Comparable<T>> void sort(T[] ts) {
    sort(ts, 0, ts.length - 1);
  }

  public static <T extends Comparable<T>> void sort(T[] ts, int lo, int hi) {
    if (lo >= hi) {
      return;
    } 
    int min = lo;
    for (int i = lo; i <= hi; i++) {
      if (less(ts[i], ts[min])) {
        min = i;
      }
    }
    exchange(ts, min, lo);
    for (int i = lo + 1 ; i <= hi; i++) {
      int j =  i;
      T t = ts[j];
      while (less(t, ts[j-1])) {
        ts[j] = ts[j-1];
        j--;
      }
      ts[j] = t;
    }
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
