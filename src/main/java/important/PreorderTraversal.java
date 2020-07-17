package important;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        dfs(list, root.left);
        dfs(list, root.right);
        return list;
    }

    private void dfs(List<Integer> list, TreeNode left) {
        if (left == null) {
            return;
        }
        list.add(left.val);
        dfs(list, left.left);
        dfs(list, left.right);
    }
}
