package by.amushinsky.algorithms.union;

public class PathCompressionQUUnionFind extends QUUnionFind {

  public PathCompressionQUUnionFind(int N) {
    super(N);
  }

  @Override
  public void union(int p, int q) {
    int pId = find(p);
    int qId = find(q);
    if (pId != qId) {
      while (p != pId) {
        int next = ids[p];
        ids[p] = qId;
        p = next;
      }
      ids[pId] = qId;
      count--;
    }
  }

}
