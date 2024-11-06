

// 验证平衡二叉树
// 测试链接 : https://leetcode.cn/problems/balanced-binary-tree/
public class Coding016_BalancedBinaryTree {
    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    //解法一:根据平衡树的定义， 这里的平衡性定义是AVL树风格
    //借助辅助方法getHeight求高度。
    //提交时修改函数名 和 递归方法为-> isBalanced
    public boolean isBalanced1(TreeNode root) {
        if(root==null){
            return true;
        }

        //先判断当前节点是否满足平衡性的定义
        if(Math.abs(getHeight(root.left)-getHeight(root.right))>1){
            return false;
        }else{
            //判断左右子树是否都平衡。
            return isBalanced1(root.left)&&isBalanced1(root.right);
        }
    }
    //Coding005_DepthOfBinaryTree ； 求高度算法与求二叉树的最大深度是同一个。
    private int getHeight(TreeNode root){
        return root==null?0:Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }
    //------------------------------------解法二---------------------------
    public static boolean balance = true;
    //提交时修改函数名-> isBalanced
    public static boolean isBalanced2(TreeNode root){
        balance = true;//先假设最初是平衡的
        process(root);
        return balance;
    }
    //在解法一 getHeight方法的细节加上平衡性balance的检验
    public static int process(TreeNode cur){
         if(!balance || cur == null){
             return 0;
         }

         int lh = process(cur.left);
         int rh = process(cur.right);

         if(Math.abs(lh - rh) > 1){
             balance = false;
             return 0;
         }
         else{
             return Math.max(lh, rh) + 1;
         }
    }

    //----------------------解法三-----------------
    //封装一个类处理多种信息
    public static class ReturnType{
        //高度
        public int height;
        //平衡
        public boolean isBalanced;
        public ReturnType(int h, boolean isB){
            height = h;
            isBalanced = isB;
        }
    }
    //提交函数时修改方法名 => isBalanced
    public static boolean isBalanced3(TreeNode root){
        //主方法调用 => 根节点的平衡性字段
        return process2(root).isBalanced;
    }
    //process方法功能: 返回当前节点为根节点的子树的平衡信息收集。
    public static ReturnType process2(TreeNode cur){
        //当前节点为空， 默认此时高度为0 ，且平衡！
        if(cur == null){
            return new ReturnType(0,true);
        }

        //分而治之， 递归地处理左右子树， 返回两者的信息
        ReturnType left = process2(cur.left);
        ReturnType right = process2(cur.right);

        //根据定义: 左子树平衡， 右子树平衡， 且左右高度差小于等于1
        // => 导出当前节点的平衡性。 直接由字段获得
        boolean isBalanced = left.isBalanced && right.isBalanced
                && Math.abs(left.height - right.height) < 2;
        //返回由cur节点的信息:高度，平衡性 => 向上调用
        return new ReturnType(Math.max(left.height , right.height) + 1, isBalanced);
    }
}
