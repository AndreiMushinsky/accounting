package by.amushinsky.algorithms.shuffle;

import java.util.Random;

public class FisherYates {

  public static final <T> void shuffle(T[] array) {
    Random random = new Random(System.currentTimeMillis());
    for (int i = array.length - 1; i > 0; i--) {
      int j = random.nextInt(i + 1);
      exchange(array, i, j);
    }
  }

  private static <T> void exchange(T[] ts, int i, int j) {
    T tmp = ts[i];
    ts[i] = ts[j];
    ts[j] = tmp;
  }

}
