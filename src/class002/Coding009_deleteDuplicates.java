import java.util.HashSet;

//测试链接: https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
public class Coding009_deleteDuplicates {

    public static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        //删除值为val的节点
        public ListNode deleteNode(ListNode head, int val) {
            while(head != null && head.val == val){
                head = head.next;
            }

            if(head==null || head.next == null){
                return head;
            }

            ListNode cur = head;
            ListNode pre = head;
            while(cur != null){
                if(cur.val == val){
                    pre.next = cur.next;
                    cur = cur.next;
                    continue;
                }
                pre = cur;
                cur = cur.next;
            }
            return head;
        }
        //删除出现重复值的节点
        public ListNode deleteDuplicates(ListNode head) {

            if(head == null || head.next == null) return head;
            //先搞虚拟头节点
            ListNode newHead = new ListNode(0, head);
            ListNode cur = newHead.next;
            ListNode pre = newHead;
            while(cur != null){
                //找到重复的节点。=> 循环找到不重复的节点开始
                while(cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                //讨论节点是否是重复节点
                if(pre.next != cur){
                    pre.next = cur.next;
                }
                else{
                    pre = cur;
                }
                //这条语句保证了每次循环cur始终在pre的后面。
                cur = pre.next;
            }
            return newHead.next;
        }
    }
}

