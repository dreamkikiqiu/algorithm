import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 三道函数题
 * 先序遍历非递归: <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/description/">二叉树先序遍历</a>
 * 中序遍历非递归: <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/description">二叉树中序遍历</a>
 * 后序遍历非递归: <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/description/">二叉树后序遍历</a>
 */
public class Coding001_preInPostUnRec {
    //不要提交这个类
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //辅助preorderTraversalRec的方法
    private void f(TreeNode head, List<Integer> list){
        if(head != null){
            list.add(head.val);
            f(head.left, list);
            f(head.right, list);
        }
    }
    //主方法, 修改函数名->preorderTraversal
    public List<Integer> preorderTraversalRec(TreeNode head){
        List<Integer> list = new ArrayList<>();
        f(head, list);
        return list;
    }

    /**
     * 修改函数名->preorderTraversal
     * 由于递归，函数体内部代码也要调整。
     */
    public List<Integer> preorderTraversalRec1(TreeNode head){
        List<Integer> list = new ArrayList<>();
        if(head != null) {
            list.add(head.val);
            list.addAll(preorderTraversalRec1(head.left));
            list.addAll(preorderTraversalRec1(head.right));
        }
        return list;
    }
    //提交修改函数名 ->preorderTraversal
    public List<Integer> preorderTraversalUnRec(TreeNode head) {
        List<Integer> list= new ArrayList<>();
        if(head != null){
            //申请一个栈
            Stack<TreeNode> stack = new Stack<>();
            //先压根节点
            stack.push(head);
            while(!stack.isEmpty()){
                //弹栈处理(加入列表)， 这里复用变量head.
                head = stack.pop();
                list.add(head.val);

                //先压右子树（如果存在）
                if(head.right != null){
                    stack.push(head.right);
                }
                //后压左子树（如果存在）
                if(head.left != null){
                    stack.push(head.left);
                }
            }
        }
        //返回结果。
        return list;
    }
    //-------------------------------------------------------------
    //中序遍历递归非递归
    //辅助inorderTraversalRec的方法
    private void f2(TreeNode head, List<Integer> list){
        if(head != null){
            f2(head.left, list);
            list.add(head.val);
            f2(head.right, list);
        }
    }
    //主方法  修改函数名->inorderTraversal
    public List<Integer> inorderTraversalRec(TreeNode head){
        List<Integer> list = new ArrayList<>();
        f2(head, list);
        return list;
    }

    /**
     * 修改函数名->inorderTraversal
     * 由于递归，函数体内部代码也要调整。
     */
    public List<Integer> inorderTraversalRec1(TreeNode head){
        List<Integer> list = new ArrayList<>();
        if(head != null) {
            list.addAll(inorderTraversalRec1(head.left));
            list.add(head.val);
            list.addAll(inorderTraversalRec1(head.right));
        }
        return list;
    }
    //非递归中序版本: 提交修改函数名->inorderTraversal
    public List<Integer> inorderTraversalUnRec(TreeNode head) {
        List<Integer> list = new ArrayList<>();
        if(head != null){
            //申请一个栈
           var stack = new Stack<TreeNode>();
           //cur: 遍历二叉树,初始化为head
           var cur = head;
           //循环条件 栈不为空或者cur不为null
           while(!stack.isEmpty() || cur != null){
               if(cur != null){
                   //算法流程步骤2

                   //压栈
                   stack.push(cur);
                   //继续往左走， 不到尽头不回头。
                   cur = cur.left;
               }
               else{
                   //算法流程3

                   //弹栈
                   cur = stack.pop();
                   //处理（加入列表）
                   list.add(cur.val);
                   //尝试往右走。
                   cur = cur.right;
               }
           }
        }
        return list;
    }
    //---------------------------------
    //后序遍历递归版本
    //后序遍历单栈和双栈实现

    //辅助方法
    private void f3(TreeNode head, List<Integer> list){
        if(head != null){
            f3(head.left, list);
            f3(head.right, list);
            list.add(head.val);
        }
    }
    //主方法  修改函数名->postorderTraversal
    public List<Integer> postorderTraversalRec(TreeNode head){
        List<Integer> list = new ArrayList<>();
        f3(head, list);
        return list;
    }
    /**
     * 修改函数名->postorderTraversal
     * 由于递归，函数体内部代码也要调整。
     */
    public List<Integer> postorderTraversalRec1(TreeNode head){
        List<Integer> list = new ArrayList<>();
        if(head != null){
            list.addAll(postorderTraversalRec1(head.left));
            list.addAll(postorderTraversalRec1(head.right));
            list.add(head.val);
        }
        return list;
    }
    //双栈迭代实现后序遍历 函数名->postorderTraversal
    public List<Integer> postorderTraversalTwoStacks(TreeNode head) {
        List<Integer> list = new ArrayList<>();
        if(head != null) {
            //步骤1:申请两个栈, 一个常规栈stack 另一收集栈collect
           var stack = new Stack<TreeNode>();
           var collect = new Stack<TreeNode>();
           //步骤1：根节点入栈
            stack.push(head);

            //步骤3:循环步骤2，直到栈stack为空。
            while(!stack.isEmpty()){
                //步骤2:弹栈， 复用head
                head = stack.pop();
                //步骤2: 收集栈收集节点(替代常规处理)
                collect.push(head);

                //步骤2:先压左子树后压右子树
                if(head.left != null){
                    stack.push(head.left);
                }

                if(head.right != null){
                    stack.push(head.right);
                }
            }

            //步骤4:逆序输出处理收集栈
            while(!collect.isEmpty()){
                list.add(collect.pop().val);
            }
        }
        //返回结果
        return list;
    }
    //单栈迭代实现后序遍历 函数名->postorderTraversal
    public List<Integer> postorderTraversalOneStack(TreeNode head){
        List<Integer> list = new ArrayList<>();
        if(head != null){
            //步骤1:申请栈
            var stack = new Stack<TreeNode>();
            /// 这里复用了head作为pre, 当head经历步骤4之后表示上次处理的节点， 否则是整棵树的根节点。
            stack.push(head);
            TreeNode cur = head;
            //步骤5： 循环判断步骤2,3,4->栈为空。
            while(!stack.isEmpty()){
                cur = stack.peek();
                //步骤2 条件判断: 左不为空， 且左右都未访问过。进入左子树
                if(cur.left != null && head != cur.left && head != cur.right){
                    stack.push(cur.left);
                }
                //步骤3 条件判断: 右不为空， 且右节点未访问过。 进入右子树
                else if(cur.right != null && head != cur.right){
                    stack.push(cur.right);
                }
                else{
                    //步骤4

                    //处理当前节点
                    list.add(cur.val);
                    //标记上次处理的节点
                    head = cur;
                    //弹栈
                    stack.pop();
                }
            }
        }
        return list;
    }
}
