package xyz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // ����
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // �����ǰ���ִ���0��������֮��һ������0�����Խ���ѭ��
            if(i > 0 && nums[i] == nums[i-1]) continue; // ȥ��
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // ȥ��
                    while (L<R && nums[R] == nums[R-1]) R--; // ȥ��
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }

    public static List<List<Integer>> myWrongThreeSum(int[] nums) {
        List<List<Integer>> answerList = new ArrayList<>();
        int arrayNum = nums.length;
        int l, r, i;

        Arrays.sort(nums);

        for (i = 1; i < arrayNum - 1; i++) {
            l = i - 1;
            r = i + 1;
            while (l >= 0 && r <= (arrayNum - 1)) {
                if (nums[i] + nums[l] + nums[r] < 0) {
                    r = lowerBound(nums, r, arrayNum - 1, -nums[i] - nums[l]);
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    l = upperBound(nums, 0, l - 1, -nums[i] - nums[r]);
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[l]);
                    temp.add(nums[i]);
                    temp.add(nums[r]);
                    if (!answerList.contains(temp)) {
                        answerList.add(temp);
                    }
                    r++;
                    while (r < arrayNum && nums[r] == nums[r - 1]) {
                        r++;
                    }
                }
            }
        }
        return answerList;
    }

    // �ҵ�һ�����ϸ�����������С�ڵ���target�����ֵ����
    // lΪ������ʼ������rΪ�����������
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

    // �ҵ�һ�����ϸ����������ڴ��ڵ���target����Сֵ����
    // lΪ������ʼ������rΪ�����������
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
