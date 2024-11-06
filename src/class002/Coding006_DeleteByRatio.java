

//题目：
//给定链表的头节点head，两个整数a,b. 删除链表中第a/b位置处的节点。
//
public class Coding006_DeleteByRatio {
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

    public static ListNode deleteByRatio(ListNode head, int a, int b){
        //校验不需要删除的情况
        if(a < 1 || a > b){
            return head;
        }
        if(head == null || head.next == null){
            return null;
        }
        ListNode cur = head;
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        len = (int)Math.ceil((double)(a * len)/ (double)b) ;
        if(len == 1){
            head = head.next;
        }
        else{
            // len > 2
            cur = head;
            while(--len != 1){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;

    }

}
