




//测试链接也可通过
//牛客网:https://www.nowcoder.com/practice/b58434e200a648c589ca2063f1faf58c?tpId=295&tqId=23286&ru=%2Fexam%2Fcompany&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Fcompany
public class Coding008_reversePart {

    public static class ListNode{
        int val;
        //双向链表
//        public ListNode last;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    /**
     *
     * @param head 链表头节点
     * @param from 链表中第from个位置
     * @param to 链表中第to个位置
     * @return 反转部分后新链表的头节点
     */
    public static ListNode reversePart(ListNode head, int from, int to){
        int len = 0;
        ListNode fPre = null, tPos = null;
        ListNode cur = head;
        while(cur != null){
            len++;
            fPre = len == from - 1?cur : fPre;
            tPos = len == to + 1? cur : tPos;
            cur = cur.next;
        }

        if(from > to || from < 1 || to > len){
            return head;
        }
        ListNode pre = fPre == null ? head : fPre.next;
        cur = pre.next;
        pre.next = tPos;
        ListNode next = null;
        while(cur != tPos){
           next = cur.next;
           cur.next  = pre;
           pre = cur;
           cur = next;
        }

        if(fPre != null){
            fPre.next = cur;
            return head;
        }
        return pre;
    }

    public static ListNode reversePart1(ListNode head, int from, int to){
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode fPre = dummy, tPos = dummy;
        ListNode cur = head;
        int len = 0;
        while(cur != null){
            len++;
            fPre = len == from - 1 ? cur : fPre;
            tPos = len == to + 1 ? cur : tPos;

            cur = cur.next;
        }
        if(from < 1 || to > len || from > to){
            return head;
        }
        ListNode pre = fPre.next;
        cur = pre.next;
        pre.next = tPos;
        ListNode next = null;
        while(cur != tPos){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        fPre.next = pre;
        return dummy.next;
    }
}
