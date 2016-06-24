package by.amushinsky.algorithms.sorting;

public class Shell {

  public static <T extends Comparable<T>> void sort(T[] ts) {
    int N = ts.length;
    int h = 1;
    while (h < N/3) {
      h = 3*h + 1;
    }
    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h && less(ts[j], ts[j-h]); j -= h) {
          exchange(ts, j, j-h);
        }
      }
      h /= 3;
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
