package questions;

public class arr2013DetectSquares {

int cord[][];
  public DetectSquares() {
    cord = new int[1001][1001];
}

public void add(int[] point) {
    cord[point[0]][point[1]]++;
}

public int count(int[] point) {
    
    //find cord with same x
    int x = point[0];
    int y = point[1];
    int count = 0;
    for(int i=0; i<=1000; i++)
    {
        if( cord[x][i] > 0 )
        {
            int length = Math.abs(y - i);
            
            if(length > 0)
            {
                if(x - length >= 0)
                {
                    count += cord[x-length][y] * cord[x-length][i] * cord[x][i];
                }
                
                if(x + length <= 1000)
                {
                    count += cord[x+length][y] * cord[x+length][i] * cord[x][i];
                }
            }
        }
    }
    
    return count;
}
}
