package xyz.leetcode;

import java.util.HashSet;

public class Problem128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (Integer integer : set) {
//            ���˼·�ǳ�����
//            ����ֻ����integer - 1����set�е���� ��Ϊ����ڵĻ� ����integer���������л������������Сֵ��ʱ�򱻼���һ�� ��˲���Ҫ����integer��
//            ��������㷨�����Ը��Ӷ�
//            ��Ȼ������ѭ�� �����ڲ�ѭ��ֻ�ڳ�����һ���������е���Сֵ��ʱ��Ż�ִ��
//            ���������������еĳ��ȵĺ����Ҳֻ��n
//            ����ڲ��Ĵ���ִֻ��n��
            if (!set.contains(integer - 1)) {
                int current = integer;
                int tempLength = 0;
                while (set.contains(current)) {
                    current++;
                    tempLength++;
                }
                maxLength = Math.max(maxLength, tempLength);
            }
        }
        return maxLength;
    }
}
