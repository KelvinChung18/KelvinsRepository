package leetCode;

/**
 * @author kelvinchung
 *
 * 面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 */
public class Solution {
    public static boolean isUnique(String astr) {
        for (int i = 0; i < astr.length() - 1; i++) {
            for (int j = i; j < astr.length() - 1; j++) {
                // 判断是否相同
                if (astr.charAt(i) == astr.charAt(j + 1)) {
                    // 有相同返回false
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isUnique("kzwunahkiz"));
    }
}
