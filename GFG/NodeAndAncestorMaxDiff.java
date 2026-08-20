class Solution {
    
    public int maxDiff(Node root) {
        int[] ans = {Integer.MIN_VALUE};
        findMin(root, ans);
        return ans[0];
    }

    private int findMin(Node node, int[] ans) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = findMin(node.left, ans);
        int rightMin = findMin(node.right, ans);

        // Current node is ancestor of nodes in left/right subtree
        if (leftMin != Integer.MAX_VALUE) {
            ans[0] = Math.max(ans[0], node.data - leftMin);
        }

        if (rightMin != Integer.MAX_VALUE) {
            ans[0] = Math.max(ans[0], node.data - rightMin);
        }

        // Return minimum value in current subtree
        return Math.min(node.data, Math.min(leftMin, rightMin));
    }
}
