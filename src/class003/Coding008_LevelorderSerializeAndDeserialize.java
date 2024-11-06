//二叉树的层序序列化和反序列化
public class Coding008_LevelorderSerializeAndDeserialize {
    //不要提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }
    //提交这个类1
    public class Codec {

        public static int MAX = 10001;
        public static TreeNode[] queue = new TreeNode[MAX];
        public static int l,r;

        public String serialize(TreeNode root){
            StringBuilder builder = new StringBuilder();
            if(root != null){
                builder.append(root.val).append(",");
                l = r = 0;
                queue[r++] = root;
                while(l != r){
                    //这里复用root。
                    root = queue[l++];
                    //经典的bfs操作即可。 只需注意， 如果孩子为空应该以"#,"的形式存入。
                    if(root.left != null){
                        queue[r++] = root.left;
                        builder.append(root.left.val).append(",");
                    }
                    else{
                        builder.append("#").append(",");
                    }

                    if(root.right != null){
                        queue[r++] = root.right;
                        builder.append(root.right.val).append(",");
                    }
                    else{
                        builder.append("#").append(",");
                    }
                }
            }
            return builder.toString();
        }

        /**
         *
         * @param val 字符串
         * @return 根据字符串是否为空串返回节点。
         */
        private static TreeNode generate(String val){
            return val.equals("#") ? null : new TreeNode(Integer.parseInt(val));
        }
        public TreeNode deserialize(String data) {
            if(data.isEmpty()){
                return null;
            }
            //根据分割符","切割字符串
            String[] vals = data.split(",");
            int cnt = 0;//记录当前字符串数组的有效值
            l = r = 0;//重置
            TreeNode root = generate(vals[cnt++]);
            queue[r++] = root;
            while(l != r){
                //按顺序挨个处理
                TreeNode cur = queue[l++];

                //连接左右孩子
                cur.left = generate(vals[cnt++]);
                cur.right = generate(vals[cnt++]);

                //根据cur的左右孩子是否为空决定入队。
                if(cur.left != null){
                    queue[r++] = cur.left;
                }
                if(cur.right != null){
                    queue[r++] = cur.right;
                }
            }
            return root;
        }
    }
}
