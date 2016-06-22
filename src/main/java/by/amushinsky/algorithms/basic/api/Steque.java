package by.amushinsky.algorithms.basic.api;

public interface Steque<T> extends Iterable<T> {

  void push(T item);

  T pop();

  void enqueue(T item);

  boolean isEmpty();

  int size();

}
