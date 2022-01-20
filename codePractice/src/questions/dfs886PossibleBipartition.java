package questions;

public class dfs886PossibleBipartition {
	  public boolean possibleBipartition(int n, int[][] dislikes) {
	        int v[]=new int[n+1];
	        ArrayList<Integer>[] dls=new ArrayList[n+1];
	        for(int i=1;i<=n;i++){
	            dls[i]=new ArrayList();
	        }
	        for(int[] dl:dislikes){
	            dls[dl[0]].add(dl[1]);
	            dls[dl[1]].add(dl[0]);
	        }
	        for(int i=1;i<=n;i++){
	            if(v[i]==0){
	                if(!helper(dls,v,i,1)){
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	    
	    private boolean helper(ArrayList<Integer>[] dls,int v[], int i,int mark){
	        if(v[i]*mark==-1){
	            return false;
	        }
	        if(v[i]==mark){
	            return true;
	        }
	        if(v[i]==0){
	            v[i]=mark;
	        }
	        for(int a:dls[i]){
	            if(!helper(dls,v,a,-mark)){
	                return false;
	            }
	        }
	        return true;
	    }
}
