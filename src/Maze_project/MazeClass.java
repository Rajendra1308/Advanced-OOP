package Maze_project;

public class MazeClass {
    Maze dogMaze;

    /**
     * This method sets up the maze using the given input argument
     *
     * @param maze is a maze that is used to construct the dogMaze
     */
    public void setup(String[][] maze) {

        dogMaze = new Maze(maze); // creating a maze

    }

    /**
     * This method returns true if the number of gates in dogMaze >= 2.
     *
     * @return it returns true, if enough gate exists (at least 2), otherwise false.
     */
    public boolean enoughGate() {
        if (findGateTop(dogMaze, 0, 0) + findGateLeft(dogMaze, 0, 0)
                + findGateRight(dogMaze, 0, dogMaze.getMaze()[0].length - 1)
                + findGateBottom(dogMaze, dogMaze.getMaze().length - 1, 0) >= 2) {
            return true;
        }
        return false;
    }

    /**
     * @param dogMaze
     * @param row
     * @param col     This Method traverses through left side of the maze to look
     *                for gates.
     * @return it returns an integer count of the number of gates found on the left
     *         side.
     */
    public int findGateLeft(Maze dogMaze, int row, int col) {
        if (row == dogMaze.getMaze().length) {
            return 0;
        }
        // checking left
        if (dogMaze.getMaze()[row][col].charAt(1) == '0') {
            return 1 + findGateLeft(dogMaze, row + 1, col);

        }
        return findGateLeft(dogMaze, row + 1, col);
    }

    /**
     * @param dogMaze
     * @param row
     * @param col     This Method traverses through Top side of the maze to look for
     *                gates.
     * @return it returns an integer count of the number of gates found on the Top
     *         side.
     */
    public int findGateTop(Maze dogMaze, int row, int col) {
        if (col == dogMaze.getMaze()[row].length) {
            return 0;
        }
        if (dogMaze.getMaze()[row][col].charAt(0) == '0') {
            return 1 + findGateTop(dogMaze, row, col + 1);

        }
        return findGateTop(dogMaze, row, col + 1);

    }

    /**
     * @param dogMaze
     * @param row
     * @param col     This Method traverses through Right side of the maze to look
     *                for gates.
     * @return it returns an integer count of the number of gates found on the Right
     *         side.
     */
    public int findGateRight(Maze dogMaze, int row, int col) {
        if (row == dogMaze.getMaze().length) {
            return 0;
        }
        if (dogMaze.getMaze()[row][col].charAt(3) == '0') {
            return 1 + findGateRight(dogMaze, row + 1, col);
        }
        return findGateRight(dogMaze, row + 1, col);
    }

    /**
     * @param dogMaze
     * @param row
     * @param col     This Method traverses through Bottom side of the maze to look
     *                for gates.
     * @return it returns an integer count of the number of gates found on the
     *         Bottom side.
     */
    public int findGateBottom(Maze dogMaze, int row, int col) {
        if (col == dogMaze.getMaze()[0].length) {
            return 0;
        }
        if (dogMaze.getMaze()[row][col].charAt(2) == '0') {
            return 1 + findGateBottom(dogMaze, row, col + 1);
        }
        return findGateBottom(dogMaze, row, col + 1);
    }

    /**
     * This method finds a path from the entrance gate to the exit gate.
     *
     * @param row    is the index of the row, where the entrance is.
     * @param column is the index of the column, where the entrance is.
     * @return it returns a string that contains the path from the start to the end.
     *         The return value should have a pattern like this (i,j)(k,l),... The
     *         first pair of the output must show the entrance given as the input
     *         parameter (i.e. (row,column) No whitespace is allowed in the output.
     */
    public String findPath(int row, int column) {
        if (inBounds(row, column)) {

            // Right
            if (traverseRight(dogMaze, row, column)) {
                dogMaze.getMazeCopy()[row][column] = "*";

                return "(" + row + ", " + column + ")" + findPath(row, column + 1);
            } // Down
            if (traverseDown(dogMaze, row, column)) {
                dogMaze.getMazeCopy()[row][column] = "*";
                return "(" + row + ", " + column + ")" + findPath(row + 1, column);
            }
            // Up
            if (traverseUp(dogMaze, row, column)) {
                dogMaze.getMazeCopy()[row][column] = "*";
                return "(" + row + " ," + column + ")" + findPath(row - 1, column);
            }
            // Left
            if (traverseLeft(dogMaze, row, column)) {
                dogMaze.getMazeCopy()[row][column] = "*";
                return "(" + row + " ," + column + ")" + findPath(row, column - 1);
            }
        }
        return "";

    }

    /**
     * This Method checks if the path covered is a new cell in the maze and marks it
     * with *.
     *
     * @param row    is the index of the row being checked
     * @param column is the index of the column being checked
     * @return true or false based on the checks
     */
    private boolean cellTraversed(int row, int column) {
        if (dogMaze.getMazeCopy()[row][column] == "*") {
            return true;
        }
        return false;
    }

    /**
     * Method for checking if the index of row and col are in bounds This method
     * checks if the indexes of the row and column are in bounds
     *
     * @param row    the row number of the maze
     * @param column the column number of the maze
     * @return return true if the index is in bounds otherwise returns false.
     */
    private boolean inBounds(int row, int column) {
        if (row >= 0 && row < dogMaze.getMaze().length && column >= 0 && column < dogMaze.getMaze()[0].length) {
            return true;
        }
        return false;
    }

    /**
     * This Method checks for the path and traverses on the right-hand side
     *
     * @param dogMaze
     * @param row     the row number of the maze
     * @param col     the column number of the maze
     * @return returns true if there is a possibility for traversing right otherwise
     *         returns false
     */
    private boolean traverseRight(Maze dogMaze, int row, int col) {
        if (inBounds(row, col)) {
            if ((!cellTraversed(row, col)) && dogMaze.getMaze()[row][col].charAt(3) == '0') {
                return true;
            }
        }
        return false;
    }

    /**
     * This Method checks for the path and traverses on the left-hand side
     *
     * @param dogMaze
     * @param row     the row number of the maze
     * @param col     the column number of the maze
     * @return returns true if there is a possibility for traversing left otherwise
     *         returns false
     */

    private boolean traverseLeft(Maze dogMaze, int row, int col) {
        if (inBounds(row, col)) {
            if ((!cellTraversed(row, col)) && dogMaze.getMaze()[row][col].charAt(1) == '0') {
                return true;
            }
        }
        return false;
    }

    /**
     * This Method checks for the path and traverses on the bottom side
     *
     * @param dogMaze
     * @param row     the row number of the maze
     * @param col     the column number of the maze
     * @return returns true if there is a possibility for traversing down otherwise
     *         returns false
     */

    private boolean traverseDown(Maze dogMaze, int row, int col) {
        if (inBounds(row, col)) {
            if ((!cellTraversed(row, col)) && dogMaze.getMaze()[row][col].charAt(2) == '0') {
                return true;
            }
        }
        return false;
    }

    /**
     * This Method checks for the path and traverses on the up
     *
     * @param dogMaze
     * @param row     the row number of the maze
     * @param col     the column number of the maze
     * @return returns true if there is a possibility for traversing up otherwise
     *         returns false
     */
    private boolean traverseUp(Maze dogMaze, int row, int col) {
        if (inBounds(row, col)) {
            if ((!cellTraversed(row, col)) && dogMaze.getMaze()[row][col].charAt(0) == '0') {
                return true;
            }
        }
        return false;
    }

}

/**
 * This class defines a <code> maze </code> using a 2D array. To complete the
 * code, you should not change the method signatures (header).
 */

class Maze {
    private String[][] maze;

    /**
     * This constructor makes the maze.
     *
     * @param maze is a 2D array that contains information on how each cell of the
     *             array looks like.
     */
    public Maze(String[][] maze) {
        this.maze = new String[maze.length][maze[0].length]; // 5x6 maze
        for (int i = 0; i < maze.length; i++) { // i=rows
            for (int j = 0; j < maze[0].length; j++) {// j=columns
                this.maze[i][j] = maze[i][j];
            }
        }
    }

    /**
     * This accessor (getter) method returns a 2D array that represents the maze
     *
     * @return it returns a reference to the maze
     */
    public String[][] getMaze() {
        String[][] cloneMaze = new String[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) { // i=rows
            for (int j = 0; j < maze[0].length; j++) { // j=columns
                cloneMaze[i][j] = this.maze[i][j];
            }
        }
        return cloneMaze;
    }

    /*
     * This is a constructor that returns a reference to the dogmaze so that the
     * same maze can be marked with * if the cells are traversed As,if everytime a
     * new maze object is created the program would not be able to determine the
     * previous marks.
     */
    public String[][] getMazeCopy() {
        return this.maze = maze;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < maze.length; i++) { // i=rows
            s.append('[');
            for (int j = 0; j < maze[0].length; j++) { // j=columns
                if (j == maze[0].length - 1) {
                    s.append(this.maze[i][j]);
                } else {
                    s.append(this.maze[i][j]).append(" ");
                }
//
            }
            String b = "]";
            s.append(b).append("\n");
        }
        return String.valueOf(s);

    }
} // end of class Maze
