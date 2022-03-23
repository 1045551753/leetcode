//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 644 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 * @author Administrator
 */
public class P199BinaryTreeRightSideView{
    public static void main(String[] args) {
        Solution solution = new P199BinaryTreeRightSideView().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root==null) {
                return list;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode pop = queue.poll();
                    if (pop.left!=null) {
                        queue.offer(pop.left);
                    }
                    if (pop.right!=null) {
                        queue.offer(pop.right);
                    }

                    if (i==size-1) {
                        list.add(pop.val);
                    }
                }
            }
            return list;
//            List<Integer> res = new ArrayList<>();
//    if (root == null) {
//      return res;
//    }
//    Queue<TreeNode> c = new LinkedList<>();
//    queue.offer(root);
//    while (!queue.isEmpty()) {
//      int size = queue.size();
//      for (int i = 0; i < size; i++) {
//        TreeNode node = queue.poll();
//        if (node.left != null) {
//          queue.offer(node.left);
//        }
//        if (node.right != null) {
//          queue.offer(node.right);
//        }
//        if (i == size - 1) {  //将当前层的最后一个节点放入结果列表
//          res.add(node.val);
//        }
//      }
//    }
//    return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


