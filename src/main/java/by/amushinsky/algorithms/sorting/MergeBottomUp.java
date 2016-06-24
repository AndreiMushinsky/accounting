package by.amushinsky.algorithms.sorting;

public class MergeBottomUp {

  @SuppressWarnings("unchecked")
  public static <T extends Comparable<T>> void sort(T[] ts) {
    int N = ts.length;
    T[] tmp = (T[]) new Comparable[ts.length];
    for (int sz = 1; sz < N; sz <<= 1 ) {
      for (int lo = 0; lo < N - sz; lo += (sz << 1)) {
        merge(ts, tmp, lo, lo + sz - 1, Math.min(lo + (sz<<1) - 1, N-1));
      }
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
