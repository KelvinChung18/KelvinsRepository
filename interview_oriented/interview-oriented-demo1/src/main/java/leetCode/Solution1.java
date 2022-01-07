package leetCode;

import java.util.HashMap;


/**
 * @author kelvinchung
 *
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 */
public class Solution1 {
//    public static boolean CheckPermutation(String s1, String s2) {
//        // 长度不一致 直接false
//        if (s1.length() != s2.length())
//            return false;
//        Map<String, Integer> map = new HashMap<>();
//        Map<String, Integer> map2 = new HashMap<>();
//        for (int i = 0; i < s1.length(); i++) {
//            String s = String.valueOf(s1.charAt(i));
//            String k = String.valueOf(s2.charAt(i));
//            if (!map.containsKey(s)) {
//                map.put(s, 1);
//            }else {
//                int temp = map.get(s);
//                map.put(s, ++temp);
//            }
//
//            if (!map2.containsKey(k)) {
//                map2.put(k, 1);
//            }else {
//                int temp = map2.get(k);
//                map2.put(k, ++temp);
//            }
//            // 我有你没有
//            if (!s2.contains(s)) {
//                return false;
//            }
//        }
//
//        if (!map.equals(map2)) {
//            return false;
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
        System.out.println(CheckPermutation("abb", "abb"));
    }
    /**
     *  大神解答
     */
    public static boolean CheckPermutation(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        // 若 s1, s2 长度不同，则不互为重排
        if (len1 != len2) {
            return false;
        }
        // 初始化哈希表 dic
        HashMap<Character, Integer> dic = new HashMap<>();
        // 统计字符串 s1 各字符数量，遇到 +1
        for (int i = 0; i < len1; i++) {
            // dic.getOrDefault(key, default) 函数：在 key 存在时返回对应 value ，在 key 不存在时默认返回 default 值；
            dic.put(s1.charAt(i) , dic.getOrDefault(s1.charAt(i), 0) + 1);
        }
        // 统计字符串 s2 各字符数量，遇到 -1
        for (int i = 0; i < len2; i++) {
            dic.put(s2.charAt(i) , dic.getOrDefault(s2.charAt(i), 0) - 1);
        }
        // 遍历 s1, s2 中各字符的数量差
        for (int val : dic.values()) {
            // 若 s1, s2 中某字符的数量不一致，则不互为重排
            if (val != 0) {
                return false;
            }
        }
        // 所有字符数量都一致，因此互为重排
        return true;
    }
}

