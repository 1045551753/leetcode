//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 2760 👎 0


package leetcode.editor.cn;

import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 * @author Administrator
 */
public class P20ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        System.out.println(solution.isValid("([)]"));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final Map<Character, Character> map = Map.of('[',']','{','}','(',')');
        public boolean isValid(String s) {
            if (s==null ||s.length()==0 ) {
                return false;
            }
            // 用栈
            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                // 如果是左括号需要入栈
                if (map.containsKey(aChar)) {
                    stack.push(aChar);
                } else {
                    // 就是右符号  根据规则 栈顶出的第一个应该是当前符号的左符号 再根据左符号获取右符号
                    if (stack.isEmpty() || map.get(stack.pop())!=aChar) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



