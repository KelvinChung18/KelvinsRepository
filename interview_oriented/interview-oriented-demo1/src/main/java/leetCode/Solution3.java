package leetCode;

/**
 * @author kelvinchung
 *
 * 01.04. 回文排列
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 */
public class Solution3 {
    /**
     * 理解：要看每个字母出现的次数，是否都为偶数；奇数只能为一个
     *
     */
//    public static boolean canPermutePalindrome(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char temp = s.charAt(i);
//            map.put(temp, map.getOrDefault(temp, 0) + 1);
//        }
//
//        Iterator<Integer> iterator = map.values().iterator();
//        int oddNumber = 0;
//        while (iterator.hasNext()) {
//            Integer tempVar = iterator.next();
//            if (tempVar % 2 != 0) {
//                oddNumber++;
//            }
//        }
//        if (oddNumber > 1) {
//            return false;
//        }
//        return true;
//    }

//    public boolean canPermutePalindrome(String s) {
//        Set<Character> set = new HashSet<>();
//        for (char ch : s.toCharArray()) {
//            //set的add方法如果返回false，表示已经有了，
//            //我们就把他删除
//            if (!set.add(ch)) {
//                set.remove(ch);
//            }
//        }
//        //最后判断set的长度是否小于等于1，如果等于1说明
//        //只有一个字符的个数是奇数，其他的都是偶数。如果
//        //等于0说明每个字符都是偶数，否则不可能构成回文字符串
//        return set.size() <= 1;
//    }

    /**
     * 大哥写法
     * @param s
     * @return
     */
    public static boolean canPermutePalindrome(String s) {
        int[] map = new int[128];
        int count = 0;
        for (char ch : s.toCharArray()) {
            if ((map[ch]++ & 1) == 1) {
                // 奇数减1
                count--;
            } else {
                // 偶数加1
                count++;
            }
        }
        //
        return count <= 1;
    }

    public static void main(String[] args) {
        // a 1 count == 1 偶数加1
        // b 1 count == 2 偶数加1
        // b 2 count == 1 奇数减1
        // c 1 count == 2
        // b 3
        // b 4
        // a 2
        // -- 最后结果 --
        // a 2
        // b 4
        // c 1
        System.out.println(canPermutePalindrome("abbcbba"));
    }
}
