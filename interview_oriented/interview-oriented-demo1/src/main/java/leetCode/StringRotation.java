package leetCode;

/**
 * @author kelvinchung
 *
 * 01.09. 字符串轮转
 *
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 */
public class StringRotation {
    public static boolean isFlipedString(String s1, String s2) {
        if (!s1.equals("") && !s2.equals("")) {
            // s1旋转成为s2
            // erbottlewat -> waterbottle
            // erbottlewaterbottlewat
            String temp = s1 + s1;
            return temp.contains(s2);
        }
        if (s1.equals("") && s2.equals("")) {
            return true;
        }
        return false;
    }

//    大神解答
//    public boolean isFlipedString(String s1, String s2) {
//        return s1.length() == s2.length() && (s2 + s2).contains(s1);
//    }


    public static void main(String[] args) {
        System.out.println(isFlipedString("erbottlewat", "waterbottle"));
    }
}
