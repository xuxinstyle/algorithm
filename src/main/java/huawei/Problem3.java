package huawei;

import java.util.ArrayDeque;
import java.util.Scanner;


/**
 * @Author：xuxin
 * @Date: 2020/8/20 18:49
 */
public class Problem3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] split = str.split(" ");
        String lastBfs = split[0];
        String midBfs = split[1];
        TreeNode treeNode = buildTree(lastBfs, midBfs);

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.leftNode != null) {
                queue.add(poll.leftNode);
            }
            if (poll.rightNode != null) {
                queue.add(poll.rightNode);
            }
            System.out.print(poll.value);
        }

    }

    private static TreeNode buildTree(String lastBfs, String midBfs) {
        if (lastBfs == null || midBfs == null) {
            return null;
        }
        if (lastBfs.equals("") || midBfs.equals("")) {
            return null;
        }
        char rootValue = lastBfs.charAt(lastBfs.length() - 1);
        TreeNode root = new TreeNode(rootValue);
        char[] midChars = midBfs.toCharArray();
        int rootIndex = 0;
        for (int i = 0; i < midChars.length; i++) {
            if (midChars[i] == rootValue) {
                rootIndex = i;
            }
        }
        root.leftNode = buildTree(lastBfs.substring(0, rootIndex), midBfs.substring(0, rootIndex));
        root.rightNode = buildTree(lastBfs.substring(rootIndex, lastBfs.length() - 1), midBfs.substring(rootIndex + 1, midBfs.length()));
        return root;
    }

    static class TreeNode {
        TreeNode leftNode;
        TreeNode rightNode;
        char value;

        public TreeNode(char value) {
            this.value = value;
        }
    }
}
