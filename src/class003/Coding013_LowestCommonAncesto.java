
// 普通二叉树上寻找两个节点的最近公共祖先
// 测试链接 : https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
public class Coding013_LowestCommonAncesto {
    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 提交如下的方法
    //p的子树包含q或者q的子树包含p。
    //p,q分叉。 分叉节点就是最近的公共祖先。
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //三种结束情况: 找不到或者找到了其中一个节点（另一个节点在不在不知道）
        if(root == null || root == p || root ==q){
            return root;
        }
        //lA去找p,q中任意一个节点
        TreeNode lA = lowestCommonAncestor(root.left, p,q);
        //rA去找p,q中任意一个节点
        TreeNode rA = lowestCommonAncestor(root.right, p, q);

        //lA 找到了p(q), rA找到了q(p)。
        //意味着p,q只出现在同侧， 它们的祖先就是root。
        if(lA != null && rA != null){
            return root;
        }

        //递归过程向上返回可能组合出的左右子树均没有p,q的情况。
        if(lA == null && rA == null){
            return null;
        }

        // lA 和 rA 其中一个为空。 那么对应包含关系。
        //最上面的基线条件可知 lA 或 rA 就代指 p或者q的某一个。简化讨论，结束！
        return lA == null ? rA : lA;
    }

}
