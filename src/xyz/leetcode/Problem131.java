package xyz.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem131 {
    public static void main(String[] args) {
        Problem131 problem131 = new Problem131();
        System.out.println(problem131.partition("aab"));
    }
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        partitionRecursive(s, 0, s.length(), answer);
        return answer;
    }

    public void partitionRecursive(String s, int start, int end, List<List<String>> answer) {
        if (end - start == 1) {
            List<String> list = new ArrayList<>();
            list.add(s.substring(start, end));
            answer.add(list);
            return;
        }
        if (end - start < 1) {
            return;
        }
        partitionRecursive(s, start, end - 1, answer);
        for (List<String> list : answer) {
            list.add(s.substring(end - 1, end));
        }
        int startI = start;
        while (startI < end) {
            if (startI != end - 1 && isPalindrome(s, startI, end)) {
                List<List<String>> tempAnswer = new ArrayList<>();
                partitionRecursive(s, start, startI, tempAnswer);
                if (tempAnswer.size() == 0) {
                    List<String> list = new ArrayList<>();
                    list.add(s.substring(startI, end));
                    tempAnswer.add(list);
                } else {
                    for (List<String> list : tempAnswer) {
                        list.add(s.substring(startI, end));
                    }
                }
                answer.addAll(tempAnswer);
            }
            startI++;
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        if (end - start == 0) {
            return true;
        }
        end = end - 1;
        boolean isPalindrome = true;
        while (start <= end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        return isPalindrome;
    }
}
