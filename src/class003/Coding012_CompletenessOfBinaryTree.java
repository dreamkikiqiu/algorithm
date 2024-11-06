

// 验证完全二叉树
// 测试链接 : https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
public class Coding012_CompletenessOfBinaryTree {
    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    //两种实现均要用到以下结构
    //选择一个方法提交即可
    //leetcode该数据测试范围就修改一下MAX
    //由于方法1要队列中装null, 因此实际MAX1001以上
    //方法2目前只需要101足够
    public static int MAX = 101;

    public static TreeNode[] queue = new TreeNode[MAX];

    public static int l,r;

    //提交注意修改方法名->isCompleteTree
    //方法1:经典层序遍历就足够了
    public boolean isCompleteTree1(TreeNode root){
        if(root == null){
            return false;
        }

        l = r = 0;
        queue[r++] = root;
        while(l != r){
            //复用root
            root = queue[l++];
            if(root != null){
                queue[r++] = root.left;
                queue[r++] = root.right;
            }
            else{
                break;
            }
        }

        while(l != r){
            if(queue[l++] != null){
                return false;
            }
        }
        return true;
    }


    //前面的字段记得也拷上， 否则提交编译不会通过
    //提交时注意修改方法名->isCompleteTree
    //方法2
    public boolean isCompleteTree2(TreeNode root){
        if(root == null){
            return false;
        }
        l = r =0;
        queue[r++] = root;
        boolean leaf = false;
        while(l != r){
            //复用root
            root = queue[l++];
            //算法流程步骤2， 4， 若左不存在 且 右存在 => 不是完全二叉树
            //若被标记了叶子节点， 那么左存在或者右存在 => 不是完全二叉树
            if(root.left == null && root.right != null
            || (leaf && root.left != null)){
                return false;
            }

            //出现一度顶点(左存在 右不存在） 或者 直接是叶子节点（左不能存在， 右也不存在）
            // => 标记叶子顶点为null.
            if(root.left == null || root.right == null){
                leaf = true;
            }

            //经典层序遍历
            if(root.left != null){
                queue[r++] = root.left;
            }
            if(root.right != null){
                queue[r++] = root.right;
            }
        }
        //整个流程走下来都不满足， 那么一定是完全二叉树！
        return true;
    }
}
