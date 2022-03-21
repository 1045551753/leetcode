//不使用任何库函数，设计一个跳表。 
//
// 跳表是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想
//与链表相似。 
//
// 例如，一个跳表包含 [30, 40, 50, 60, 70, 90]，然后增加 80、45 到跳表中，以下图的方式操作： 
//
// 
//Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons 
//
// 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(
//n))，空间复杂度是 O(n)。 
//
// 在本题中，你的设计应该要包含这些函数： 
//
// 
// bool search(int target) : 返回target是否存在于跳表中。 
// void add(int num): 插入一个元素到跳表。 
// bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。 
//
// 
//
// 了解更多 : https://en.wikipedia.org/wiki/Skip_list 
//
// 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。 
//
// 样例: 
//
// Skiplist skiplist = new Skiplist();
//
//skiplist.add(1);
//skiplist.add(2);
//skiplist.add(3);
//skiplist.search(0);   // 返回 false
//skiplist.add(4);
//skiplist.search(1);   // 返回 true
//skiplist.erase(0);    // 返回 false，0 不在跳表中
//skiplist.erase(1);    // 返回 true
//skiplist.search(1);   // 返回 false，1 已被擦除
// 
//
// 约束条件: 
//
// 
// 0 <= num, target <= 20000 
// 最多调用 50000 次 search, add, 以及 erase操作。 
// 
// Related Topics 设计 链表 👍 92 👎 0


package leetcode.editor.cn;

import java.util.Random;

/**
 * 设计跳表
 * @author Administrator
 */
public class P1206DesignSkiplist{
    public static void main(String[] args) {
//        Solution solution = new P1206DesignSkiplist().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Skiplist {
        /**
         * 链表头节点的值
         */
        final int HEAD_VALUE = -1;
        final Node HEAD = new Node(HEAD_VALUE);
        /**
         * 最左上角的头节点，所有操作的开始位置
         */
        Node head;
        /**
         * 当前层级，即 head 节点所在的最高层数
         */
        int levels;

        /**
         * 跳表长度，即原链表节点个数
         */
        int length;

        class Node {
            int val;
            Node right, down;
            Node(int val) {
                this(val, null, null);
            }
            Node(int val, Node right, Node down) {
                this.val = val;
                this.right = right;
                this.down = down;
            }
        }

        public Skiplist() {
            head = HEAD;
            levels = 1;
        }

        /**
         * 新增  跟查询差不多只是会存在要不要建立索引 以及在源数据链上插入数据  不能用现成的数据结构
         * @param num
         */
        public void add(int num) {
            // 拿到头节点
            Node node = head;
            Node[] nodes = new Node[levels];
            int i=0;
            // 先同一层查询 查询不到再向下查询下一层
            while (node!=null) {
                // 同一层的查询逻辑是 如果查询到下一个节点不为null 并且是小于需要查询的值 则需要继续向右查找 直到上面条件有任意不满足
                while (node.right!=null && node.right.val<num) {
                    node = node.right;
                }
                nodes[i++]=node;
                node = node.down;
            }
            node = nodes[--i];
            // 新建新node对象 并将他的左节点设置成node的左节点
            Node newNode = new Node(num,node.right,null);
            // 连接当前节点 完成插入
            node.right = newNode;
            length++;
            // 根据抛硬币决定是否需要加索引
            // i 的值代表索引层数，不包含原链表
            addIndicesByCoinFlip(newNode, nodes, i);
        }

        /**
         * 抛硬币的方式决定是否给新节点建立索引。
         * 索引层级可能超出,现有跳表的层数，再抛一次决定是否生成索引。
         * 1.抛硬币，在现有跳表层数范围内建立索引
         * 2.抛硬币，决定是否建立一层超出跳表层数的索引层
         *
         * @param target 新节点
         * @param nodes 可能在这些节点后添加新索引节点
         * @param indices 当前索引层数
         */
        private void addIndicesByCoinFlip(Node target, Node[] nodes, int indices) {
            // 作为下节点
            Node downNode = target;
            Random random = new Random();
            int coins = random.nextInt(2); // 0 or 1, 50% 概率
            // 1.抛硬币，在现有跳表层数范围内建立索引
            while (coins == 1 && levels < (length >> 6)) {
                if (indices > 0) {
                    Node prev = nodes[--indices]; // 数组的倒数第二个元素，level 2
                    Node newIndex = new Node(target.val, prev.right, downNode);
                    prev.right = newIndex;
                    downNode = newIndex;
                    coins = random.nextInt(2);
                } else { // 新建一个索引层级
                    // 新建索引节点和 head 节点
                    Node newIndex = new Node(target.val, null, downNode);
                    Node newHead = new Node(HEAD_VALUE, newIndex, head);
                    head = newHead; // head 指针上移
                    levels++; // 跳表层数加 1
                }
            }
        }

        /**
         * 查询
         * @param target
         * @return
         */
        public boolean search(int target) {
            // 拿到头节点
            Node node = head;
            node = get(target, node);
            return node==null?false:true;
        }

        /**
         * 查询同一层 查询到就返回
         * @param target
         * @param node
         * @return
         */
        public Node get(int target,Node node) {
            // 同一层的查询逻辑是 如果查询到下一个节点不为null 并且是小于需要查询的值 则需要继续向右查找 直到上面条件有任意不满足
            while (node!=null) {
                while (node.right!=null && node.right.val<target) {
                    node = node.right;
                }
                if (node.right!=null && node.right.val==target) {
                    return node;
                }
                node = node.down;
            }
            return null;
        }

        /**
         * 删除
         * @param num
         * @return
         */
        public boolean erase(int num) {
            boolean f = false;
            // 拿到头节点
            Node node = head;
            // 先同一层查询 查询不到再向下查询下一层
            node = get(num, node);
            while (node!=null) {
                Node right = node.right;
                // 开始断连接
                node.right = right.right;
                // help Gc
                right.right=null;
                f = true;
                node = node.down;
                node = get(num, node);
            }
            return f;
        }
    }
/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
//leetcode submit region end(Prohibit modification and deletion)

}



