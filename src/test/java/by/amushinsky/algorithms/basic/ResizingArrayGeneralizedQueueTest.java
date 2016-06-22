package by.amushinsky.algorithms.basic;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import by.amushinsky.algorithms.basic.api.GeneralizedQueue;

public class ResizingArrayGeneralizedQueueTest {

  @Test
  public void insertAndIterator() {
    GeneralizedQueue<Integer> queue = new ResizingArrayGeneralizedQueue<>();
    queue.insert(0);
    queue.insert(1);
    queue.insert(2);

    Iterator<Integer> iterator = queue.iterator();
    Assert.assertTrue(iterator.hasNext());
    Integer[] items = new Integer[3];

    for (int i = 0; i < items.length; i++) {
      items[i] = iterator.next();
    }

    Assert.assertFalse(iterator.hasNext());
    Assert.assertArrayEquals(items, new Integer[]{0, 1, 2});
  }

  @Test
  public void insertDeleteAndIterator() {
    GeneralizedQueue<Integer> queue = new ResizingArrayGeneralizedQueue<>();
    queue.insert(0);
    queue.insert(1);
    queue.insert(2);
    queue.insert(3);

    queue.delete(2);
    queue.delete(3);

    Iterator<Integer> iterator = queue.iterator();
    Assert.assertTrue(iterator.hasNext());
    Integer[] items = new Integer[2];

    for (int i = 0; i < items.length; i++) {
      items[i] = iterator.next();
    }

    Assert.assertFalse(iterator.hasNext());
    Assert.assertArrayEquals(items, new Integer[]{0, 2});
  }

  @Test(expected=IllegalStateException.class)
  public void emptyQueueDelete() {
    GeneralizedQueue<Integer> queue = new ResizingArrayGeneralizedQueue<>();
    Assert.assertTrue(queue.isEmpty());
    queue.delete(1);
  }

  @Test(expected=IllegalArgumentException.class)
  public void negativeDelete() {
    GeneralizedQueue<Integer> queue = new ResizingArrayGeneralizedQueue<>();
    queue.insert(0);
    queue.insert(1);
    queue.insert(2);
    queue.delete(-1);
  }

  @Test(expected=IllegalArgumentException.class)
  public void outOfRangeDelete() {
    GeneralizedQueue<Integer> queue = new ResizingArrayGeneralizedQueue<>();
    queue.insert(0);
    queue.insert(1);
    queue.insert(2);
    queue.delete(4);
  }

  @Test
  public void isEmpty() {
    GeneralizedQueue<Integer> queue = new ResizingArrayGeneralizedQueue<>();
    Assert.assertTrue(queue.isEmpty());
    queue.insert(0);
    Assert.assertFalse(queue.isEmpty());
    queue.delete(1);
    Assert.assertTrue(queue.isEmpty());
  }

  @Test
  public void size() {
    GeneralizedQueue<Integer> queue = new ResizingArrayGeneralizedQueue<>();
    Assert.assertEquals(queue.size(), 0);
    queue.insert(0);
    Assert.assertEquals(queue.size(), 1);
    queue.insert(1);
    queue.insert(2);
    Assert.assertEquals(queue.size(), 3);
    queue.delete(1);
    queue.delete(1);
    Assert.assertEquals(queue.size(), 1);
  }
}
