// 给你一个链表的头节点 head 和一个特定值 x
// 请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
// 你应当 保留 两个分区中每个节点的初始相对位置
// 测试链接 : https://leetcode.cn/problems/partition-list/
public class Coding004_PartitionList {
    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    class Solution{
        public ListNode partition(ListNode head, int x) {
            ListNode l1H = null, l1T = null;
            ListNode l2H = null ,l2T = null;
            ListNode next = null;
            while(head != null){
                next = head.next;
                //下面这行代码很重要。
                head.next = null;
                if(head.val < x){
                    if(l1H == null){
                        l1H = l1T = head;
                    }
                    else{
                        l1T.next = head;
                        l1T = l1T.next;
                    }
                }
                else{
                    if(l2H == null){
                        l2H = l2T = head;
                    }
                    else{
                        l2T.next = head;
                        l2T = l2T.next;
                    }
                }
                head = next;

            }
            if(l1H == null){
                return l2H;
            }
            l1T.next = l2H;
            return l1H;
        }
    }
}
