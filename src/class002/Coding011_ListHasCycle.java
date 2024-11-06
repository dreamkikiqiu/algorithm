


//判断链表中是否有环
//测试链接:
//牛客练习链接:
public class Coding011_ListHasCycle {
    public static class ListNode{
        int val;
        public ListNode next;
    }
    //提交这个类
    public class Solution {

        //快慢指针法。
        public boolean hasCycle(ListNode head) {
            if(head == null || head.next == null){
                return false;
            }

            //fast, slow先错位
            ListNode fast = head.next;
            ListNode slow = head;
            while(fast != slow && fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            return fast == slow;
        }
    }
}
