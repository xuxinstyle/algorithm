package important;

import org.junit.jupiter.api.Test;

public class MaxDepth {
    @Test
    public void test() {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs(root.left, 2), dfs(root.right, 2));
    }

    private int dfs(TreeNode root, int i) {
        if (root == null) {
            return i - 1;
        }
        return Math.max(dfs(root.left, i + 1), dfs(root.right, i + 1));
    }
}
