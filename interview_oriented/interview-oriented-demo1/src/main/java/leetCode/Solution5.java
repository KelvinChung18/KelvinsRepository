package leetCode;


/**
 * @author kelvinchung
 *
 * 01.05. 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 */
public class Solution5 {

    public static boolean oneEditAway(String first, String second) {
        int num = 0;
        // 字符串顺序一致
        // 先判断字符长度
        if (first.length() == second.length()) {
            // 如果字符长度一致 判断是否只有一个不同 或者完全相同
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    num++;
                }
            }
            return num > 1 ? false : true;
        } else if (Math.abs(first.length() - second.length()) == 1) {
            // 如果字符长度不一致 只差了一位 （删除，添加）
            String longger;
            String shorter;
            if (first.length() > second.length()) {
                longger = first;
                shorter = second;
            }else {
                longger = second;
                shorter = first;
            }
            // teacher
            // techer
            for (int i = 0, j = 0; i < shorter.length(); i++, j++) {
                // 扫长的
                if (longger.charAt(j) != shorter.charAt(i)) {
                    num++;
                    if (longger.charAt(j+1) != shorter.charAt(i)) {
                        return false;
                    }
                }
            }
            return true;
        }
        // 如果字符长度不一致 差了不止一位 直接false
        return false;
    }

    public static void main(String[] args) {
        System.out.println(oneEditAway("teacher","taches"));
    }
}
