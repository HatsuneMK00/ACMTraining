package xyz.nowcoder;

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        int ind = str.indexOf(" ");
        while (ind != -1) {
            str.replace(ind, ind + 1, "%20");
            ind = str.indexOf(" ");
        }
        return str.toString();
    }
}
