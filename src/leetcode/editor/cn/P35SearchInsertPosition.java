//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 示例 4: 
//
// 
//输入: nums = [1,3,5,6], target = 0
//输出: 0
// 
//
// 示例 5: 
//
// 
//输入: nums = [1], target = 0
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为无重复元素的升序排列数组 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 二分查找 👍 1170 👎 0


package leetcode.editor.cn;
/**
 * 搜索插入位置
 * @author Administrator
 */
public class P35SearchInsertPosition{
    public static void main(String[] args) {
        Solution solution = new P35SearchInsertPosition().new Solution();
        int[] nums = {1,3};
        System.out.println(solution.searchInsert(nums,1));

    }
//    nums = [1,3,5,6], target = 0
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums[0]>target) {
                return 0;
            }
            if (nums[nums.length-1]<target) {
                return nums.length;
            }
            // 左角标
            int right = nums.length-1;
            int left = 0;
            int middle = 0;
            while(left<right) {
                middle = (left+right)>>1;
                if (nums[middle]==target) {
                    return middle;
                }
                if (left == middle ||right == middle) {
                    return middle+1;
                }
                if (nums[middle]>target) {

                    right = middle;
                } else if (nums[middle]<target) {
                    left = middle;
                }
            }
            return middle;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



