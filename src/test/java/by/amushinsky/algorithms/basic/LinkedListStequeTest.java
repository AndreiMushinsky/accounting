package by.amushinsky.algorithms.basic;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import by.amushinsky.algorithms.basic.api.Steque;

public class LinkedListStequeTest {

  @Test
  public void popAndEnqueueIterator() {
    Steque<Integer> steque = new LinkedListSteque<>();
    steque.push(1);
    steque.push(0);
    steque.enqueue(2);

    Iterator<Integer> iterator = steque.iterator();
    Assert.assertTrue(iterator.hasNext());
    Integer[] items = new Integer[3];

    for (int i = 0; i < items.length; i++) {
      items[i] = iterator.next();
    }

    Assert.assertFalse(iterator.hasNext());
    Assert.assertArrayEquals(items, new Integer[]{0, 1, 2});
  }

  @Test
  public void pushPopEnqueueAndIterator() {
    Steque<Integer> steque = new LinkedListSteque<>();
    steque.push(2);
    steque.push(1);
    steque.push(0);
    steque.enqueue(3);

    steque.pop();
    steque.pop();

    Iterator<Integer> iterator = steque.iterator();
    Assert.assertTrue(iterator.hasNext());
    Integer[] items = new Integer[2];

    for (int i = 0; i < items.length; i++) {
      items[i] = iterator.next();
    }

    Assert.assertFalse(iterator.hasNext());
    Assert.assertArrayEquals(items, new Integer[]{2, 3});
  }

  @Test(expected=IllegalStateException.class)
  public void emptyStequekPop() {
    Steque<Integer> steque = new LinkedListSteque<>();
    Assert.assertTrue(steque.isEmpty());
    steque.pop();
  }

  @Test
  public void isEmpty() {
    Steque<Integer> steque = new LinkedListSteque<>();
    Assert.assertTrue(steque.isEmpty());
    steque.push(0);
    Assert.assertFalse(steque.isEmpty());
    steque.pop();
    Assert.assertTrue(steque.isEmpty());
    steque.enqueue(0);
    Assert.assertFalse(steque.isEmpty());
  }

  @Test
  public void size() {
    Steque<Integer> steque = new LinkedListSteque<>();
    Assert.assertEquals(steque.size(), 0);
    steque.push(0);
    Assert.assertEquals(steque.size(), 1);
    steque.push(1);
    steque.enqueue(2);
    Assert.assertEquals(steque.size(), 3);
    steque.pop();
    steque.pop();
    Assert.assertEquals(steque.size(), 1);
  }
}
