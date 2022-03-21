//在一排多米诺骨牌中，A[i] 和 B[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 
//该平铺的每一半上都有一个数字。） 
//
// 我们可以旋转第 i 张多米诺，使得 A[i] 和 B[i] 的值交换。 
//
// 返回能使 A 中所有值或者 B 中所有值都相同的最小旋转次数。 
//
// 如果无法做到，返回 -1. 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
//输出：2
//解释：
//图一表示：在我们旋转之前， A 和 B 给出的多米诺牌。
//如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2，如图二所示。
// 
//
// 示例 2： 
//
// 输入：A = [3,5,1,2,3], B = [3,6,3,3,4]
//输出：-1
//解释：
//在这种情况下，不可能旋转多米诺牌使一行的值相等。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A[i], B[i] <= 6 
// 2 <= A.length == B.length <= 20000 
// 
// Related Topics 贪心 数组 👍 90 👎 0


package leetcode.editor.cn;
/**
 * 行相等的最少多米诺旋转
 * @author Administrator
 */
public class P1007MinimumDominoRotationsForEqualRow{
    public static void main(String[] args) {
        Solution solution = new P1007MinimumDominoRotationsForEqualRow().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDominoRotations(int[] tops, int[] bottoms) {
            // 先把所有的数转换成tops[0]位置上的值
            int n = tops.length;
            int num = check(tops[0],tops,bottoms,n);
            if (tops[0]==bottoms[0] || num!=-1) {
                return num;
            } else {
                return check(bottoms[0],tops,bottoms,n);
            }
        }

        /**
         * 旋转
         * @param top
         * @param tops
         * @param bottoms
         * @param n
         * @return
         */
        private int check(int top, int[] tops, int[] bottoms, int n) {
            int rotationA = 0,rotationB=0;
            for (int i = 0; i < n; i++) {
                if (tops[i]!=top && bottoms[i]!=top) {
                    return -1;
                } else if (tops[i]!=top) {
                    rotationA++;
                } else if (bottoms[i]!=top)
                    rotationB++;
            }
            return Math.min(rotationA,rotationB);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}



