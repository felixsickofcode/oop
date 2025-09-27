// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     *
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     *
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int rows = grid.length;
        int cols = grid[0].length;
        int minRow = rows, maxRow = -1, minCol = cols, maxCol = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == ch) {
                    if (i < minRow) minRow = i;
                    if (i > maxRow) maxRow = i;
                    if (j < minCol) minCol = j;
                    if (j > maxCol) maxCol = j;
                }
            }
        }
        if (maxRow == -1) return 0;
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     *
     * @return number of + in grid
     */
    public int countPlus() {
        int rows = grid.length;
        int cols = grid[0].length;
        int cnt = 0;

        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                char c = grid[i][j];
                if (c == ' ') continue;

                int up = countDir(i, j, -1, 0, c);
                int down = countDir(i, j, 1, 0, c);
                int left = countDir(i, j, 0, -1, c);
                int right = countDir(i, j, 0, 1, c);

                if (up >= 2 && up == down && up == left && up == right) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private int countDir(int r, int c, int dr, int dc, char ch) {
        int len = 0;
        r += dr;
        c += dc;
        while (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == ch) {
            len++;
            r += dr;
            c += dc;
        }
        return len;
    }

    public static void main(String[] args) {
        char[][] grid1 = {
                {'a', 'b', 'c', 'd'},
                {'a', ' ', 'c', 'b'},
                {'x', 'b', 'c', 'a'}
        };
        CharGrid cg1 = new CharGrid(grid1);
        System.out.println("charArea('a') = " + cg1.charArea('a'));
        System.out.println("charArea('c') = " + cg1.charArea('c'));
        System.out.println("charArea('z') = " + cg1.charArea('z'));

        char[][] grid2 = {
                {' ', ' ', 'p', ' ', ' ', ' ', ' ', 'x', ' '},
                {' ', ' ', 'p', ' ', ' ', ' ', 'x', ' ', ' '},
                {'p', 'p', 'p', 'p', 'p', ' ', 'x', 'x', 'x'},
                {' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
                {' ', ' ', 'p', ' ', 'y', 'y', 'y', ' ', ' '},
                {'z', 'z', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
                {' ', ' ', 'x', 'x', ' ', 'y', ' ', ' ', ' '}
        };
        CharGrid cg2 = new CharGrid(grid2);
        System.out.println("countPlus = " + cg2.countPlus()); // 2
    }
}


