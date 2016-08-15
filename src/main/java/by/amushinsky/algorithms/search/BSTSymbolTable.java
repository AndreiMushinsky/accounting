package by.amushinsky.algorithms.search;

import java.util.Optional;

import by.amushinsky.algorithms.search.api.OrderedSymbolTable;

public class BSTSymbolTable<K extends Comparable<K>, V> implements OrderedSymbolTable<K, V> {

  private Optional<Node> root = Optional.empty();

  private class Node {
    private K key;
    private V value;
    private Optional<Node> left = Optional.empty();
    private Optional<Node> right = Optional.empty();
    private int N;

    public Node(K key, V value, int n) {
      super();
      this.key = key;
      this.value = value;
      N = n;
    }
 
    public int size() {
      return N;
    }
  }

  @Override
  public void put(K key, V value) {
    root = put(root, key, value);
  }

  private Optional<Node> put(Optional<Node> maybeNode, K key, V value) {
    return maybeNode.map(node -> {
      int cmp = key.compareTo(node.key);
      if (cmp < 0)
        node.left = put(node.left, key, value);
      else if (cmp > 0)
        node.right = put(node.right, key, value);
      else
        node.value = value;
      node.N = node.left.map(Node::size).orElse(0) + node.right.map(Node::size).orElse(0) + 1;
      return node;
    });
  }
  
  @Override
  public Optional<V> get(K key) {
    return get(root, key);
  }

  private Optional<V> get(Optional<Node> maybeNode, K key) {
    return maybeNode.flatMap(node -> {
      int cmp = key.compareTo(node.key);
      if (cmp < 0)
        return get(node.left, key);
      else if (cmp > 0)
        return get(node.right, key);
      else
        return Optional.ofNullable(node.value);
    });
  }

  @Override
  public int size() {
    return root.map(Node::size).orElse(0);
  }

  @Override
  public Iterable<K> keys() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public K min() {
    return min(root.get()).key;
  }

  private Node min(Node node) {
    return node.left.map(leftNode -> min(leftNode)).orElse(node);
  }

  @Override
  public K max() {
    return max(root.get()).key;
  }

  private Node max(Node node) {
    return node.right.map(rightNode -> min(rightNode)).orElse(node);
  }

  @Override
  public K floor(K key) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public K ceiling(K key) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int rank(K key) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public K select(int rank) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Iterable<K> keys(K lo, K hi) {
    // TODO Auto-generated method stub
    return null;
  }

}
