package questions;

public class dfs690EmployeeImportance {
	public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Integer> map = new HashMap();
        Map<Integer, List<Integer>> graph = new HashMap();
        for(Employee employee : employees){
            map.put(employee.id, employee.importance);
            graph.put(employee.id, employee.subordinates);
        }
        Set<Integer> visited = new HashSet();
        Queue<Integer> q = new LinkedList();
        q.add(id);
        int ans = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(!visited.contains(cur)){
                ans += map.get(cur);
                visited.add(cur);
            }
            for(int next : graph.get(cur)){
                if(!visited.contains(next)){
                    q.offer(next);
                }
            }
        }
        return ans;
        
    }
}
