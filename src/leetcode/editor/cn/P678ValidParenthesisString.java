//给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则： 
//
// 
// 任何左括号 ( 必须有相应的右括号 )。 
// 任何右括号 ) 必须有相应的左括号 ( 。 
// 左括号 ( 必须在对应的右括号之前 )。 
// * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。 
// 一个空字符串也被视为有效字符串。 
// 
//
// 示例 1: 
//
// 
//输入: "()"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "(*)"
//输出: True
// 
//
// 示例 3: 
//
// 
//输入: "(*))"
//输出: True
// 
//
// 注意: 
//
// 
// 字符串大小将在 [1，100] 范围内。 
// 
// Related Topics 栈 贪心 字符串 动态规划 👍 436 👎 0


package leetcode.editor.cn;
/**
 * 有效的括号字符串
 * @author Administrator
 */
public class P678ValidParenthesisString{
    public static void main(String[] args) {
        Solution solution = new P678ValidParenthesisString().new Solution();
        boolean b = solution.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())");
        System.out.println(b);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //更优解法 非递归模式
        public boolean checkValidString(String s) {
            //字符串 和 反转后的字符串都能满足弱校验规则
            StringBuilder stringBuilder = new StringBuilder(s);
            return helper(stringBuilder.toString(),true) && helper(stringBuilder.reverse().toString(),false);
        }

        //弱校验规则，验证s中左右括号数量是否一致，不一致就用*顶替，会导致将不合法字符串识别为正确的情况，所以还需要再反转后再验证一次
        private boolean helper(String s, boolean flag) {
            char c = flag==true?'(':')';
            int xin=0;
            int count =0;
            for (char c1 : s.toCharArray()) {
                if (c1==c) {
                    count++;
                } else if (c1=='*') {
                    xin++;
                } else {
                    if (count>0) {
                        count--;
                    } else if (xin>0) {
                        xin--;
                    } else {
                        return false;
                    }
                }
            }
            return xin>=count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



