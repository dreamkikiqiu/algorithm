

//
// https://leetcode.cn/problems/UHnkqh/description/?envType=problem-list-v2&envId=linked-list
// https://leetcode.cn/problems/reverse-linked-list/
public class Coding001_ListReverse {
    // 单链表节点
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int val) {
            this.value = val;
        }

        public ListNode(int val, ListNode next) {
            this.value = val;
            this.next = next;
        }
    }

    // 反转单链表测试链接 : https://leetcode.cn/problems/reverse-linked-list/
    class Solution {
        public static ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode next = null;
            while (head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }

    // 双链表节点
    public static class DoubleListNode {
        public int value;
        public DoubleListNode last;
        public DoubleListNode next;

        public DoubleListNode(int value) {
            this.value = value;
        }
    }

    // 反转双链表
    // 没有找到测试链接
    // 如下方法是对的
    public static DoubleListNode reverseDoubleList(DoubleListNode head) {
        DoubleListNode pre = null;
        DoubleListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            //对于单链表的反转
            //head.last -> next
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
