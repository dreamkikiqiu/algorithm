import java.util.*;


public class Coding002_levelOrderTraversal {
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
    //广度优先遍历打印
    public void levelOrder(TreeNode head){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        if(!queue.isEmpty()){
            head = queue.poll();
            System.out.print(head.val + " ");
            if(head.left != null){
                queue.offer(head.left);
            }
            if(head.right != null){
                queue.offer(head.right);
            }
        }
    }
    /**
     * 此法用了哈希表，很拉跨。 但建议熟悉一下coding写法。
     * 提交时把后缀1去掉。
     * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/description/">...</a>
     * @param head root
     * @return the level order traversal of its nodes' values
     */
    public List<List<Integer>> levelOrder1(TreeNode head) {
        List<List<Integer>> ans = new ArrayList<>();
        if(head != null){
            //申请一个队列
            Queue<TreeNode> queue = new LinkedList<>();
            //申请哈希表: key：节点指针->value：节点所在层数
            HashMap<TreeNode, Integer> levels = new HashMap<>();

            //初始对队列和哈希表处理
            queue.offer(head);
            levels.put(head, 0);

            while(!queue.isEmpty()) {
                //处理队列一个节点
                head = queue.poll();
                //获取当前层数
                int level = levels.get(head);
                //如果当前层数不存在， 则创建。
                if (ans.size() == level) {
                    ans.add(new ArrayList<>());
                }

                //将cur节点的值加入当前层的序列
                ans.get(level).add(head.val);

                //处理cur的左右两个节点（如果存在则入队）， 并记录在下一层的哈希表
                if (head.left != null) {
                    queue.offer(head.left);
                    levels.put(head.left, level + 1);
                }

                if (head.right != null) {
                    queue.offer(head.right);
                    levels.put(head.right, level + 1);
                }
            }
        }
        return ans;
    }

    /**
     * 链接同上
     * 提交时将函数名->levelOrder
     * @param head root
     * @return the level order traversal of its nodes' values
     */
    public List<List<Integer>> levelOrder2(TreeNode head){
        List<List<Integer>> ans = new ArrayList<>();
        if(head != null){
            //步骤1： 申请队列， 头节点入队。
            var queue = new LinkedList<TreeNode>();
            queue.offer(head);
            //步骤4:逻辑改为按层处理， 外循环一次处理一层。
            while(!queue.isEmpty()){
                //步骤2:获得当前层处理的节点个数
                int size = queue.size();
                //创建该层的列表
                List<Integer> list = new ArrayList<>(size);

                //步骤3: 循环处理当前层的节点
                while(size-- > 0){
                    //步骤3 出队 ,head复用
                    head = queue.poll();
                    list.add(head.val);

                    //步骤3 左右子树入队（如果存在）
                    if(head.left != null){
                        queue.offer(head.left);
                    }

                    if(head.right != null){
                        queue.offer(head.right);
                    }
                }
                ans.add(list);
            }
        }
        return ans;
    }

    /**
     * 解法3：100%的速度。 全局静态数组
     * 提交时函数名->levelOrder
     * 本题数据量[0,2000]， 所以开一个2000的数组充当队列.
     * 需要了解数组实现队列。
     */
    public static int MAX = 2000;//数据量增大就更新这个值
    public static TreeNode[] queue = new TreeNode[MAX];
    public static int l,r; //l==r时为空， [l,r)
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder3(TreeNode head){
        if(head != null){
            l = r = 0;//重置为0
            queue[r++] = head;
            while(l!=r){
                int size = r - l;
                ArrayList<Integer> list = new ArrayList<>(size);
                while(size-- > 0){
                    TreeNode cur = queue[l++];
                    list.add(cur.val);

                    if(cur.left != null){
                        queue[r++] = cur.left;
                    }

                    if(cur.right != null){
                        queue[r++] = cur.right;
                    }
                }
                ans.add(list);
            }
        }
        return ans;
    }
}
