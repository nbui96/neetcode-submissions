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
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode result = new ListNode();
        ListNode dummy = result;

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            result.next = new ListNode(stack.pop());
            result = result.next;
        }

        return dummy.next;
    }
}
