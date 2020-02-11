package xyz.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem13 {
    public static void main(String[] args) {
        Problem13 problem13 = new Problem13();
        System.out.println(problem13.romanToInt("III"));
    }
    static Map<Character, Integer> valMap = new HashMap<>();

    static {
        valMap.put('I', 1);
        valMap.put('V', 5);
        valMap.put('X', 10);
        valMap.put('L', 50);
        valMap.put('C', 100);
        valMap.put('D', 500);
        valMap.put('M', 1000);
    }

    public int romanToInt(String s) {
        int length = s.length();
        int retVal = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'I'){
                if (i < length - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                    retVal = retVal - 1 + valMap.get(s.charAt(i + 1));
                    i++;
                    continue;
                }
            }
            if (s.charAt(i) == 'X'){
                if (i < length - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                    retVal = retVal - 10 + valMap.get(s.charAt(i + 1));
                    i++;
                    continue;
                }
            }
            if (s.charAt(i) == 'C'){
                if (i < length - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                    retVal = retVal - 100 + valMap.get(s.charAt(i + 1));
                    i++;
                    continue;
                }
            }
            retVal += valMap.get(s.charAt(i));
        }
        return retVal;
    }
}
