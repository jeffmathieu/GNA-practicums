package gna;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import libpract.PriorityFunc;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * A number of JUnit tests for Solver.
 *
 * Feel free to modify these to automatically test puzzles or other functionality
 */
public class UnitTests {
  
  @Test
  public void test() {

    // test hamming and manhattan and solvable for 3X3
    //int[][] tiles = {{1, 2, 0}, {4, 5, 3}, {7, 8, 6}};
    int[][] tiles = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}};
    Board test = new Board(tiles);

    assert test.hamming() == 2;
    assert test.manhattan() == 2;
    assert test.isSolvable();

    // test hamming and manhattan and solvable for 4X4
    int[][] tiles2 = {{6, 9, 7, 4}, {2, 5, 10, 8}, {3, 11, 1, 12}, {13, 14, 15, 0}};
    Board test2 = new Board(tiles2);

    assert test2.hamming() == 9;
    assert test2.manhattan() == 20;

    assert test2.isSolvable();
  }
}
