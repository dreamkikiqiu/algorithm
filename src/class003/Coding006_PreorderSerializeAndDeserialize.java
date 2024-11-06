//注意修改类名->Solution
//测试链接: https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
public class Coding006_PreorderSerializeAndDeserialize {
    //不要提交这个类
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         //创建一个可变字符串类StringBuilder类
         // 字符串高效增加元素。
         StringBuilder builder = new StringBuilder();
         //辅助调用
         f(root, builder);
         return builder.toString();//转String
    }
    //
    public void f(TreeNode root, StringBuilder builder){
         if(root == null){
             builder.append("#,");
         }
         else {
             //链式调用
             builder.append(root.val).append(",");
             f(root.left, builder);
             f(root.right, builder);
         }
    }
    //全局变量追踪当前字符
    public static int cnt = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //根据分割符","切割字符串 ->字符串数组。
        String[] vals = data.split(",");
        cnt = 0;
        return g(vals);//调用辅助方法
    }

    public TreeNode g(String[] vals){
        //提取当前字符串
        String cur = vals[cnt++];
        if(cur.equals("#")){
            return null;
        }
        //递归: 生成当前节点 + 左子树连接递归 + 右子树连接递归。
        TreeNode head = new TreeNode(Integer.parseInt(cur));
        head.left = g(vals);
        head.right = g(vals);
        return head;//返回最终结果。
    }
}
