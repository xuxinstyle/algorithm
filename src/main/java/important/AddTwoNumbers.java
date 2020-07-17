package important;

import org.junit.jupiter.api.Test;

public class AddTwoNumbers {
    @Test
    public void test() {
        int[] l1 = new int[]{2, 4, 3};
        int[] l2 = new int[]{5, 6, 4};
        ListNode head1 = new ListNode(l1[0]);
        ListNode head2 = new ListNode(l2[0]);
        ListNode p1 = head1;
        ListNode p2 = head2;
        for (int i = 1; i < l1.length; i++) {
            p1.next = new ListNode(l1[i]);
            p1 = p1.next;
        }
        for (int i = 1; i < l2.length; i++) {
            p2.next = new ListNode(l2[i]);
            p2 = p2.next;
        }
        ListNode listNode = addTwoNumbers(head1, head2);
        while (listNode != null) {
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int lastSum = 0;
        ListNode node = null;
        ListNode p = null;
        while (l1 != null || l2 != null || lastSum > 0) {
            if (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + lastSum;
                int model = sum % 10;
                lastSum = sum / 10;
                if (node == null) {
                    node = new ListNode(model);
                    p = node;
                } else {
                    p.next = new ListNode(model);
                    p = p.next;
                }
            } else if (l1 == null && l2 == null) {
                if (node == null) {
                    node = new ListNode(lastSum);
                    p = node;
                } else {
                    p.next = new ListNode(lastSum);
                    p = p.next;
                }
                lastSum = 0;
            } else {
                int to = l1 == null ? l2.val : l1.val;
                int sum = to + lastSum;
                int model = sum % 10;
                lastSum = sum / 10;
                if (node == null) {
                    node = new ListNode(model);
                    p = node;
                } else {
                    p.next = new ListNode(model);
                    p = p.next;
                }
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return node;
    }
}
