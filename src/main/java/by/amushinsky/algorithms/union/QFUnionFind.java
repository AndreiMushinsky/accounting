package by.amushinsky.algorithms.union;

import by.amushinsky.algorithms.union.api.UnionFind;

public class QFUnionFind implements UnionFind {

  private int[] ids;
  private int count;

  public QFUnionFind(int N) {
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
      for (int i = 0; i < ids.length; i++) {
        if (ids[i] == pId) {
          ids[i] = qId;
        }
      }
      count--;
    }
  }

  @Override
  public int find(int p) {
    return ids[p];
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
