//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。 
//
// 例如： 
//
// 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-
//tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 172 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;

/**
 * 二叉树的深度
 * @author Administrator
 */
public class IErChaShuDeShenDuLcof{
    public static void main(String[] args) {
        Solution solution = new IErChaShuDeShenDuLcof().new Solution();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
//                TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
//                TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode12 = new TreeNode(12);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

//                treeNode4.left = treeNode8;
        treeNode5.left = treeNode9;
//                treeNode6.left = treeNode10;

        treeNode7.left = treeNode11;
        treeNode7.right = treeNode12;

        int result = solution.maxDepth(treeNode);
        System.out.println(result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /*
      Definition for a binary tree node.
    */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        public int maxDepth(TreeNode root) {
            // Bfs  广度优先
            LinkedList<TreeNode> linkedList = new LinkedList<>();
            if (root ==null) {
                return 0;
            }
            // 记录深度
            int depth = 0;
            linkedList.offer(root);
            // 不为空就开始循环
            while (!linkedList.isEmpty()) {
                depth++;
                int size = linkedList.size();
                for (int i = 0; i < size; i++) {
                    TreeNode pop = linkedList.pop();
                    if (pop.left!=null) {
                        linkedList.offer(pop.left);
                    }
                    if (pop.right!=null) {
                        linkedList.offer(pop.right);
                    }
                }
            }
            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



