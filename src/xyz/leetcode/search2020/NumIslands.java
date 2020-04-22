package xyz.leetcode.search2020;

import java.util.ArrayList;
import java.util.List;

public class NumIslands {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        List<Integer> pos = findIsland(grid);
        while (pos.size() > 0) {
            islandCount++;
            markIsland(grid, pos.get(0), pos.get(1));
            pos = findIsland(grid);
        }
        return islandCount;
    }

    public void markIsland(char[][] grid, int m, int n) {
        if (grid[m][n] == '1') {
            grid[m][n] = '0';
            if (m - 1 >= 0) markIsland(grid, m - 1, n);
            if (n - 1 >= 0) markIsland(grid, m, n - 1);
            if (m + 1 < grid.length) markIsland(grid, m + 1, n);
            if (n + 1 < grid[0].length) markIsland(grid, m, n + 1);
        }
    }

    public List<Integer> findIsland(char[][] grid) {
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    pos.add(i);
                    pos.add(j);
                    return pos;
                }
            }
        }
        return pos;
    }
}
