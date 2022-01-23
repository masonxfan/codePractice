package questions;

public class bfs117PopulatingNextRightPointersinEachNodeII {
	public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node former = null;
            for(int i = 0; i < size; i++){
                Node cur = q.poll();
                if(former != null) former.next = cur;
                former = cur;
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
        }
        return root;
    }
}
