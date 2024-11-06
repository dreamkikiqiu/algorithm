/**
 * 合并k个有序链表
 * 测试链接
 * 牛客链接: https://www.nowcoder.com/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany
 */
public class Coding010_MergeKLists {
    //不要提交这个类
    public static class ListNode{
        int val;
        ListNode next;
    }

    //提交这个类
    class Solution {
        public static ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0){
                return null;
            }
            return divide(lists,0, lists.length-1);
        }

        public static ListNode divide(ListNode[] lists, int left, int right){
            if(left >= right){
                return left == right? lists[left] : null;
            }
            int mid = left + (right - left)/2;
            ListNode head1 = divide(lists,left,mid);
            ListNode head2 = divide(lists,mid+1,right);

            return merge(head1, head2);
        }

        public static ListNode merge(ListNode head1, ListNode head2){
            if(head1 == null || head2 == null){
                return head1 == null ? head2 : head1;
            }
            ListNode head , tail ;
            head = tail = null;
            while(head1 != null && head2 != null){
                if(head1.val <= head2.val){
                    if(tail == null){
                        head = tail = head1;
                    }
                    else{
                        tail.next = head1;
                        tail = tail.next;
                    }
                    head1 = head1.next;
                }
                else{
                    if(tail == null){
                        head = tail = head2;
                    }
                    else{
                        tail.next = head2;
                        tail = tail.next;
                    }
                    head2 = head2.next;
                }
            }
            tail.next =  head1 != null ? head1 : head2;
            return head;
        }
    }
}
