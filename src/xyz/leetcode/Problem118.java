package xyz.leetcode;

import java.util.ArrayList;
import java.util.List;

//TOOL Éú³ÉÑî»ÔÈý½Ç
public class Problem118 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        nums.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int a = (j == 0 ? 0 : nums.get(i - 1).get(j - 1));
                int b = (j == i ? 0 : nums.get(i - 1).get(j));
                row.add(a + b);
            }
            nums.add(row);
        }
        return nums;
    }
}
