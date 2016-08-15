package by.amushinsky.algorithms.search.api;

public interface OrderedSymbolTable<K extends Comparable<K>, V> extends SymbolTable<K, V> {

  K min();

  K max();

  K floor(K key);

  K ceiling(K key);

  int rank(K key);

  K select(int rank);

  Iterable<K> keys(K lo, K hi);

  default void deleteMin() {
    delete(min());
  };

  default void deleteMax() {
    delete(max());
  };

  default int size(K lo, K hi) {
    if (hi.compareTo(lo) < 0) {
      return 0;
    } else {
      return rank(hi) - rank(lo) + (contains(hi) ? 1 : 0);
    }
  };

  default Iterable<K> keys() {
    return keys(min(), max());
  };
}
