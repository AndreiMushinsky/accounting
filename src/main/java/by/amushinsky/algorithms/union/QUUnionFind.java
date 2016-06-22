package by.amushinsky.algorithms.union;

import by.amushinsky.algorithms.union.api.UnionFind;

public class QUUnionFind implements UnionFind {

  private int[] ids;
  private int count;

  public QUUnionFind(int N) {
    count = N;
    ids = new int[N];
    for (int i = 0; i < N; i++) {
      ids[i] = i;
    }
  }
  
  @Override
  public void union(int p, int q) {
    int pId = find(p);
    int qId = find(q);
    if (pId != qId) {
      ids[pId] = qId;
      count--;
    }
  }

  @Override
  public int find(int p) {
    while (p != ids[p]) { 
      p = ids[p];
    }
    return p;
  }

  @Override
  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  @Override
  public int count() {
    return count;
  }

}
