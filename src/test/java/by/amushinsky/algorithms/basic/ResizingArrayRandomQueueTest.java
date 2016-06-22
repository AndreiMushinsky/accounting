package by.amushinsky.algorithms.basic;

import java.util.Arrays;
import java.util.Iterator;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import by.amushinsky.algorithms.basic.api.RandomQueue;

public class ResizingArrayRandomQueueTest {

  @Test
  public void enqueueAndIterator() {
    RandomQueue<Integer> queue = new ResizingArrayRandomQueue<>();
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
    Assert.assertThat(Arrays.asList(items), CoreMatchers.hasItems(0, 1, 2));
  }

  @Test
  public void enqueueDequeueAndIterator() {
    RandomQueue<Integer> queue = new ResizingArrayRandomQueue<>();
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
    Assert.assertThat(Arrays.asList(items), CoreMatchers.hasItems(2, 3));
  }

  @Test(expected=IllegalStateException.class)
  public void emptyQueueDequeue() {
    RandomQueue<Integer> queue = new ResizingArrayRandomQueue<>();
    Assert.assertTrue(queue.isEmpty());
    queue.dequeue();
  }
  
  @Test
  public void isEmpty() {
    RandomQueue<Integer> queue = new ResizingArrayRandomQueue<>();
    Assert.assertTrue(queue.isEmpty());
    queue.enqueue(0);
    Assert.assertFalse(queue.isEmpty());
    queue.dequeue();
    Assert.assertTrue(queue.isEmpty());
  }

  @Test
  public void size() {
    RandomQueue<Integer> queue = new ResizingArrayRandomQueue<>();
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
