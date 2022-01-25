package questions;

public class dfs987VerticalOrderTraversalofaBinaryTree {
	 //v[0] = col
    //v[1] = level
    //v[2] = node.val
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
        @Override
        public int compare(int[] a, int[] b){
            return a[0] != b[0] ? a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2];
        }
    });
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> res = new ArrayList();
        int temp = pq.peek()[0];
        List<Integer> list = new ArrayList();
        while(!pq.isEmpty()){            
            int[] cur = pq.poll();
            int col = cur[0];
            int level = cur[1];
            int nodeval = cur[2];
            if(temp < col){
                res.add(new ArrayList(list));
                list = new ArrayList();
                temp = col;
            }
            list.add(nodeval);
        }
        if(list.size() != 0) res.add(list);
        return res;
    }
    
    public void dfs(TreeNode node, int level, int col){
        if(node == null) return;
        int[] cur = new int[] {col, level, node.val};
        pq.add(cur);
        if(node.left != null) dfs(node.left, level + 1, col - 1);
        if(node.right != null) dfs(node.right, level + 1, col + 1);
    }
}
