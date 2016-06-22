package by.amushinsky.algorithms.basic;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import by.amushinsky.algorithms.basic.api.Deque;

public class LinkedListDequeTest {

  @Test
  public void pushLeftAndIterator() {
    Deque<Integer> deque = new LinkedListDeque<>();
    deque.pushLeft(2);
    deque.pushLeft(1);
    deque.pushLeft(0);

    Iterator<Integer> iterator = deque.iterator();
    Assert.assertTrue(iterator.hasNext());
    Integer[] items = new Integer[3];

    for (int i = 0; i < items.length; i++) {
      items[i] = iterator.next();
    }

    Assert.assertFalse(iterator.hasNext());
    Assert.assertArrayEquals(items, new Integer[]{0, 1, 2});
  }

  @Test
  public void pushRightAndIterator() {
    Deque<Integer> deque = new LinkedListDeque<>();
    deque.pushRight(0);
    deque.pushRight(1);
    deque.pushRight(2);

    Iterator<Integer> iterator = deque.iterator();
    Assert.assertTrue(iterator.hasNext());
    Integer[] items = new Integer[3];

    for (int i = 0; i < items.length; i++) {
      items[i] = iterator.next();
    }

    Assert.assertFalse(iterator.hasNext());
    Assert.assertArrayEquals(items, new Integer[]{0, 1, 2});
  }

  @Test
  public void popLeftAndIterator() {
    Deque<Integer> deque = new LinkedListDeque<>();
    deque.pushLeft(3);
    deque.pushLeft(2);
    deque.pushLeft(1);
    deque.pushLeft(0);

    deque.popLeft();
    deque.popLeft();

    Iterator<Integer> iterator = deque.iterator();
    Assert.assertTrue(iterator.hasNext());
    Integer[] items = new Integer[2];

    for (int i = 0; i < items.length; i++) {
      items[i] = iterator.next();
    }

    Assert.assertFalse(iterator.hasNext());
    Assert.assertArrayEquals(items, new Integer[]{2, 3});
  }

  @Test
  public void popRightAndIterator() {
    Deque<Integer> deque = new LinkedListDeque<>();
    deque.pushRight(3);
    deque.pushRight(2);
    deque.pushRight(1);
    deque.pushRight(0);

    deque.popRight();
    deque.popRight();

    Iterator<Integer> iterator = deque.iterator();
    Assert.assertTrue(iterator.hasNext());
    Integer[] items = new Integer[2];

    for (int i = 0; i < items.length; i++) {
      items[i] = iterator.next();
    }

    Assert.assertFalse(iterator.hasNext());
    Assert.assertArrayEquals(items, new Integer[]{3, 2});
  }

  @Test(expected=IllegalStateException.class)
  public void emptyDequePopLeft() {
    Deque<Integer> deque = new LinkedListDeque<>();
    Assert.assertTrue(deque.isEmpty());
    deque.popLeft();
  }

  @Test(expected=IllegalStateException.class)
  public void emptyDequePopRight() {
    Deque<Integer> deque = new LinkedListDeque<>();
    Assert.assertTrue(deque.isEmpty());
    deque.popRight();
  }

  @Test
  public void isEmpty() {
    Deque<Integer> deque = new LinkedListDeque<>();
    Assert.assertTrue(deque.isEmpty());
    deque.pushLeft(0);
    Assert.assertFalse(deque.isEmpty());
    deque.popLeft();
    Assert.assertTrue(deque.isEmpty());
    deque.pushRight(0);
    Assert.assertFalse(deque.isEmpty());
    deque.popRight();
    Assert.assertTrue(deque.isEmpty());
  }

  @Test
  public void size() {
    Deque<Integer> deque = new LinkedListDeque<>();
    Assert.assertEquals(deque.size(), 0);
    deque.pushLeft(0);
    Assert.assertEquals(deque.size(), 1);
    deque.pushLeft(1);
    deque.pushRight(2);
    Assert.assertEquals(deque.size(), 3);
    deque.popLeft();
    deque.popRight();
    Assert.assertEquals(deque.size(), 1);
  }

}
