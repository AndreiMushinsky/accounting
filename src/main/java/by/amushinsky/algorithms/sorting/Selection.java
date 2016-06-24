package by.amushinsky.algorithms.sorting;

public class Selection {

  public static <T extends Comparable<T>> void sort(T[] ts) {
    int N = ts.length;
    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i + 1; j < N; j++) {
        if (less(ts[j], ts[min])) {
          exchange(ts, min, j);
        }
      }
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
