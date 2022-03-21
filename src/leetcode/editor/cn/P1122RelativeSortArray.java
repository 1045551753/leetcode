//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 数组 哈希表 计数排序 排序 👍 196 👎 0


package leetcode.editor.cn;
/**
 * 数组的相对排序
 * @author Administrator
 */
public class P1122RelativeSortArray{
    public static void main(String[] args) {
        Solution solution = new P1122RelativeSortArray().new Solution();
        int[] arr1 = new int[]{28,6,22,8,44,17};
        int[] arr2 = new int[]{22,28,8,6};
        solution.relativeSortArray(arr1,arr2);
        for (int i : arr1) {
            System.out.println(i);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            // 使用双指针
            int start = 0;
            for (int i : arr2) {
                int end = arr1.length-1;
                while (start<end) {
                    if (arr1[start] == i) {
                        start++;
                    } else {
                        while (arr1[end] != i && start<end) {
                            end--;
                        }
                        if (arr1[end] ==i) {
                            int temp = arr1[start];
                            arr1[start] = arr1[end];
                            arr1[end] = temp;
                        }
                    }
                }
            }
            if (start!=arr1.length-1) {
                QuickSort(arr1, start,arr1.length-1);
            }
            return arr1;
        }

        public void QuickSort(int[] array, int start,int end) {
            int now=start;
            int left = start;
            int right =end;
            if (left>right) {
                return;
            }
            if (array ==null || array.length<2) {
                return;
            }
            int constant = array[now];
            while(left<right) {
                // 从右开始往左找
                while (left<right && array[right]>=constant) {
                    right--;
                }
                while (left<right && array[left]<=constant) {
                    left++;
                }
                int temp = array[left];
                // 开始交换
                if (left<right) {
                    array[left] = array[right];
                    array[right] = temp ;
                } else {
                    // 交换到最后left和right相等
                    array[left] = constant;
                    array[now] =temp;
                }
            }
            // 递归处理左边的
            QuickSort(array, start,left-1);

            // 递归处理右边的
            QuickSort(array, right+1,end);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}



