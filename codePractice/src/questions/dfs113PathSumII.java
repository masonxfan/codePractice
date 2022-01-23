package questions;

public class dfs113PathSumII {
	  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
	        List<List<Integer>> res = new ArrayList();
	        List<Integer> comb = new ArrayList();
	        dfs(root, targetSum, comb, res);
	        return res;
	    }
	    
	    public void dfs(TreeNode node, int target, List<Integer> comb, List<List<Integer>> res){
	        if(node == null) return;
	        if(node.left == null && node.right == null && node.val == target){
	            comb.add(node.val);
	            res.add(new ArrayList(comb));
	            comb.remove(comb.size() - 1);
	            return;
	        }
	        comb.add(node.val);
	        if(node.left != null) dfs(node.left, target - node.val, comb, res);
	        if(node.right != null) dfs(node.right, target - node.val, comb, res);
	        comb.remove(comb.size() - 1);
	    }
}
