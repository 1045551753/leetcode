//给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定不同的子数组为好子数组。 
//
// （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。） 
//
// 返回 A 中好子数组的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：A = [1,2,1,2,3], K = 2
//输出：7
//解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
// 
//
// 示例 2： 
//
// 
//输入：A = [1,2,1,3,4], K = 3
//输出：3
//解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20000 
// 1 <= A[i] <= A.length 
// 1 <= K <= A.length 
// 
// Related Topics 数组 哈希表 计数 滑动窗口 👍 329 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * K 个不同整数的子数组
 * @author Administrator
 */
public class P992SubarraysWithKDifferentIntegers{
    public static void main(String[] args) {
        Solution solution = new P992SubarraysWithKDifferentIntegers().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraysWithKDistinct(int[] nums, int k) {
            //在此处写入代码
            // 思路 就是双指针加hash表
            int left = 0;
            int result = 0;
            int right = 0;
            Map<Integer,Integer> map = new HashMap<>();
            while(left<=(nums.length-k)) {
                map.clear();
                // 记录数量
                int size = 0;
                right =left;
                while(right<nums.length) {
                    if (!map.containsKey(nums[right])) {
                        size++;
                    }
                    if (size == k) {
                        result++;
                    } else if (size>k) {
                        break;
                    }
                    map.put(nums[right],right++);
                }
                left++;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


