class Solution {

    private boolean findPath(Node root, int target, StringBuilder path) {
        if (root == null)
            return false;

        if (root.data == target)
            return true;

        if (root.left != null) {
            path.append('L');

            if (findPath(root.left, target, path))
                return true;

            path.deleteCharAt(path.length() - 1);
        }

        if (root.right != null) {
            path.append('R');

            if (findPath(root.right, target, path))
                return true;

            path.deleteCharAt(path.length() - 1);
        }

        return false;
    }

    public int numberOfTurns(Node root, int p, int q) {

        StringBuilder pathP = new StringBuilder();
        StringBuilder pathQ = new StringBuilder();

        if (!findPath(root, p, pathP) ||
            !findPath(root, q, pathQ)) {
            return -1;
        }

        // Find common path (LCA)
        int i = 0;

        while (i < pathP.length() &&
               i < pathQ.length() &&
               pathP.charAt(i) == pathQ.charAt(i)) {
            i++;
        }

        int turns = 0;

        /*
         * p -> LCA
         *
         * Reverse pathP because we are travelling
         * from p towards LCA.
         */
        StringBuilder first = new StringBuilder();

        for (int j = pathP.length() - 1; j >= i; j--) {
            first.append(pathP.charAt(j));
        }

        /*
         * LCA -> q
         */
        for (int j = i; j < pathQ.length(); j++) {
            first.append(pathQ.charAt(j));
        }

        // Count direction changes
        for (int j = 1; j < first.length(); j++) {
            if (first.charAt(j) != first.charAt(j - 1)) {
                turns++;
            }
        }

        /*
         * If there is no turn, answer is -1.
         */
        return turns == 0 ? -1 : turns;
    }
}
