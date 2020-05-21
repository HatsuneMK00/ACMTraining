package xyz.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintListFromTailToHead {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode current = listNode;
        List<Integer> answer = new ArrayList<>();
        while (current != null) {
            answer.add(current.val);
            current = current.next;
        }
        answer = reverse(answer);
        return (ArrayList<Integer>) answer;
    }

    public List<Integer> reverse(List<Integer> nums) {
        int size = nums.size();
        List<Integer> reverseNums = new ArrayList<>();
        for (int i = size - 1; i >= 0; i--) {
            reverseNums.add(nums.get(i));
        }
        return reverseNums;
    }
}

