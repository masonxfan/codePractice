package questions;

public class dfs99RecoverBinarySearchTree {
	 public void recoverTree(TreeNode root) {
	        List<Integer> res = new ArrayList();
	        dfs1(root, res);
	        int n = res.size();
	        int x = -1;
	        int y = -1;
	        boolean swapped_first_occurrence = false;
	        for(int i = 0; i < n - 1; ++i) {
	          if (res.get(i + 1) < res.get(i)) {
	            y = res.get(i + 1);
	            if (!swapped_first_occurrence) {
	                // first swap occurrence
	                x = res.get(i);
	                swapped_first_occurrence = true;
	            } else {
	                // second swap occurrence
	                break;
	            }
	          }
	        }
	        //System.out.println(x + " " + y);
	        dfs2(root, x, y);
	        
	    }
	    
	    public void dfs1(TreeNode node, List<Integer> res){
	        if(node == null) return;
	        if(node.left != null) dfs1(node.left, res);
	        res.add(node.val);
	        if(node.right != null) dfs1(node.right, res);
	    }
	    public void dfs2(TreeNode node,int small, int big){
	        if(node == null) return;
	        if(node.val == small) node.val = big;
	        else if(node.val == big) node.val = small;
	        if(node.left != null) dfs2(node.left, small, big);
	        if(node.right != null) dfs2(node.right, small, big);
	    }
}
