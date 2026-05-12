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
    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode temp = head;
        int len = 0;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int part = len / k;
        int extra = len % k;

        List<List<ListNode>> list = new ArrayList<>();
        temp = head;
        while (temp != null) {
            int currPartSize = part + (extra > 0 ? 1 : 0);
            List<ListNode> curr = new ArrayList<>();

            while (currPartSize > 0 && temp != null) {
                curr.add(temp);
                temp = temp.next;
                currPartSize--;
            }
            list.add(curr);
            if (extra > 0)
                extra--;
        }

        //list to ans array:
        ListNode[] ans = new ListNode[k];

        for (int i = 0; i < list.size(); i++) {

            List<ListNode> curr = list.get(i);

            ans[i] = curr.get(0);

            for (int j = 0; j < curr.size() - 1; j++) {
                curr.get(j).next = curr.get(j + 1);
            }

            curr.get(curr.size() - 1).next = null;
        }

        return ans;

    }
}