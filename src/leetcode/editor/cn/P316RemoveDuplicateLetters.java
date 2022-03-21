//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-
//distinct-characters 相同 
// Related Topics 栈 贪心 字符串 单调栈 👍 679 👎 0


package leetcode.editor.cn;

/**
 * 去除重复字母
 * @author Administrator
 */
public class P316RemoveDuplicateLetters{
    public static void main(String[] args) {
        Solution solution = new P316RemoveDuplicateLetters().new Solution();
        String result =solution.removeDuplicateLetters("cbacdcbc");
        System.out.println(result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            // 获取到长度
            int length = s.length();
            // 统计每个字母最后出现角标
            int[] indexNum = new int[26];
            // 存放是否存在过在数组中
            boolean[] booleans = new boolean[26];
            // 存放结果
            char[] chars = new char[26];
            // 记录当前角标位置
            int index=0;
            for (int i = 0; i < length; i++) {
                indexNum[s.charAt(i)-'a']=i;
            }
            for (int i = 0; i <length ; i++) {
                // 没有出现过  就可以放进去判断
                if (!booleans[s.charAt(i)-'a']) {
                    // 角标不为0 当前元素小于栈顶元素  栈顶元素不是最后一次出现
                    while(index!=0 && s.charAt(i)<chars[index-1] && i<indexNum[chars[index-1]-'a']) {
                        index--;
                        booleans[chars[index]-'a']=false;
                    }
                    chars[index]=s.charAt(i);
                    booleans[s.charAt(i)-'a']=true;
                    index++;
                }
            }
            return String.valueOf(chars).trim();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



