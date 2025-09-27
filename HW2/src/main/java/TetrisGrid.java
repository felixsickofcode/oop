public class TetrisGrid {
    private boolean[][] grid;

    /**
     * Constructs a new instance with the given grid.
     * Does not make a copy.
     *
     * @param grid
     */
    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }

    /**
     * Does row-clearing on the grid (see handout).
     */
    public void clearRows() {
        int width = grid.length;
        int height = grid[0].length;

        int nextRow = 0;
        for (int y = 0; y < height; y++) {
            boolean full = true;
            for (int x = 0; x < width; x++) {
                if (!grid[x][y]) {
                    full = false;
                    break;
                }
            }
            if (!full) {
                for (int x = 0; x < width; x++) {
                    grid[x][nextRow] = grid[x][y];
                }
                nextRow++;
            }
        }
        for (int y = nextRow; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = false;
            }
        }
    }

    /**
     * Returns the internal 2d grid array.
     *
     * @return 2d grid array
     */
    public boolean[][] getGrid() {
        return grid;
    }

    public static void main(String[] args) {
        boolean[][] grid = {
                {true, true, true, true},
                {true, true, true, true},
                {false, true, true, false},
                {true, false, true, false}
        };

        TetrisGrid tg = new TetrisGrid(grid);
        System.out.println("Before:");
        printGrid(tg.getGrid());

        tg.clearRows();

        System.out.println("After:");
        printGrid(tg.getGrid());
    }

    private static void printGrid(boolean[][] g) {
        int w = g.length;
        int h = g[0].length;
        for (int y = h - 1; y >= 0; y--) {
            for (int x = 0; x < w; x++) {
                System.out.print(g[x][y] ? "1 " : "0 ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
