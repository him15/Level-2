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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        
        List<Integer> list = new ArrayList<>();
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size() > 0){
            int size = q.size();
            while(size> 0){
                TreeNode rem = q.remove();
                if(size == 1){   // if one element is left in that queue then it's the right element of that level
                    
                    list.add(rem.val);   // addding that element into arraylist
                }
                
                // pushing left elemtnt 1st in that queue when we are popping that elemtns then it left out 1 elemnt of that level and that the right most elemnt
                if(rem.left != null)
                    q.add(rem.left);
                
                if(rem.right != null)
                    q.add(rem.right);
                size--;
            }
        }
        return list;
    }
}
