package xyz.tools;

public class MyTools {
//    TODO upperbound����
    // �ҵ�һ�����ϸ�����������С�ڵ���target�����ֵ����
    // ���û���ҵ�����Ҫ���Ԫ�� ��᷵��-1
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
        // return a invalid index if didn't find the element

        if(nums[l]>target){
            return l-1;
        }else{
            return l;
        }
    }

//    TODO lowerbound����
    // �ҵ�һ�����ϸ����������ڴ��ڵ���target����Сֵ����
    // ���û���ҵ�����Ҫ���Ԫ�� ��᷵��nums.length
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

        if(nums[l]<target)
            return l+1;
        else
            return l;
    }
}
