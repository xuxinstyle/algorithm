package important;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class ReverseKGroup {
    @Test
    public void test() {
        int[] a = new int[]{1, 2};
        ListNode head = new ListNode(a[0]);
        ListNode p = head;
        for (int i = 1; i < a.length; i++) {
            p.next = new ListNode(a[i]);
            p = p.next;
        }
        ListNode i = reverseKGroup(head, 2);
        while (i != null) {
            System.out.print(i.val + ",");
            i = i.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 1) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        ListNode nNode = null;
        ListNode np = null;
        ListNode lastNode = null;
        while (p != null) {
            if (stack.empty()) {
                lastNode = p;
            }
            stack.push(p);
            p = p.next;
            if (stack.size() >= k) {
                while (!stack.empty()) {
                    if (nNode == null) {
                        nNode = stack.pop();
                        np = nNode;
                        np.next = null;
                    } else {
                        np.next = stack.pop();
                        np = np.next;
                        np.next = null;
                    }
                }
            }
        }

        if (!stack.empty()) {
            if (nNode == null) {
                nNode = lastNode;
            } else {
                np.next = lastNode;
            }
        }
        return nNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
