class Solution {

    int preIndex;
    HashMap<Integer, Integer> map;

    Node build(int[] pre, int[] preMirror, int l, int h) {

        if (preIndex >= pre.length || l > h)
            return null;

        Node root = new Node(pre[preIndex++]);

        // Leaf node
        if (l == h || preIndex >= pre.length)
            return root;

        int idx = map.get(pre[preIndex]);

        if (idx >= l && idx <= h) {
            root.left = build(pre, preMirror, idx, h);
            root.right = build(pre, preMirror, l + 1, idx - 1);
        }

        return root;
    }

    public Node constructBinaryTree(int[] pre, int[] preMirror) {

        preIndex = 0;
        map = new HashMap<>();

        for (int i = 0; i < preMirror.length; i++) {
            map.put(preMirror[i], i);
        }

        return build(pre, preMirror, 0, preMirror.length - 1);
    }
}
