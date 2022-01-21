package questions;

public class dfs472ConcatenatedWords {
	class Solution {
	    public class Node{
	        Node[] children=new Node[26];
	        String s;
	    }
	    private Node root;
	    private HashSet<String> set;
	    public void insert(Node root,String word){
	        if(word.length()==0){
	            return;
	        }
	        for(int i=0;i<word.length();i++){
	            char ch=word.charAt(i);
	            if(root.children[ch-'a']==null){
	                root.children[ch-'a']=new Node();
	            }
	            root=root.children[ch-'a'];
	        }
	        root.s=word;
	    }
	    public void matchCharacters(Node p1,Node p2){
	        if(p1.s!=null && p2.s!=null){
	            set.add(p1.s);
	            return;
	        }
	        if(p2.s!=null){
	            matchCharacters(p1,root);
	        }
	        for(int i=0;i<26;i++){
	            if(p1.children[i]!=null && p2.children[i]!=null){
	                matchCharacters(p1.children[i],p2.children[i]);
	            }
	        }
	    }
	    public void dfsOnTrie(Node ptr){
	        if(ptr.s!=null){
	            matchCharacters(ptr,root);
	        }
	        for(int i=0;i<26;i++){
	            if(ptr.children[i]!=null){
	                dfsOnTrie(ptr.children[i]);
	            }
	        }
	    }
	    public List<String> findAllConcatenatedWordsInADict(String[] words) {
	        root=new Node();
	        set=new HashSet<>();
	        
	        for(String word:words){
	            insert(root,word);
	        }
	        
	        dfsOnTrie(root);
	        List<String> ans=new ArrayList<>(set);
	        return ans;
	    }
	}
}
