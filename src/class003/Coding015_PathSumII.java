
import java.util.ArrayList;
import java.util.List;

// 收集累加和等于aim的所有路径
// 测试链接 : https://leetcode.cn/problems/path-sum-ii/
// 提交内部的Solution类
public class Coding015_PathSumII {
    // 不提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val){ this.val = val;}
    }

    /**
     * 每次调用f是对于path是独立的， 即以该处为分支的结果互不影响。
     * 递归回溯复原
     * @param cur 当前所在的树节点
     * @param aim 目标值
     * @param pathSum 当前的路径和
     * @param path 路径节点收集的表
     * @param ans 答案
     */
    public static void f(TreeNode cur,int aim, int pathSum, List<Integer> path,List<List<Integer>> ans ){
        //将cur.val加入到路径中。
        path.add(cur.val);
        //先讨论是否为叶子节点
        if(cur.left == null && cur.right == null){
            //再判断路径和是否满足 if true => 深拷贝path并加入到ans中
            if(cur.val + pathSum == aim){
                //Java提供迭代器生成列表实现了深拷贝
                //其它语言可以封装函数实现 C++迭代器遍历拷贝一下 ok.
                ans.add(new ArrayList<Integer>(path));
            }
        }
        else{
            //f=>前往左子树分支
            if(cur.left != null){
                f(cur.left,aim,pathSum + cur.val,path,ans);
            }
            //f=>前往右子树分支
            if(cur.right != null){
                f(cur.right,aim,pathSum + cur.val,path,ans);
            }
        }
        //复原 => 保证独立性
        path.removeLast();
    }

    /**
     * 主方法
     * @param root 树的根节点
     * @param targetSum 目标路径和
     * @return 返回满足条件的路径和
     */
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum){
        var ans = new ArrayList<List<Integer>>();
        if(root != null){
            var path = new ArrayList<Integer>();
            f(root, targetSum, 0, path, ans);
        }
        return ans;
    }
}
