/** Names: Esmeralda Amado
 Course: CS2013
 Section: 03 & 04
 Description: This program demonstrates the use of recursion and backtracking
 *            to find all paths in a grid that match a given sequence of symbols.
 *            The grid is initialized with random symbols, and the program searches
 *            for paths that spell out the specified sequence. It makes sure that the ]
 *            cell is only visited once.
 Other comments: N/A
 */

import java.util.LinkedList;

public class SymbolGrid {

	private static char[] SYMBOLS = {'~', '!', '@', '#', '$', '^', '&', '*'};


	// NOTE:
	//   Do not change this method signature.
	//   This method calls another recursive method, but it should
	//   not call itself.

	//nested for loop and top part of recursion
	public static void findAllPaths(Grid grid, char[] sequence) {
		for (int row = 0; row < grid.getSize(); row++) {
			for (int col = 0; col < grid.getSize(); col++) {
					Cell start = new Cell(row, col);
					Path path = new Path();
					findPathsAt(grid, start, path, sequence); //using the findPathsAt() method
			}
		}

		//hint make a for loop, first char in sequence add in path and start
		// finding paths, use helper method

		System.out.println("\n--- finished searching");
	}
	
	//implementing recursive method with backtracking

	//checking all the valid paths
	private static void findPathsAt(Grid grid,
									Cell here,
									Path currentPath,
			                        char[] sequence) {

		//if the path length matches the sequence length, print and return
		if (currentPath.getLength() == sequence.length) {
			System.out.println(currentPath);
			return;
		}

		//checks if the current cell is valid and matches the current character in the sequence
		if (!grid.isOnGrid(here) || currentPath.contains(here)
				                 || grid.getSymbolAt(here)
				                 != sequence[currentPath.getLength()]) {
			return;
		}

		//adds the  cell to the path
		currentPath.add(here, grid.getSymbolAt(here));

		//checks all neighboring cells (up, down, left, right, diagonal)
		Cell[] neighbors = {
				new Cell(here.r - 1, here.c), // up
				new Cell(here.r + 1, here.c), // down
				new Cell(here.r, here.c - 1), // left
				new Cell(here.r, here.c + 1), // right
				new Cell(here.r - 1, here.c - 1), // up-left diagonal
				new Cell(here.r - 1, here.c + 1), // up-right diagonal
				new Cell(here.r + 1, here.c - 1), // down-left diagonal
				new Cell(here.r + 1, here.c + 1)  // down-right diagonal
		};

		//explores each neighbor
		for (Cell neighbor : neighbors) {
			findPathsAt(grid, neighbor, currentPath, sequence);
		}

		//backtracking
		currentPath.removeLast();
		}


		// Remove the current cell from the path (backtrack)

		//hint checking the neighbors, doing the same thing on the next characters
		// until we find characters, checking neighbors that match

		//base case, having to know when to know when we find a valid path, when we are done,
		//the current path is to keep track of the sequence we already found, the sequence is the
		//path we used to find the characters

		//current length as index of current path for the current something for sequence
	}

	public static void main(String[] args) {
		Grid grid = new Grid(7, SYMBOLS);
		grid.display();
		System.out.println();
		char[] seq = randomSymbolSequence(4);
		System.out.print("sequence: ");
		System.out.println(seq);

		System.out.println("\npaths:");
		findAllPaths(grid, seq);

	}

	/* Helper methods below */

	private static char[] randomSymbolSequence(int length) {
		char[] sequence = new char[length];
		for(int i = 0; i < length; i++) {
			sequence[i] = SYMBOLS[(int)(Math.random()*SYMBOLS.length)];
		}
		return sequence;
	}


}

/* Represents a cell on a grid -- just a convenient way of
 * packaging a pair of indices  */
class Cell {
	int r, c;

	Cell(int r, int c) {
		this.r = r;
		this.c = c;
	}

	@Override
	public boolean equals(Object o) {
		Cell cell = (Cell) o;
		return this.r == cell.r && this.c == cell.c;
	}

	@Override
	public String toString() {
		return "(" + r + ", " + c + ")";
	}
}

/* Represents a path of cells on a grid of symbols. */
class Path {
	private LinkedList<Cell> cells;
	private LinkedList<Character> symbols;

	Path() {
		cells = new LinkedList<Cell>();
		symbols = new LinkedList<Character>();
	}

	int getLength() {
		return cells.size();
	}

	void add(Cell location, char symbol) {
		cells.addLast(location);
		symbols.addLast(symbol);
	}

	void removeLast() {
		cells.removeLast();
		symbols.removeLast();
	}

	//big helper
	boolean contains(Cell cell) {
		return cells.contains(cell);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < cells.size(); i++) {
			sb.append(symbols.get(i));
			sb.append(cells.get(i).toString());
			sb.append("  ");
		}

		return sb.toString();
	}

	void display() {
		System.out.println(toString());
	}


}

/* Represents a grid of symbols. */
class Grid {
	private char[][] grid;

	Grid(int size, char[] symbols) {
		grid = initGrid(size, symbols);
	}

	private char[][] initGrid(int size, char[] symbols) {
		char[][] symbolGrid = new char[size][size];

		for(int row = 0; row < size; row++) {
			for(int col = 0; col < size; col++) {
				// picks a random symbol for each cell on the grid
				symbolGrid[row][col] = symbols[(int)(Math.random() * symbols.length)];
			}
		}

		return symbolGrid;
	}

	int getSize() {
		return grid.length;
	}

	char getSymbolAt(Cell location) {
		return getSymbolAt(location.r, location.c);
	}

	char getSymbolAt(int r, int c) {
		return grid[r][c];
	}

	boolean isOutside(Cell location) {
		return isOutside(location.r, location.c);
	}

	boolean isOutside(int r, int c) {
		return 0 > r || r >= grid.length || 0 > c || c >= grid[r].length;
	}

	boolean isOnGrid(Cell location) {
		return isOnGrid(location.r, location.c);
	}

	boolean isOnGrid(int r, int c) {
		return 0 <= r && r < grid.length && 0 <= c && c < grid[r].length;
	}

	void display() {
		// Display column indices
		System.out.print("\n    ");
		for(int i = 0; i < grid.length; i++) {
			System.out.print(i + "  ");
		}
		System.out.println();

		// Display grid
		for(int r = 0; r < grid.length; r++) {
			// Display row index
			System.out.print("  " + r + " ");
			for(int c = 0; c < grid[r].length; c++) {
				System.out.print(grid[r][c] + "  ");
			}
			System.out.println();
		}
	}
}

