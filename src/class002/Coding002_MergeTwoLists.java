



// 将两个升序链表合并为一个新的 升序 链表并返回
// 新链表是通过拼接给定的两个链表的所有节点组成的
// 测试链接 : https://leetcode.cn/problems/merge-two-sorted-lists/
// 牛客链接: https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=295&tags=&title=&difficulty=0&judgeStatus=0&rp=0&sourceUrl=%2Fexam%2Fcompany
public class Coding002_MergeTwoLists {

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
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1 == null || list2 == null){
                return list1 != null ? list1 : list2;
            }

            //head, tail构造新头尾指针拼一个链表
            //内部要讨论第一次连接的情况， 更改头节点的位置
            ListNode head = null, tail = null;
            while(list1 != null && list2 != null){
                //取等呢个， 保持稳定性
                if(list1.val <= list2.val){
                    if(head == null){
                        head = tail = list1;
                    }
                    else{
                        tail.next = list1;
                        tail = tail.next;
                    }
                    list1 = list1.next;
                }
                else{
                    if(head == null){
                        head = tail = list2;
                    }
                    else{
                        tail.next = list2;
                        tail = tail.next;
                    }
                    list2 = list2.next;
                }
            }
            //链表与数组合并不同， 直接连接指向即可
            tail.next = list1 != null ? list1 : list2;
            return head;
        }
    }
}
