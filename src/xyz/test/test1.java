package xyz.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test1 {
    private static int upperBound(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (nums[m] <= target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        /* customized code for problem 15 */
        // return a invalid index if didn't find the element

        if(nums[l]>target){
            return l-1;
        }else{
            return l;
        }
    }

    private static int lowerBound(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        /* customized code for problem 15 */
        // return a invalid index if didn't find the element

        if(nums[l]<target)
            return l+1;
        else
            return l;
    }
}
