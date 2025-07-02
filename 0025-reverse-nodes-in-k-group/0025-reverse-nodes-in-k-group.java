/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return null;

        ListNode temp = head;
        int count = 0;

        while(temp!=null && count<k) {
            temp = temp.next;
            count++;
        }

        if(count<k) return head;

        count = 0;
        ListNode prev = null;
        ListNode nextP = null;
        ListNode curr = head;

        while(curr != null && count <k) {
            nextP = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextP;
            count++;
        }
        if(nextP != null) {
            head.next = reverseKGroup(curr, k);
        }
        return prev;
    }
}