package xyz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem11 {
    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int result = 0;

        while (l < r) {
            result = max(result, min(height[l], height[r]) * (r - l));
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }

        return result;
    }

    public static int myMaxArea(int[] height) {
        int heightLength = height.length;
        int[] answer = new int[heightLength];
        int i, j, result;

        for (i = 1; i < heightLength; i++) {
            for (j = 0; j < i; j++) {
                answer[i - j] = max(answer[i - j], area(height[i], height[j], i - j));
            }
        }

        result = 0;
        for (i = 0; i < heightLength; i++) {
            if (answer[i] > result) {
                result = answer[i];
            }
        }
        return result;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    private static int area(int a, int b, int l) {
        if (a > b) a = b;
        return a * l;
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }
}
