package by.amushinsky.algorithms.basic;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import by.amushinsky.algorithms.basic.api.Queue;

public class PriorityQueueTest {

  @Test
  public void enqueueAndIterator() {
    Queue<Integer> queue = new PriorityQueue<>(2);
    queue.enqueue(1);
    queue.enqueue(0);
    queue.enqueue(2);

    Iterator<Integer> iterator = queue.iterator();
    Assert.assertTrue(iterator.hasNext());
    Integer[] items = new Integer[3];

    for (int i = 0; i < items.length; i++) {
      items[i] = iterator.next();
    }

    Assert.assertFalse(iterator.hasNext());
    Assert.assertArrayEquals(items, new Integer[]{2, 1, 0});
  }

  @Test
  public void enqueueDequeueAndIterator() {
    Queue<Integer> queue = new PriorityQueue<>(3);
    queue.enqueue(0);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    queue.dequeue();
    queue.dequeue();

    Iterator<Integer> iterator = queue.iterator();
    Assert.assertTrue(iterator.hasNext());
    Integer[] items = new Integer[2];

    for (int i = 0; i < items.length; i++) {
      items[i] = iterator.next();
    }

    Assert.assertFalse(iterator.hasNext());
    Assert.assertArrayEquals(items, new Integer[]{1, 0});
  }

  @Test(expected=IllegalStateException.class)
  public void emptyQueueDequeue() {
    Queue<Integer> queue = new PriorityQueue<>(10);
    Assert.assertTrue(queue.isEmpty());
    queue.dequeue();
  }
  
  @Test
  public void isEmpty() {
    Queue<Integer> queue = new PriorityQueue<>(2);
    Assert.assertTrue(queue.isEmpty());
    queue.enqueue(0);
    Assert.assertFalse(queue.isEmpty());
    queue.dequeue();
    Assert.assertTrue(queue.isEmpty());
  }

  @Test
  public void size() {
    Queue<Integer> queue = new PriorityQueue<>(3);
    Assert.assertEquals(queue.size(), 0);
    queue.enqueue(0);
    Assert.assertEquals(queue.size(), 1);
    queue.enqueue(1);
    queue.enqueue(2);
    Assert.assertEquals(queue.size(), 3);
    queue.dequeue();
    queue.dequeue();
    Assert.assertEquals(queue.size(), 1);
  }
}
