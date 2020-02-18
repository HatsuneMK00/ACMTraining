package xyz.leetcode;

//TOOL ����һ��δ������������飬�ҳ�����û�г��ֵ���С�������� �㷨��ʱ�临�Ӷ�ӦΪO(n)
public class Problem41 {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        boolean hasOne = false;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                hasOne = true;
                break;
            }
        }
        if (!hasOne) return 1;
//        Ԥ����
//        ��������Чֵ 0�����������1 ȷ��1������ԭ������
        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0) {
                nums[i] = 1;
            }
        }

//        ʹ����������Ϊ�洢��Ϣ��ý�� ���������Ƿ���ֵ���Ϣ ����Ҫ����n+1���ϵ�ֵ
//        ʹ����ֵ��Ϣ��ʱ�򲻹�������
        for (int i = 0; i < length; i++) {
            if (Math.abs(nums[i]) <= length && nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }

//        ���������������Ϣ���൱�ڲ������飩���е���
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }
}
