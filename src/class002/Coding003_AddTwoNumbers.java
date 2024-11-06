
//链表相加
//测试链接: https://leetcode.cn/problems/add-two-numbers/
//测试链接2： https://leetcode.cn/problems/lMSNwu/description/?envType=problem-list-v2&envId=linked-list
public class Coding003_AddTwoNumbers {

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

    //一种直观的解法
    //先不考虑进位， 先根据已有两链表对应做加法生成新链表
    //本题可以是可以修改原链表的，不过还是写深拷贝写法。
    //提交时方法名改为->addTwoNumbers
    public class Solution {
        public static ListNode addTwoNumbers1(ListNode l1, ListNode l2){
            ListNode head = null, tail = null;
            //题目给定l1, l2必不为空， 这里不做空链表的逻辑
            while(l1 != null && l2 != null){
                //讨论第一次生成节点的情况
                if(head == null){
                    head = tail = new ListNode(l1.val + l2.val);
                }
                else{
                    tail.next = new ListNode(l1.val + l2.val);
                    tail = tail.next;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            ListNode cur = l1 != null ? l1 : l2;
            while(cur != null){
                tail.next = new ListNode(cur.val);
                tail = tail.next;
                cur = cur.next;
            }

            int carry = 0;
            cur = head;
            while(cur != null){
                cur.val += carry;
                if(cur.val >= 10){
                    carry = 1;
                    cur.val %= 10;
                }
                else{
                    carry = 0;
                }
                cur = cur.next;
            }
            if(carry == 1){
                tail.next = new ListNode(1);
            }
            return head;
        }
    }

}
