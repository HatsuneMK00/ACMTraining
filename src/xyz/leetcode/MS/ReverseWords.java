package xyz.leetcode.MS;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("  hello   world!  "));
    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].equals("")) {
                continue;
            }
            sb.append(words[i].trim());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
