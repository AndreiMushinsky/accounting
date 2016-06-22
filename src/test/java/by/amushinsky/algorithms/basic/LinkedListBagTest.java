package by.amushinsky.algorithms.basic;

import java.util.Arrays;
import java.util.Iterator;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import by.amushinsky.algorithms.basic.api.Bag;

public class LinkedListBagTest {

  @Test
  public void addAndIterator() {
    Bag<Integer> bag = new LinkedListBag<>();
    bag.add(0);
    bag.add(1);
    bag.add(2);
    
    Iterator<Integer> iterator = bag.iterator();
    Assert.assertTrue(iterator.hasNext());
    Integer[] items = new Integer[3];
    
    for (int i = 0; i < items.length; i++) {
      items[i] = iterator.next();
    }
    
    Assert.assertFalse(iterator.hasNext());
    Assert.assertThat(Arrays.asList(items), CoreMatchers.hasItems(0, 1, 2));
  }

  @Test
  public void isEmpty() {
    Bag<Integer> bag = new LinkedListBag<>();
    Assert.assertTrue(bag.isEmpty());
    bag.add(0);
    Assert.assertFalse(bag.isEmpty());
  }

  @Test
  public void size() {
    Bag<Integer> bag = new LinkedListBag<>();
    Assert.assertEquals(bag.size(), 0);
    bag.add(0);
    Assert.assertEquals(bag.size(), 1);
    bag.add(1);
    bag.add(2);
    Assert.assertEquals(bag.size(), 3);
  }
}
