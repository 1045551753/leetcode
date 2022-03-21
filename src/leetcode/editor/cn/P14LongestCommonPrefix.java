//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 1858 👎 0


package leetcode.editor.cn;
/**
 * 最长公共前缀
 * @author Administrator
 */
public class P14LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        String[] strs = {"df","dfsf"};
        System.out.println("数据:"+solution.longestCommonPrefix(strs));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    // 思路先找出最短的字符串 然后不符合就缩短
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs==null || strs.length==0) {
                return "";
            }
            String min = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while(!strs[i].startsWith(min) && min.length()>=0) {
                    min = min.substring(0,min.length()-1);
                }
                if (min.equals("")) {
                    return "";
                }
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



