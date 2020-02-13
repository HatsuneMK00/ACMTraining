package xyz.leetcode;

//TODO ʵ�� strStr() ���� ����һ�� haystack �ַ�����һ�� needle �ַ������� haystack �ַ������ҳ� needle �ַ������ֵĵ�һ��λ�� (��0��ʼ)
public class Problem28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        boolean found;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                found = true;
                for (int j = 1;j < needle.length(); j++) {
//                    ע�Ᵽ֤�ַ������ʵ�ʱ��Ҫ��Խ������
                    if ((i + j) >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return i;
                }
            }
        }
        return -1;
    }
}
