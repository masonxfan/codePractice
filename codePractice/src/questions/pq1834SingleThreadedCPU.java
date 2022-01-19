package questions;

public class pq1834SingleThreadedCPU {
	public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] taskidx = new int[n][3];
        PriorityQueue<int[]> taskpq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[1] == b[1] ? a[2] - b[2] : a[1] - b[1];
            }
        });
        for(int i = 0; i < n; i++){
            taskidx[i][0] = i;
            taskidx[i][1] = tasks[i][0];
            taskidx[i][2] = tasks[i][1];
            taskpq.add(taskidx[i]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[2] == b[2] ? a[0] - b[0] : a[2] - b[2] ;
            }
        });
        int[] ans = new int[n];
        int start = 0;
        int ansi = 0;
        int taski = 0;
        while(!taskpq.isEmpty() || !pq.isEmpty()){
            
            while(!taskpq.isEmpty() && taskpq.peek()[1] <= start){
                int[] cur = taskpq.poll();
                //System.out.println(cur[0]);
                pq.add(cur);
            }
            if(pq.isEmpty()){
                if(taskpq.isEmpty()) break;
                start = taskpq.peek()[1];
                continue;
            }
            int[] cur = pq.poll();
            ans[ansi++] = cur[0];
            start += cur[2];
        }


        return ans;
        
        
    }
}
