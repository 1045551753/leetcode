//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
// Related Topics 数组 二分查找 矩阵 👍 557 👎 0


package leetcode.editor.cn;
/**
 * 搜索二维矩阵
 * @author Administrator
 */
public class P74SearchA2dMatrix{
    public static void main(String[] args) {
        Solution solution = new P74SearchA2dMatrix().new Solution();
        int[][] i = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(solution.searchMatrix(i, 10));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;if (m == 0 ) return false;// 行数
            // 从右上角开始查找
            int n = matrix[0].length;if (n == 0) return false;// 列数
            return searchSubMatrix(matrix, target,m-1, n - 1);
        }

        public boolean searchSubMatrix(int[][] matrix, int target, int rowlength, int column) {
            int row = 0;
            while (column>=0 && row<=rowlength) {
                if (matrix[row][column]==target) {
                    return true;
                } else if (matrix[row][column]>target) {
                    column--;
                } else {
                    row++;
                }
            }
            return false;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)


}



