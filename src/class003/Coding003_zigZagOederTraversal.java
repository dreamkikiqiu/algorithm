import java.util.*;

public class Coding003_zigZagOederTraversal {

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
    //什么是zigzag打印

    /**
     *          1
     *        /  \
     *       2    3
     *     /    /  \
     *    4    5    6
     *       /  \
     *      7    8
     * 每层输出:
     * level0 : 1
     * level1 : 3 2
     * level2 : 4 5 6
     * level3 : 8 7
     *
     */
    //提交时修改函数名->zigzagLevelOrder
    public List<List<Integer>> zigzagLevelOrder1(TreeNode head) {
            var ans = new ArrayList<List<Integer>>();
            if(head != null){
                LinkedList<TreeNode> queue = new LinkedList<>();
                queue.offer(head);
                while(!queue.isEmpty()){
                    int size = queue.size();
                    List<Integer> list = new ArrayList<Integer>();
                    while(size-- > 0){
                        head = queue.poll();
                        list.add(head.val);

                        if(head.left != null){
                            queue.offer(head.left);
                        }

                        if(head.right != null){
                            queue.offer(head.right);
                        }
                    }
                    ans.add(list);
                }
                //根节点层为第0层, 对奇数层进行逆序
                for(int i=1;i<ans.size();i+=2){
                    //Collections工具类有个reverse方法可以逆序列表
                    Collections.reverse(ans.get(i));
                }
            }
            return ans;
    }
    // //提交时修改函数名->zigzagLevelOrder
    public List<List<Integer>> zigzagLevelOrder2(TreeNode head) {
        var ans = new ArrayList<List<Integer>>();
        if (head != null) {
            //步骤一:申请两个list, 并初始处理list1
            ArrayList<TreeNode> list1 = new ArrayList<>();
            ArrayList<TreeNode> list2 = new ArrayList<>();
            list1.add(head);

            //步骤4: list1 与 list2总有一个为空。交替重复处理
            while (!list1.isEmpty() || !list2.isEmpty()) {
                int size;
                List<Integer> list = new ArrayList<>();
                if (list2.isEmpty()) {
                    //步骤2:list2为空就处理list1, 从左往右的顺序
                    //头删list1的节点并且将其孩子按左右顺序加入到list2。
                    size = list1.size();

                    while (size-- > 0) {
                        head = list1.removeFirst();
                        list.add(head.val);

                        if (head.left != null) {
                            list2.add(head.left);
                        }
                        if (head.right != null) {
                            list2.add(head.right);
                        }
                    }
                } else {

                    //步骤3:list1为空那么处理list2, 从左往右的顺序
                    //尾删list1的节点并且将其孩子按右->左顺序加入到list1。
                    size = list2.size();

                    while (size-- > 0) {
                        head = list2.removeLast();
                        list.add(head.val);
                        if (head.right != null) {
                            list1.addFirst(head.right);
                        }

                        if (head.left != null) {
                            list1.addFirst(head.left);
                        }
                    }
                }
                ans.add(list);
            }
        }
        return ans;
    }
    // //提交时修改函数名->zigzagLevelOrder
    public List<List<Integer>> zigzagLevelOrder3(TreeNode head){
        var ans = new ArrayList<List<Integer>>();
        if (head != null) {
            //申请一个双端队列， 根节点从后入队
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offerLast(head);
            // reverse:false -> 从左向右: deque
            // reverse:true -> 从右往左: deque
            boolean reverse = false;
            while(!deque.isEmpty()){
                int size = deque.size();
                List<Integer> list = new ArrayList<>();
                //步骤2: reverse为false， 从左向右执行。
                if(!reverse){
                    while(size-- > 0) {
                        //左队头出队
                        head = deque.pollFirst();
                        list.add(head.val);
                        //先左后右: 右队头入
                        if (head.left != null) {
                            deque.offerLast(head.left);
                        }
                        if (head.right != null) {
                            deque.offerLast(head.right);
                        }
                    }
                }
                else{
                    //步骤3: reverse为true， 从右向左执行。
                    while(size-- > 0) {
                        //右队头出队
                        head = deque.pollLast();
                        list.add(head.val);
                        //先右后左：左队头入
                        if (head.right != null) {
                            deque.offerFirst(head.right);
                        }
                        if (head.left != null) {
                            deque.offerFirst(head.left);
                        }
                    }
                }
                ans.add(list);
                //步骤2，3交替执行， 因此要反转reverse。 ！reverse即可。
                reverse = !reverse;
            }
        }
        return ans;
    }
    //leetcode修改数据量， 仅修改一下MAX即可
    public static int MAX = 2001;
    //全局静态数组实现双端队列
    public static TreeNode[] queue = new TreeNode[MAX];
    public static int l,r;
    //提交时修改函数名->zigzagLevelOrder
    public List<List<Integer>> zigzagLevelOrder4(TreeNode head){
        List<List<Integer>> ans = new ArrayList<>();
        if(head != null){
            //重置l,r
            l = r = 0;
            boolean reverse = false;
            queue[r++] = head;
            while(l != r){
                int size = r - l;
                ArrayList<Integer> list = new ArrayList<>();

                //reverse == false. 左->右， i [l,r-1]顺序， j = 1。收集size个。
                //reverse == true. 右->左， i [r-1 - > l] , j = -1。收集size个。
                //上两步是对称过程， 一个reverse加三目优雅解决。
                for(int i = reverse ? r - 1 : l,j = reverse ? -1 : 1, k = 0;k < size; i += j, k++){
                    TreeNode cur = queue[i];
                    list.add(cur.val);
                }

                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue[l++];
                    if (cur.left != null) {
                        queue[r++] = cur.left;
                    }
                    if (cur.right != null) {
                        queue[r++] = cur.right;
                    }
                }

                ans.add(list);
                //反转
                reverse = !reverse;
            }

        }
        return ans;
    }
}
