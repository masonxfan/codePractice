package questions;

public class sort833FindAndReplaceinString {
	   public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
	        
	        String result = "";
	        
	        int curIndex = 0;
	        List<Data> data = new ArrayList();
	        for(int i=0;i<indices.length;i++)
	        {
	            data.add(new Data(indices[i],sources[i],targets[i]));
	        }
	        
	        // sort all based on indicies
	        Collections.sort(data,(a,b) -> Integer.compare(a.index,b.index));
	        
	        for(Data d : data )
	        {
	            if(s.substring(d.index).startsWith(d.source))
	            {    
	                
	                if(curIndex!=d.index)
	                    result+= s.substring(curIndex,d.index); 
	                    
	                    result+=d.target;
	                
	                    curIndex = d.index + d.source.length();
	            }
	        }
	        
	        
	        result+= s.substring(curIndex); 
	        
	        return result;
	    }
	    class Data{
	        int index;
	        String source;
	        String target;
	        
	        Data(int index, String source,String target){
	            this.index = index;
	            this.source  = source;
	            this.target = target;
	        }
	    }
}
