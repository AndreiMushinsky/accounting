package by.amushinsky.algorithms.sorting;

public class Heap {

  public static <T extends Comparable<T>> void sort(T[] ts) {
    int N = ts.length;
    for (int k = N / 2; k >= 1; k--) {
      sink(ts, k, N);
    }
    while (N > 1) {
      exchange(ts, 1, N--);
      sink(ts, 1, N);
    }
  }

  private static <T extends Comparable<T>> void sink(T[] ts, int k, int N) {
    while (2 * k <= N) {
      int j = 2 * k;
      if (j < N && less(ts, j, j + 1)) {
        j++;
      }
      if (!less(ts, k, j)) {
        break;
      }
      exchange(ts, k, j);
      k = j;
    }
  }

  private static <T> void exchange(T[] ts, int i, int j) {
    T tmp = ts[i - 1];
    ts[i - 1] = ts[j - 1];
    ts[j - 1] = tmp;
  }

  private static <T extends Comparable<T>> boolean less(T[] ts, int x, int y) {
    return ts[x - 1].compareTo(ts[y - 1]) < 0;
  }
}
