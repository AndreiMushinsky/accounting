package by.amushinsky.algorithms.union;

import java.io.File;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import by.amushinsky.algorithms.union.api.UnionFind;

public class UnionFindTest {

  private File file = new File("src/test/resources/union/test.data");

  @Test
  public void quickFind() throws Exception {
    try (Scanner scan = new Scanner(file)) {
      int N = scan.nextInt();
      UnionFind unionFind = new QFUnionFind(N);
      while (scan.hasNextLine()) {
        int p = scan.nextInt();
        int q = scan.nextInt();
        unionFind.union(p, q);
        Assert.assertTrue(unionFind.connected(p, q));
      }
      Assert.assertEquals(1, unionFind.find(0));
      Assert.assertEquals(8, unionFind.find(3));
      Assert.assertEquals(1, unionFind.find(7));
      Assert.assertFalse(unionFind.connected(0, 9));
      Assert.assertTrue(unionFind.connected(2, 7));
    }
  }

  @Test
  public void quickUnion() throws Exception {
    try (Scanner scan = new Scanner(file)) {
      int N = scan.nextInt();
      UnionFind unionFind = new QUUnionFind(N);
      while (scan.hasNextLine()) {
        int p = scan.nextInt();
        int q = scan.nextInt();
        unionFind.union(p, q);
        Assert.assertTrue(unionFind.connected(p, q));
      }
      Assert.assertEquals(1, unionFind.find(0));
      Assert.assertEquals(8, unionFind.find(3));
      Assert.assertEquals(1, unionFind.find(7));
      Assert.assertFalse(unionFind.connected(0, 9));
      Assert.assertTrue(unionFind.connected(2, 7));
    }
  }

  @Test
  public void quickUnionPathCompression() throws Exception {
    try (Scanner scan = new Scanner(file)) {
      int N = scan.nextInt();
      UnionFind unionFind = new PathCompressionQUUnionFind(N);
      while (scan.hasNextLine()) {
        int p = scan.nextInt();
        int q = scan.nextInt();
        unionFind.union(p, q);
        Assert.assertTrue(unionFind.connected(p, q));
      }
      Assert.assertEquals(1, unionFind.find(0));
      Assert.assertEquals(8, unionFind.find(3));
      Assert.assertEquals(1, unionFind.find(7));
      Assert.assertFalse(unionFind.connected(0, 9));
      Assert.assertTrue(unionFind.connected(2, 7));
    }
  }

  @Test
  public void weightedQuickUnion() throws Exception {
    try (Scanner scan = new Scanner(file)) {
      int N = scan.nextInt();
      UnionFind unionFind = new WeightedQUUnionFind(N);
      while (scan.hasNextLine()) {
        int p = scan.nextInt();
        int q = scan.nextInt();
        unionFind.union(p, q);
        Assert.assertTrue(unionFind.connected(p, q));
      }
      Assert.assertEquals(6, unionFind.find(0));
      Assert.assertEquals(4, unionFind.find(3));
      Assert.assertEquals(6, unionFind.find(7));
      Assert.assertFalse(unionFind.connected(0, 9));
      Assert.assertTrue(unionFind.connected(2, 7));
    }
  }

  @Test
  public void weightedQuickUnionPathCompression() throws Exception {
    try (Scanner scan = new Scanner(file)) {
      int N = scan.nextInt();
      UnionFind unionFind = new PathCompressionWeightedQUUnionFind(N);
      while (scan.hasNextLine()) {
        int p = scan.nextInt();
        int q = scan.nextInt();
        unionFind.union(p, q);
        Assert.assertTrue(unionFind.connected(p, q));
      }
      Assert.assertEquals(6, unionFind.find(0));
      Assert.assertEquals(4, unionFind.find(3));
      Assert.assertEquals(6, unionFind.find(7));
      Assert.assertFalse(unionFind.connected(0, 9));
      Assert.assertTrue(unionFind.connected(2, 7));
    }
  }
}
