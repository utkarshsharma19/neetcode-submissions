/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    static String SEP = ",";
StringBuilder sb;
    // Encodes a tree to a single string.
       public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializePre(root, sb);
        // remove trailing comma if you want (optional)
        return sb.toString();
    }

    private void serializePre(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("NULL").append(SEP);
            return;
        }
        sb.append(node.val).append(SEP);
        serializePre(node.left, sb);
        serializePre(node.right, sb);
    }


    public TreeNode deserialize(String data) {
        // handle edge cases
        if (data == null || data.isEmpty()) return null;

        String[] tokens = data.split(SEP);
        // use a moving index wrapped in an int[1] or a Queue
        int[] idx = new int[]{0};
        return build(tokens, idx);
    }

    private TreeNode build(String[] tokens, int[] idx) {
        if (idx[0] >= tokens.length) return null; // safety

        String t = tokens[idx[0]++];
        if (t.equals("NULL") || t.length() == 0) return null;

        int val = Integer.parseInt(t);
        TreeNode node = new TreeNode(val);
        node.left = build(tokens, idx);
        node.right = build(tokens, idx);
        return node;
    }
//could not figure out what to do and why It would fail with i?
}
