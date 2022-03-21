//请完成一个函数，输入一个二叉树，该函数输出它的镜像。 
//
// 例如输入： 
//
// 4 
// / \ 
// 2 7 
// / \ / \ 
//1 3 6 9 
//镜像输出： 
//
// 4 
// / \ 
// 7 2 
// / \ / \ 
//9 6 3 1 
//
// 
//
// 示例 1： 
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 227 👎 0


package leetcode.editor.cn;

/**
 *
 */
public class ErChaShuDeJingXiangLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeJingXiangLcof().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    //Definition for a binary tree node.

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            // 递归停止条件
            if (root==null) {
                return null;
            }
            // 函数主功能
            // 记录左边的节点
            TreeNode left = root.getLeft();
            // 递归将右边换到左边
            root.left = mirrorTree(root.getRight());
            // 递归将左边换到右边
            root.right = mirrorTree(left);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



