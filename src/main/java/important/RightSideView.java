package important;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public void testRightSideView() {

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> sideView = new ArrayList<>();
        if (root == null) {
            return sideView;
        }
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            sideView.add(node.val);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
            }
        }
        return sideView;
    }

    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> sideView = new ArrayList<>();
        if (root == null) {
            return sideView;
        }
        dfs(sideView, root, 0);
        return sideView;
    }

    private void dfs(List<Integer> sideView, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (sideView.size() == depth) {
            sideView.add(root.val);
        }
        dfs(sideView, root.right, depth + 1);
        dfs(sideView, root.left, depth + 1);
    }
}
