package by.amushinsky.algorithms.basic;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import by.amushinsky.algorithms.basic.api.Stack;

public class ResizingArrayStackTest {

  @Test
  public void popAndIterator() {
    Stack<Integer> stack = new ResizingArrayStack<>();
    stack.push(0);
    stack.push(1);
    stack.push(2);

    Iterator<Integer> iterator = stack.iterator();
    Assert.assertTrue(iterator.hasNext());
    Integer[] items = new Integer[3];

    for (int i = 0; i < items.length; i++) {
      items[i] = iterator.next();
    }

    Assert.assertFalse(iterator.hasNext());
    Assert.assertArrayEquals(items, new Integer[]{2, 1, 0});
  }

  @Test
  public void pushPopAndIterator() {
    Stack<Integer> stack = new ResizingArrayStack<>();
    stack.push(0);
    stack.push(1);
    stack.push(2);
    stack.push(3);

    stack.pop();
    stack.pop();

    Iterator<Integer> iterator = stack.iterator();
    Assert.assertTrue(iterator.hasNext());
    Integer[] items = new Integer[2];

    for (int i = 0; i < items.length; i++) {
      items[i] = iterator.next();
    }

    Assert.assertFalse(iterator.hasNext());
    Assert.assertArrayEquals(items, new Integer[]{1, 0});
  }

  @Test(expected=IllegalStateException.class)
  public void emptyStackPop() {
    Stack<Integer> stack = new ResizingArrayStack<>();
    Assert.assertTrue(stack.isEmpty());
    stack.pop();
  }

  @Test(expected=IllegalStateException.class)
  public void emptyStackPeek() {
    Stack<Integer> stack = new ResizingArrayStack<>();
    Assert.assertTrue(stack.isEmpty());
    stack.peek();
  }

  @Test
  public void isEmpty() {
    Stack<Integer> stack = new ResizingArrayStack<>();
    Assert.assertTrue(stack.isEmpty());
    stack.push(0);
    Assert.assertFalse(stack.isEmpty());
    stack.pop();
    Assert.assertTrue(stack.isEmpty());
  }

  @Test
  public void size() {
    Stack<Integer> stack = new ResizingArrayStack<>();
    Assert.assertEquals(stack.size(), 0);
    stack.push(0);
    Assert.assertEquals(stack.size(), 1);
    stack.push(1);
    stack.push(2);
    Assert.assertEquals(stack.size(), 3);
    stack.pop();
    stack.pop();
    Assert.assertEquals(stack.size(), 1);
  }
}
