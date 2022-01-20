package questions;

public class dfs652FindDuplicateSubtrees {
    Map<String, Integer> map = new HashMap();
    List<TreeNode> res = new ArrayList();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }
    
    public String dfs(TreeNode node){
        if(node == null) return "N";
        StringBuilder path = new StringBuilder();
        path.append(node.val).append(".");
        path.append(dfs(node.left)).append(".");
        path.append(dfs(node.right)).append(".");
        String str = path.toString();
        if(map.containsKey(str)){
            if(map.get(str) == 1){
                res.add(node);
                map.put(str, 2);
            }
        }else{
            map.put(str, 1);
        }
        return str;
    }
}
