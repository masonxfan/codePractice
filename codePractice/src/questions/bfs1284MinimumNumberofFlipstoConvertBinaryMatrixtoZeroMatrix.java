package questions;

public class bfs1284MinimumNumberofFlipstoConvertBinaryMatrixtoZeroMatrix {
    int m, n;
    public int minFlips(int[][] mat) {
        Set<String> set = new HashSet();
        m = mat.length;
        n = mat[0].length;
        Queue<int[][]> q = new LinkedList();
        q.add(mat);
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[][] cur = q.poll();
                String key = "";
                for(int x = 0; x < m; x++){
                    for(int y = 0; y < n; y++){
                        key += cur[x][y];
                    }
                }
                if(isTarget(cur)) return step;
                if(set.contains(key)) continue;
                set.add(key);
                for(int x = 0; x < m; x++){
                    for(int y = 0; y < n; y++){
                        q.add(flip(cur, x, y));
                    }
                }
            }
            step++;
        }
        return -1;
    }
    
    public boolean isTarget(int[][] mat){
        int sum = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                sum += mat[i][j];
            }
        }
        return sum == 0;
    }
    
    public int[][] flip(int[][] cur, int x, int y){
        int[][] ans = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(Math.abs(i - x) + Math.abs(j - y) <= 1){
                    ans[i][j] = 1^cur[i][j];
                }else{
                    ans[i][j] = cur[i][j];
                }
            }
        }
        return ans;
    }
}
