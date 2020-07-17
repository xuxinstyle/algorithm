package important;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public void testPathSum() {

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();
        dfs(root, sum, list, sumList);
        return list;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> list, List<Integer> sumList) {
        if (root == null) {
            return;
        }

        if (root.val == sum && root.left == null && root.right == null) {
            sumList.add(root.val);
            list.add(new ArrayList<>(sumList));
            sumList.remove(sumList.remove(sumList.size() - 1));
            return;
        }
        sumList.add(root.val);
        sum -= root.val;
        List<Integer> slist = new ArrayList<>(sumList);
        dfs(root.left, sum, list, slist);
        dfs(root.right, sum, list, slist);
    }
}
