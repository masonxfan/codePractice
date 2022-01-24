package questions;

public class dfs129SumRoottoLeafNumbers {
	  int ans = 0;
	    public int sumNumbers(TreeNode root) {
	        dfs(root, 0);
	        return ans;
	    }
	    
	    public void dfs(TreeNode node, int num){
	        if(node == null) return;
	        num = num * 10 + node.val;
	        if(node.left == null && node.right == null){
	            ans += num;
	        }
	        if(node.left != null) dfs(node.left, num);
	        if(node.right != null) dfs(node.right, num);
	        
	    }
}
