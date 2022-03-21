//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
//
// 你可以返回满足此条件的任何数组作为答案。
//
//
//
// 示例：
//
// 输入：[3,1,2,4]
//输出：[2,4,3,1]
//输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 5000
// 0 <= A[i] <= 5000
//
// Related Topics 数组 双指针 排序 👍 228 👎 0


package leetcode.editor.cn;
/**
 * 按奇偶排序数组
 * @author Administrator
 */
public class P905SortArrayByParity{
    public static void main(String[] args) {
        Solution solution = new P905SortArrayByParity().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int start = 0;
            int end = nums.length-1;
            while (start<end) {
                // 偶数
                if (nums[start]%2==0) {
                    start++;
                } else {
                    // 奇数 等待偶数来替换
                    // 从后面找偶数
                    while (nums[end]%2!=0 && start<end) {
                        end--;
                    }
                    // 找到偶数开始替换
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                }
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



