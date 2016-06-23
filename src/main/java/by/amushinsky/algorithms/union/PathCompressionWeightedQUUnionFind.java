package by.amushinsky.algorithms.union;

public class PathCompressionWeightedQUUnionFind extends WeightedQUUnionFind {

  public PathCompressionWeightedQUUnionFind(int N) {
    super(N);
  }

  @Override
  public void union(int p, int q) {
    int pId = find(p);
    int qId = find(q);
    if (pId != qId) {
      if (szs[pId] < szs[qId]) {
        while (p != pId) {
          int next = ids[p];
          ids[p] = qId;
          szs[qId] += szs[p];
          szs[pId] -= szs[p];
          p = next;
        }
        ids[pId] = qId;
        szs[qId] += szs[pId];
        count--;
      } else {
        while (q != qId) {
          int next = ids[q];
          ids[q] = pId;
          szs[pId] += szs[q];
          szs[qId] -= szs[q];
          q = next;
        }
        ids[qId] = pId;
        szs[pId] += szs[qId];
        count--;
      }

    }
  }

}
