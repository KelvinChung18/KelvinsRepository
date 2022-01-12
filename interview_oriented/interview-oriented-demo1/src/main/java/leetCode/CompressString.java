package leetCode;

/**
 * @author kelvinchung
 * <p>
 * 01.06. 字符串压缩
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 */
public class CompressString {
    public static String compressString(String S) {
        if (S.length() != 0) {
            StringBuilder result = new StringBuilder();
            // 上一次是哪个字符
            char preChar = S.charAt(0);
            // 出现了几次
            int num = 0;
            for (int i = 0; i < S.length(); i++) {
                // 如果跟上一个相同 就加一
                if (preChar == S.charAt(i)) {
                    num++;
                }
                if (preChar != S.charAt(i)) {
                    // 如果当前的 跟上一个不相同 则统计上一个字母的总数
                    result.append(String.valueOf(preChar) + num);
                    num = 1;
                }
                // 最后一个
                if (i == S.length() - 1) {
                    if (num == 1) {
                        result.append(String.valueOf(S.charAt(i)) + num);
                    }else {
                        result.append(String.valueOf(preChar) + num);
                    }
                }
                preChar = S.charAt(i);
            }
            // 判断有没有变短
            if (result.toString().length() >= S.length()) {
                return S;
            }
            return result.toString();
        }
        return "";
    }
//    public String compressString(String S) {
//        if (S.length() == 0) { // 空串处理
//            return S;
//        }
//        StringBuffer ans = new StringBuffer();
//        int cnt = 1;
//        char ch = S.charAt(0);
//        for (int i = 1; i < S.length(); ++i) {
//            if (ch == S.charAt(i)) {
//                cnt++;
//            } else {
//                ans.append(ch);
//                ans.append(cnt);
//                ch = S.charAt(i);
//                cnt = 1;
//            }
//        }
//        ans.append(ch);
//        ans.append(cnt);
//        return ans.length() >= S.length() ? S : ans.toString();
//    }
//}
    public static void main(String[] args) {
        System.out.println(compressString("acccccad"));
    }
}
