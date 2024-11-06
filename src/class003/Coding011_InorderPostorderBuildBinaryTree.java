import java.util.HashMap;

//根据中序遍历和后序遍历构建二叉树
//测试链接: https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class Coding011_InorderPostorderBuildBinaryTree {
    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }

    public class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if(inorder == null || postorder == null || inorder.length != postorder.length){
                return null;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0;i< inorder.length;i++){
                map.put(inorder[i] ,i);
            }
            return f(inorder,0,inorder.length-1,postorder,0,postorder.length-1, map);
        }
        private static TreeNode f(int[] order, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd, HashMap<Integer, Integer> map){
            if(postStart > postEnd){
                return null;
            }
            TreeNode root = new TreeNode(postOrder[postEnd]);
            if(postStart == postEnd){
               return root;
            }
            int k = map.get(postOrder[postEnd]);
            root.left = f(order, inStart, k - 1, postOrder, postStart,postStart + k - inStart - 1, map );
            root.right = f(order,k+1,inEnd, postOrder,postEnd - inEnd + k,postEnd-1,map);
            return root;
        }
    }
}
