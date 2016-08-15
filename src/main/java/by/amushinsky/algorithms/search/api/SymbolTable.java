package by.amushinsky.algorithms.search.api;

import java.util.Optional;

public interface SymbolTable<K, V> {

  void put(K key, V value);

  Optional<V> get(K key);

  int size();
  
  Iterable<K> keys();

  default void delete(K key) {
    put(key, null);
  };

  default boolean contains(K key) {
    return get(key) != null;
  };

  default boolean isEmpty() {
    return size() == 0;
  };

}
