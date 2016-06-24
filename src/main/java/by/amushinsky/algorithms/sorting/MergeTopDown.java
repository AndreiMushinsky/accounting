package by.amushinsky.algorithms.sorting;

public class MergeTopDown {

  @SuppressWarnings("unchecked")
  public static <T extends Comparable<T>> void sort(T[] ts) {
    T[] tmp = (T[]) new Comparable[ts.length];
    sort(ts, tmp, 0, ts.length - 1);
  }

  private static <T extends Comparable<T>> void sort(T[] ts, T[] tmp, int lo, int hi) {
    if (lo < hi) {
      int mid = lo + (hi - lo)/2;
      sort(ts, tmp, lo, mid);
      sort(ts, tmp, mid+1, hi);
      merge(ts, tmp, lo, mid, hi);
    }
  }
  
  private static <T extends Comparable<T>> void merge(T[] ts, T[] tmp, int lo, int mid, int hi) {
    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      tmp[k] = ts[k];
    }
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        ts[k] = tmp[j++];
      } else if (j > hi) {
        ts[k] = tmp[i++];
      } else if (less(tmp[j], tmp[i])) {
        ts[k] = tmp[j++];
      } else {
        ts[k] = tmp[i++];
      }
    }
  }

  private static <T extends Comparable<T>> boolean less(T x, T y) {
    return x.compareTo(y) < 0;
  }
}
