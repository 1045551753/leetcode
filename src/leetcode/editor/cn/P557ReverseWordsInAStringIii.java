//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 双指针 字符串 👍 369 👎 0


package leetcode.editor.cn;

/**
 * 反转字符串中的单词 III
 * @author Administrator
 */
public class P557ReverseWordsInAStringIii{
    public static void main(String[] args) {
        Solution solution = new P557ReverseWordsInAStringIii().new Solution();
        solution.reverseWords("Let's take LeetCode contest");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            if (s==null || s.length()==0) {
                return "";
            }
            int right =0;
            int left = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] ==' ') {
                    // 开始翻转
                    re(chars,right-1,left);
                    left = right+1;
                } else  if (i == chars.length-1) {
                    re(chars,right,left);
                }
                right++;
            }
            return new String(chars);
        }

        /**
         * 交换
         * @param chars
         * @param right
         * @param left
         */
        public void re(char[] chars, int right, int left ) {
            // 原地交换
            while(left<right) {
                char aChar = chars[right];
                chars[right] = chars[left];
                chars[left]=aChar;
                right--;
                left++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



