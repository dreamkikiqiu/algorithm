
//打印两个有序链表公共部分
//守门题
//测试链接无
public class Coding000_printCommonPart {

    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int data){
            this.val = data;
        }
    }

    public static void printCommonPart(ListNode head1, ListNode head2){
        System.out.print("Common Part:");
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                head1 = head1.next;
            }
            else if(head1.val > head2.val){
                head2 = head2.next;
            }
            else{
                System.out.println("head.val: " + head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

}