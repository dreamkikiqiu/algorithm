


//根据先序数组和后序数组构造二叉树
//测试链接: https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
public class Coding010_PreorderPostorderBuildBinaryTree {
    //不要提交这个类
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {this.val = val;}
        public TreeNode(){}
        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //提交这个类
    public class Solution {
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
                return  null;
        }
    }
}

