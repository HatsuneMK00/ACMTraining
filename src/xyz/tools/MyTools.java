package xyz.tools;

public class MyTools {
//    TODO upperbound函数
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

        if(nums[l]>target){
            return l-1;
        }else{
            return l;
        }
    }

//    TODO lowerbound函数
    // 找到一个不严格升序数组内大于等于target的最小值索引
    // 如果没有找到符合要求的元素 则会返回nums.length
    // l为数组起始索引，r为数组结束索引
    private static int lowerBound(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        if(nums[l]<target)
            return l+1;
        else
            return l;
    }
}
