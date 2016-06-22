package by.amushinsky.algorithms.basic;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import by.amushinsky.algorithms.basic.api.Queue;

public class LinkedListQueueTest {

  @Test
  public void enqueueAndIterator() {
    Queue<Integer> queue = new LinkedListQueue<>();
    queue.enqueue(0);
    queue.enqueue(1);
    queue.enqueue(2);

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
  public void enqueueDequeueAndIterator() {
    Queue<Integer> queue = new LinkedListQueue<>();
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
    Assert.assertArrayEquals(items, new Integer[]{2, 3});
  }

  @Test(expected=IllegalStateException.class)
  public void emptyQueueDequeue() {
    Queue<Integer> queue = new LinkedListQueue<>();
    Assert.assertTrue(queue.isEmpty());
    queue.dequeue();
  }
  
  @Test
  public void isEmpty() {
    Queue<Integer> queue = new LinkedListQueue<>();
    Assert.assertTrue(queue.isEmpty());
    queue.enqueue(0);
    Assert.assertFalse(queue.isEmpty());
    queue.dequeue();
    Assert.assertTrue(queue.isEmpty());
  }

  @Test
  public void size() {
    Queue<Integer> queue = new LinkedListQueue<>();
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
