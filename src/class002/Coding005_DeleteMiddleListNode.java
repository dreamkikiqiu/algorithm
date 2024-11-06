//测试链接 :https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/description/
public class Coding005_DeleteMiddleListNode {

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
    //提交这个类
    class Solution {

        //找到链表中点， 结合pre前驱指针删除。
        //中点可以通过计数的方式找到， 但完全没必要写这种方法
        //了解快慢指针法即可。由于删除的中间节点， 可以改一下细节让原先的slow指针指向实际中间节点前一个节点
        public ListNode deleteMiddle(ListNode head) {
            //快慢指针法
            //模板， 可以直接背
            if(head == null || head.next == null){
                return null;//当节点只有一个时就删除整个链表。
            }

            ListNode fast = head.next.next;
            ListNode slow = head;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }
}
