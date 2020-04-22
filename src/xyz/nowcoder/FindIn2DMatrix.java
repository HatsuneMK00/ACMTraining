package xyz.nowcoder;

public class FindIn2DMatrix {
    public boolean Find(int target, int[][] array) {
        int m = array.length;
        if (m == 0) {
            return false;
        }
        int n = array[0].length;
        for (int i = 0; i < m; i++) {
            if (array[i][0] <= target) {
                if (array[i][n - 1] >= target) {
                    int ind = upperBound(array[i], 0, n - 1, target);
                    if (ind != -1 && array[i][ind] == target) {
                        return true;
                    }
                }
            } else {
                return false;
            }
        }
        return false;
    }

    // 找到一个不严格升序数组内小于等于target的最大值索引
    // 如果没有找到符合要求的元素 则会返回-1
    // l为数组起始索引，r为数组结束索引
    private static int upperBound(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (nums[m] <= target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        // return a invalid index if didn't find the element

        if (nums[l] > target) {
            return l - 1;
        } else {
            return l;
        }
    }
}
