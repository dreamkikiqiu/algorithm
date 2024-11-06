
//删除链表中倒数第n个位置处的节点
//测试链接:

public class Coding007_removeNthFromEnd {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fast = head;
            ListNode slow = head;
            while(n>0)
            {
                fast = fast.next;
                n--;
            }
            //头删
            if(fast==null)
            {
                head = head.next;
            }
            else {
                while (fast.next != null) {
                    fast = fast.next;
                    slow = slow.next;
                }
                slow.next = slow.next.next;
            }
            return head;
        }
    }
}
