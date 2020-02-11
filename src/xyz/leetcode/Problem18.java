package xyz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem18 {
    public static void main(String[] args) {
        Problem18 problem18 = new Problem18();
        System.out.println(problem18.fourSum(new int[]{-5, -4, -3, -2, 1, 3, 3, 5}, -11));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return answer;
        }
        Arrays.sort(nums);
        int length = nums.length;
        int[] newNums = new int[length - 1];
        for (int i = 0; i < length; i++) {
            if (nums[i] > target && nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
//            构造新的nums
            for (int j = i + 1; j < length; j++) {
                newNums[j - i - 1] = nums[j];
            }
//            新的nums是有序的 因此去掉三数之和中排序的部分
//            四数之和化为子问题求解
//            对数据进行循环，并假定nums[i]就在结果中，然后求解对应的三数之和问题
//            如果返回的是一个空集合，说明nums[i]不在结果中，跳过
//            否则将nums[i]添加进返回的三数之和的每一个list中即可
            List<List<Integer>> threeSum = threeSum(newNums, target - nums[i], length - i - 1);
//            当list为空的时候是不会进行迭代的
            for (List<Integer> item : threeSum) {
                List<Integer> temp = new ArrayList<>(item);
                temp.add(nums[i]);
                answer.add(temp);
            }
        }
        return answer;
    }

    public List<List<Integer>> threeSum(int[] nums, int target, int len) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || len < 3) {
            return ans;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > target && nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重 只计算第一个
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == target) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                    L++;
                    R--;
                } else if (sum < target) L++;
                else R--;
            }
        }
        return ans;
    }
}
