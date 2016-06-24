package by.amushinsky.algorithms.sorting;

import java.io.File;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import by.amushinsky.algorithms.sorting.Selection;

public class SortingTest {

  private File file = new File("src/test/resources/sort/test.data");

  private Character[] expected = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
      'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
  
  @Test
  public void selection() throws Exception {
    try (Scanner scan = new Scanner(file)) {
      int N = scan.nextInt();
      Character[] chars = new Character[N];
      for (int i = 0; i < chars.length; i++) {
        chars[i] = (char) scan.next().charAt(0);
      }
      Selection.sort(chars);
      Assert.assertArrayEquals(expected, chars);
    }
  }

  @Test
  public void insertion() throws Exception {
    try (Scanner scan = new Scanner(file)) {
      int N = scan.nextInt();
      Character[] chars = new Character[N];
      for (int i = 0; i < chars.length; i++) {
        chars[i] = (char) scan.next().charAt(0);
      }
      Insertion.sort(chars);
      Assert.assertArrayEquals(expected, chars);
    }
  }

  @Test
  public void shell() throws Exception {
    try (Scanner scan = new Scanner(file)) {
      int N = scan.nextInt();
      Character[] chars = new Character[N];
      for (int i = 0; i < chars.length; i++) {
        chars[i] = (char) scan.next().charAt(0);
      }
      Shell.sort(chars);
      Assert.assertArrayEquals(expected, chars);
    }
  }
}
