/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        // Step 1: Store parent of every node
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        buildParentMap(root, null, parent);

        // Step 2: BFS from target
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {

            // All nodes currently in queue
            // are at the same distance
            int size = queue.size();

            if (distance == k) {
                break;
            }

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                // Move left
                if (current.left != null &&
                    !visited.contains(current.left)) {

                    queue.offer(current.left);
                    visited.add(current.left);
                }

                // Move right
                if (current.right != null &&
                    !visited.contains(current.right)) {

                    queue.offer(current.right);
                    visited.add(current.right);
                }

                // Move to parent
                TreeNode par = parent.get(current);

                if (par != null &&
                    !visited.contains(par)) {

                    queue.offer(par);
                    visited.add(par);
                }
            }

            distance++;
        }

        // Step 3: All nodes remaining in queue
        // are exactly distance k from target
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;
    }


    private void buildParentMap(
        TreeNode node,
        TreeNode par,
        Map<TreeNode, TreeNode> parent
    ) {

        if (node == null) {
            return;
        }

        parent.put(node, par);

        buildParentMap(node.left, node, parent);
        buildParentMap(node.right, node, parent);
    }
}