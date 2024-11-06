////注意修改类名->Solution
// 测试链接 : https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
public class Coding007_PostorderSerializeAndDeserialize {
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
            f(root.left, builder);
            f(root.right, builder);
            builder.append(root.val).append(",");
        }
    }
    //全局变量追踪当前字符
    public static int cnt = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //根据分割符","切割字符串 ->字符串数组。
        String[] vals = data.split(",");
        cnt = vals.length-1;
        return g(vals);//调用辅助方法
    }

    public TreeNode g(String[] vals){
        //提取当前字符串
        String cur = vals[cnt--];
        if(cur.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.parseInt(cur));
        head.right = g(vals);
        head.left = g(vals);
        return head;
    }
}
