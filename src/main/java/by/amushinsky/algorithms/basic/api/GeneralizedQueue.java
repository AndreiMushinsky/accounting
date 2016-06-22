package by.amushinsky.algorithms.basic.api;

public interface GeneralizedQueue<T> extends Iterable<T> {

  void insert(T item);

  T delete(int k);

  boolean isEmpty();

  int size();

}
