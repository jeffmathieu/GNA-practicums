package gna;

import java.util.*;

import libpract.PriorityFunc;

public class Solver
{
	/**
	 * Finds a solution to the initial board.
	 *
	 * @param priority is either PriorityFunc.HAMMING or PriorityFunc.MANHATTAN
	 */

	public ArrayList<Board> test = new ArrayList<>();

	public Solver(Board initial, PriorityFunc priority)
	{


		// Use the given priority function (either PriorityFunc.HAMMING
		// or PriorityFunc.MANHATTAN) to solve the puzzle.
		if (priority == PriorityFunc.HAMMING) {

			boolean a = true;

			test.add(initial);

			while (a) {
				PriorityQueue<Board> queue = new PriorityQueue();
				ArrayList<Board> neighbors;
				Board tempBoard = queue.poll();

				PriorityQueue<Board> tempQueue = new PriorityQueue<>(Comparator.comparing(Board::hamming));
				int yeet = test.size();
				tempQueue.addAll(test.get(yeet-1).neighbors());

				this.test.add(tempQueue.poll());
				if (this.test.get(yeet).hamming() == 0)
					a = false;
			}



		} else if (priority == PriorityFunc.MANHATTAN) {
			boolean a = true;

			while (a) {
				PriorityQueue<Board> tempQueue = new PriorityQueue<>(Comparator.comparing(Board::hamming));

				tempQueue.addAll(initial.neighbors());

				ArrayList<Board> tussendoor = new ArrayList<>();

				this.test.add(tempQueue.poll());
				int yeet = this.test.size();
				if (test.get(yeet - 1).manhattan() == 0)
					a = false;
			}
		} else {
			throw new IllegalArgumentException("Priority function not supported");
		}

		// TODO
	}
	

	/**
	 * Returns a List of board positions as the solution. It should contain the initial
	 * Board as well as the solution (if these are equal only one Board is returned).
	 */
	public List<Board> solution()
	{
		return this.test; // TODO
	}
}


