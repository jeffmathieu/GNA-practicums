package gna;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;

public class Board
{
	private final int[][] tiles;
	public int length;

	// construct a board from an N-by-N array of tiles
	public Board( int[][] tiles )
	{
		this.length = tiles.length;
		this.tiles = deepCopy(tiles);
	}

	public int[][] deepCopy(int[][] tiles) {
		int n = tiles.length;
		int[][] result = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = tiles[i][j];
			}
		}
		return result;
	}

	// return number of blocks out of place
	public int hamming()
	{
		int blocksOutOfPlace = 0;
		int tileNumber = 0;
		int n = tiles.length;

		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++) {
				tileNumber++;
				if (tiles[i][j] != tileNumber) {
					if (tiles[i][j] != 0)
						blocksOutOfPlace++;
				}
			}
		}
		return blocksOutOfPlace;
	}
	
	// return sum of Manhattan distances between blocks and goal
	public int manhattan()
	{
		int totalMoves = 0;
		int n = tiles.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int number = tiles[i][j];
				int y = returnYCoord(number, n);
				int x = returnXCoord(number, n, y);
				int movesXPosition = Math.abs(x - j);
				int movesYPosition = Math.abs(y - i);
				if (number == 0) {
					movesYPosition = 0;
					movesXPosition = 0;
				}
				totalMoves = totalMoves + (movesXPosition + movesYPosition);

			}
		}
		return totalMoves;
	}

	// i == gezocht getal, n == afmeting vierkant
	public static int returnYCoord(int i, int n) {
		int yCoord = 0;
		if (i % n == 0) {
			yCoord = i / n - 1;
		}
		else {
			yCoord = i / n;
		}
		return yCoord;
	}

	public static int returnXCoord(int i, int n, int yCoord) {
		int xCoord = i - (yCoord * n) - 1;
		return xCoord;
	}
	
	// Does this board equal y. Two boards are equal when they both were constructed
	// using tiles[][] arrays that contained the same values.
	@Override
	public boolean equals(Object y)
	{
		if ( !(y instanceof Board) )
			return false;

		Board other = (Board)y;
		return Arrays.deepEquals(tiles, other.tiles);
	}

	// Since we override equals(), we must also override hashCode(). When two objects are
	// equal according to equals() they must return the same hashCode. More info:
	// - http://stackoverflow.com/questions/27581/what-issues-should-be-considered-when-overriding-equals-and-hashcode-in-java/27609#27609
	// - http://www.ibm.com/developerworks/library/j-jtp05273/
    @Override
    public int hashCode()
	{
		return Arrays.deepHashCode(tiles);
	}
	
	// return a Collection of all neighboring board positions
	public Collection<Board> neighbors() {

		ArrayList<Board> result = new ArrayList<>();
		int n = tiles.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// Als tile 0 is moet die verplaatst worden.
				if (tiles[i][j] == 0) {
					// alle mogelijkheden
					// links boven
					if (i == 0 && j == 0) {
						int[][] neighbor1 = deepCopy(tiles);
						int[][] neighbor2 = deepCopy(tiles);

						//neighbor1 vakje naar rechts bewegen
						neighbor1[i][j] = neighbor1[i][j+1];
						neighbor1[i][j+1] = 0;
						Board neighbor_1 = new Board(neighbor1);

						result.add(neighbor_1);

						//neighbor2 vakje naar onder bewegen
						neighbor2[i][j] = neighbor2[i+1][j];
						neighbor2[i+1][j] = 0;
						Board neighbor_2 = new Board(neighbor2);

						result.add(neighbor_2);

					}

					// rechts boven
					if (i == 0 && j == n-1) {
						int[][] neighbor1 = deepCopy(tiles);
						int[][] neighbor2 = deepCopy(tiles);

						//neighbor1 vakje naar links bewegen
						neighbor1[i][j] = neighbor1[i][j-1];
						neighbor1[i][j-1] = 0;
						Board neighbor_1 = new Board(neighbor1);

						result.add(neighbor_1);

						//neighbor2 vakje naar onder bewegen
						neighbor2[i][j] = neighbor2[i+1][j];
						neighbor2[i+1][j] = 0;
						Board neighbor_2 = new Board(neighbor2);

						result.add(neighbor_2);
					}

					// links onder
					if (i == n-1 && j == 0) {
						int[][] neighbor1 = deepCopy(tiles);
						int[][] neighbor2 = deepCopy(this.tiles);

						//neighbor1 vakje naar rechts bewegen
						neighbor1[i][j] = neighbor1[i][j+1];
						neighbor1[i][j+1] = 0;
						Board neighbor_1 = new Board(neighbor1);

						result.add(neighbor_1);

						//neighbor2 vakje naar boven bewegen
						neighbor2[i][j] = neighbor2[i-1][j];
						neighbor2[i-1][j] = 0;
						Board neighbor_2 = new Board(neighbor2);

						result.add(neighbor_2);
					}

					// rechts onder
					if (i == n-1 && j == n-1) {
						int[][] neighbor1 = deepCopy(tiles);
						int[][] neighbor2 = deepCopy(tiles);

						//neighbor1 vakje naar links bewegen
						neighbor1[i][j] = neighbor1[i][j-1];
						neighbor1[i][j-1] = 0;
						Board neighbor_1 = new Board(neighbor1);

						result.add(neighbor_1);

						//neighbor2 vakje naar boven bewegen
						neighbor2[i][j] = neighbor2[i-1][j];
						neighbor2[i-1][j] = 0;
						Board neighbor_2 = new Board(neighbor2);

						result.add(neighbor_2);
					}

					// links
					if (i<n-1 && i>0  && j == 0) {
						int[][] neighbor1 = deepCopy(tiles);
						int[][] neighbor2 = deepCopy(tiles);
						int[][] neighbor3 = deepCopy(tiles);

						//neighbor1 vakje naar boven bewegen
						neighbor1[i][j] = neighbor1[i-1][j];
						neighbor1[i-1][j] = 0;
						Board neighbor_1 = new Board(neighbor1);

						result.add(neighbor_1);

						//neighbor2 vakje naar onder bewegen
						neighbor2[i][j] = neighbor2[i+1][j];
						neighbor2[i+1][j] = 0;
						Board neighbor_2 = new Board(neighbor2);

						result.add(neighbor_2);

						//neighbor3 vakje naar rechts bewegen
						neighbor3[i][j] = neighbor2[i][j+1];
						neighbor3[i][j+1] = 0;
						Board neighbor_3 = new Board(neighbor3);

						result.add(neighbor_3);
					}

					// rechts
					if (i<n-1 && i>0  && j == n-1) {
						int[][] neighbor1 = deepCopy(tiles);
						int[][] neighbor2 = deepCopy(tiles);
						int[][] neighbor3 = deepCopy(tiles);

						//neighbor1 vakje naar boven bewegen
						neighbor1[i][j] = neighbor1[i-1][j];
						neighbor1[i-1][j] = 0;
						Board neighbor_1 = new Board(neighbor1);

						result.add(neighbor_1);

						//neighbor2 vakje naar onder bewegen
						neighbor2[i][j] = neighbor2[i+1][j];
						neighbor2[i+1][j] = 0;
						Board neighbor_2 = new Board(neighbor2);

						result.add(neighbor_2);

						//neighbor3 vakje naar links bewegen
						neighbor3[i][j] = neighbor2[i][j-1];
						neighbor3[i][j-1] = 0;
						Board neighbor_3 = new Board(neighbor3);

						result.add(neighbor_3);
					}

					// boven
					if (i == 0  && j<n-1 && j>0) {
						int[][] neighbor1 = deepCopy(tiles);
						int[][] neighbor2 = deepCopy(tiles);
						int[][] neighbor3 = deepCopy(tiles);

						//neighbor1 vakje naar links bewegen
						neighbor1[i][j] = neighbor1[i][j-1];
						neighbor1[i][j-1] = 0;
						Board neighbor_1 = new Board(neighbor1);

						result.add(neighbor_1);

						//neighbor2 vakje naar rechts bewegen
						neighbor2[i][j] = neighbor2[i][j+1];
						neighbor2[i][j+1] = 0;
						Board neighbor_2 = new Board(neighbor2);

						result.add(neighbor_2);

						//neighbor3 vakje naar onder bewegen
						neighbor3[i][j] = neighbor2[i+1][j];
						neighbor3[i+1][j] = 0;
						Board neighbor_3 = new Board(neighbor3);
						result.add(neighbor_3);
					}

					// onder
					if (i == n-1  && j<n-1 && j>0) {
						int[][] neighbor1 = deepCopy(tiles);
						int[][] neighbor2 = deepCopy(tiles);
						int[][] neighbor3 = deepCopy(tiles);

						//neighbor1 vakje naar links bewegen
						neighbor1[i][j] = neighbor1[i][j-1];
						neighbor1[i][j-1] = 0;
						Board neighbor_1 = new Board(neighbor1);

						result.add(neighbor_1);

						//neighbor2 vakje naar rechts bewegen
						neighbor2[i][j] = neighbor2[i][j+1];
						neighbor2[i][j+1] = 0;
						Board neighbor_2 = new Board(neighbor2);

						result.add(neighbor_2);

						//neighbor3 vakje naar boven bewegen
						neighbor3[i][j] = neighbor2[i-1][j];
						neighbor3[i-1][j] = 0;
						Board neighbor_3 = new Board(neighbor3);

						result.add(neighbor_3);
					}

					// midden
					if (i<n-1 && i>0  && j<n-1 && j>0) {
						int[][] neighbor1 = deepCopy(tiles);
						int[][] neighbor2 = deepCopy(tiles);
						int[][] neighbor3 = deepCopy(tiles);
						int[][] neighbor4 = deepCopy(tiles);

						//neighbor1 vakje naar links bewegen
						neighbor1[i][j] = neighbor1[i][j-1];
						neighbor1[i][j-1] = 0;
						Board neighbor_1 = new Board(neighbor1);

						result.add(neighbor_1);

						//neighbor2 vakje naar rechts bewegen
						neighbor2[i][j] = neighbor2[i][j+1];
						neighbor2[i][j+1] = 0;
						Board neighbor_2 = new Board(neighbor2);

						result.add(neighbor_2);

						//neighbor3 vakje naar boven bewegen
						neighbor3[i][j] = neighbor2[i-1][j];
						neighbor3[i-1][j] = 0;
						Board neighbor_3 = new Board(neighbor3);

						result.add(neighbor_3);

						//neighbor3 vakje naar onder bewegen
						neighbor4[i][j] = neighbor4[i+1][j];
						neighbor4[i+1][j] = 0;
						Board neighbor_4 = new Board(neighbor4);

						result.add(neighbor_4);
					}

					return result;
				}
			}
		}
		return result;
	}
	
	// return a string representation of the board
	public String toString()
	{
		String result = "";
		int n = tiles.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tiles[i][j] != 0)
					result = result + tiles[i][j] + " ";
				else
					result = result + " " + " ";
			}
			result = result + "\n";
		}
		return result;
	}

	// is the initial board solvable? Note that the empty tile must
	// first be moved to its correct position.
	public boolean isSolvable()
	{
		int N = tiles.length;
		int[] row = new int[N * N - 1];
		int x = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0 ; j < N; j++) {
				if(tiles[i][j] != 0) {
					row[x] = tiles[i][j];
					x++;
				}
			}
		}
		int n = row.length;
		int totalInversions = 0;
		for (int i = 0; i < n; i++){
			for (int j = i + 1; j < n; j++) {
				if  (row[i] > row[j])
					totalInversions++;
			}
		}

		if (N == 2)
			return totalInversions % 2 == 0;
		else if (N % 2 == 0)
			return totalInversions % 2 == 0;
		else
			return totalInversions % 2 == 0;
	}
}

