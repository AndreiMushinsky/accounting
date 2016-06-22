package by.amushinsky.algorithms.union;

import by.amushinsky.algorithms.union.api.UnionFind;

public class WeightedQUUnionFind implements UnionFind {

  private int[] ids;
  private int[] szs;
  private int count;

  public WeightedQUUnionFind(int N) {
    count = N;
    ids = new int[N];
    for (int i = 0; i < N; i++) {
      ids[i] = i;
    }
    szs = new int[N];
    for (int i = 0; i < szs.length; i++) {
      szs[i] = 1;
    }
  }
  
  @Override
  public void union(int p, int q) {
    int pId = find(p);
    int qId = find(q);
    if (pId != qId) {
      if (szs[pId] < szs[qId]) {
        ids[pId] = qId;
        szs[qId] += szs[pId];
      } else {
        ids[qId] = pId;
        szs[pId] += szs[qId];
      }
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
