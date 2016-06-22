package by.amushinsky.algorithms.basic.api;

public interface Deque<T> extends Iterable<T> {

  void pushLeft(T item);

  void pushRight(T item);
  
  T popLeft();

  T popRight();

  boolean isEmpty();

  int size();

}
