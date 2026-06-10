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
    public int getDecimalValue(ListNode head) {
        StringBuilder binary=new StringBuilder();
        ListNode temp = head;
        while(temp!=null){
            binary.append(temp.val);
            temp = temp.next;
        }
        int result = Integer.parseInt(binary.toString(), 2); 
        return result;
    }
}