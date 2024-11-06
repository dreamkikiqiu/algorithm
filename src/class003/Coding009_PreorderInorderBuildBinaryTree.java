import java.util.HashMap;

// 利用先序与中序遍历序列构造二叉树
// 测试链接 : https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class Coding009_PreorderInorderBuildBinaryTree {
    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }
    //提交这个类
    public class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder == null || inorder == null || preorder.length != inorder.length){
                return null;
            }
            //key:中序数组具体的元素， value：下标
            HashMap<Integer, Integer> map = new HashMap<>();

            //遍历中序数组建立值->下标的关系 （注意数组无重复值才能这么干）
            for(int i=0;i<preorder.length;i++) {
                map.put(inorder[i],i);
            }
            //调用辅助方法。
            return f(preorder,0, preorder.length - 1, inorder,0, inorder.length-1, map);
        }

        public TreeNode f(int[] preorder, int preStart,int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map){
                //处理越界情况
                if(preStart > preEnd){
                    return null;
                }
                //构建根节点
                TreeNode root = new TreeNode(preorder[preStart]);
                if(preStart == preEnd){
                    //先序数组中只有一个节点， 直接返回
                    return root;
                }
                //根据根节点的值， 查找其在中序数组的下标上
                int k = map.get(preorder[preStart]);
                //中序数组左区间部分[inStart, k - 1] => 长度 k - inStart. 先序起始为preStart + 1, 结尾部分加上长度 - 1即 preStart + k - inStart
                root.left = f(preorder, preStart + 1, preStart - inStart + k ,inorder, inStart, k - 1, map);
                //中序数组右区间部分[k+1, inEnd]. => 长度 inEnd - k . 先序结尾为preEnd,减去长度 + 1是其右区间的起始 preEnd - inEnd + k + 1
                root.right = f(preorder, preEnd - inEnd + k + 1, preEnd, inorder, k+1, inEnd, map);
                return root;
        }
    }
}
