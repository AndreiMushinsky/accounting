package by.amushinsky.algorithms.union;

public class WeightedQUUnionFind extends QUUnionFind {

  protected int[] szs;

  public WeightedQUUnionFind(int N) {
    super(N);
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

}
