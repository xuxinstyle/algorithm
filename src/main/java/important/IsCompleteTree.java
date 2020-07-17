package important;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class IsCompleteTree {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode p = root;
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
//        p.left.left = new TreeNode(4);
//        p.left.right = new TreeNode(5);
//        p.right.left = new TreeNode(6);
        boolean completeTree = isCompleteTree(root);
        System.out.println(completeTree);
    }

    public boolean isCompleteTree(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while (!queue.isEmpty()) {
            boolean flag = false;
            boolean haveNull = false;
            int i1 = (int) Math.pow(2, depth);
            int n = queue.size();
            if (i1 != n) {
                flag = true;
            }
            for (int i = 0; i < n; i++) {
                TreeNode poll = queue.poll();
                if (poll.right != null && poll.left == null) {
                    return false;
                }

                if (poll.left != null) {
                    if (haveNull) {
                        return false;
                    }
                    queue.add(poll.left);
                } else {
                    haveNull = true;
                }
                if (poll.right != null) {
                    if (haveNull) {
                        return false;
                    }
                    queue.add(poll.right);
                } else {
                    haveNull = true;
                }
            }
            if (queue.size() > 0 && flag) {
                return false;
            }
            depth++;
        }
        return true;
    }
}
