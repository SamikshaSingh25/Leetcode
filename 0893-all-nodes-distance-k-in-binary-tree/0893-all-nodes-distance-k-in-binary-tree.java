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
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, TreeNode> mp = new HashMap<>();
        buildmap(mp, root, null); //(map,children, parent)
        Set<TreeNode> visited = new HashSet<>();
        dfs(res, mp, target, k, visited);
        return res;
    }

    public void dfs(List<Integer> res, Map<TreeNode, TreeNode> mp, TreeNode target, int k, Set<TreeNode> visited){
        
        if(target==null || visited.contains(target)){
            return;
        }
        visited.add(target);
        if(k==0){
            res.add(target.val);
            return;
        }

        dfs(res, mp, target.left, k-1, visited);
        dfs(res, mp, target.right, k-1, visited);
        dfs(res, mp, mp.get(target), k-1, visited);
    }

    public void buildmap(Map<TreeNode, TreeNode> mp, TreeNode child, TreeNode parent)
    {
        if(child==null) return;
        mp.put(child, parent);
        buildmap(mp, child.left, child);
        buildmap(mp, child.right, child);
    }
}