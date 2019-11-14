package xyz.vjudge.contest341484;

import java.util.Scanner;

    public class ProblemB {
//        做题的时候要注意答案可能会超过int的范围
//        这题答案就超过了int
//        mergesort的逻辑是正确的 参数全部使用索引挺方便的
        public static long reversePairCount = 0;

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n, k;
            int[] nums = new int[100001];
            while (in.hasNext()) {
                n = in.nextInt();
                k = in.nextInt();
                for (int i = 0; i < n; i++) {
                    nums[i] = in.nextInt();
                }

                mergeSort(nums, 0, n - 1);
                System.out.println(Math.max((reversePairCount - k), 0));
                reversePairCount = 0;
            }
        }

        public static void merge(int[] nums, int start, int end, int middle) {
            int i, j, k;
            i = start;
            j = middle + 1;
            k = 0;
            int[] temp = new int[end - start + 1];
            while (i <= middle && j <= end) {
                if (nums[i] <= nums[j]) {
                    temp[k++] = nums[i++];
                } else if (nums[i] > nums[j]) {
                    temp[k++] = nums[j++];
                    reversePairCount += middle - i + 1;
                }
            }
            while (i <= middle) {
                temp[k++] = nums[i++];
            }
            while (j <= end) {
                temp[k++] = nums[j++];
            }
            for (int l = 0; l < k; l++) {
                nums[start + l] = temp[l];
            }
        }

        public static void mergeSort(int[] nums, int start, int end) {
            int middle = (start + end) / 2;
            if (start < end) {
                mergeSort(nums, start, middle);
                mergeSort(nums, middle + 1, end);
                merge(nums, start, end, middle);
            }
        }

}
