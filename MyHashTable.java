public class MyHashTable{
	
	//PageEntry nn;
	public int hsize;
	public HashEntry st[];
	
	
	public MyHashTable(int hs){
		hsize = hs;
		//nn = new PageEntry();
		st = new HashEntry[hsize];
		for (int i=0;i < hsize;i++){
			st[i] = null;
		}
	}
	
	public int hashfunction(String str){
		//System.out.println(str);
		char[] x = str.toCharArray();
		int i = 0;
		int a = 0;
		int ans = 0;
		for(char c:x){
			a = c;
			ans += a*Math.pow(27,i); 
			i++;
		}
		//System.out.println(1);
		ans = ans%100003;
		return ans;
    }
	
	public void addPositionsForWord(WordEntry w){
		HashEntry entry = new HashEntry(); 
		int hash = this.hashfunction(w.word);
		if(hash > 0){
			if (st[hash]==null){
				st[hash] = entry;
				for(int a=0;a<w.getAllPositionsForThisWord().size();++a){
					entry.p_index.addPositionForWord(w.word,w.getAllPositionsForThisWord().get(a).getData());
				}
			}
   			else{
				entry = st[hash];
				for(int ii=0;ii<w.getAllPositionsForThisWord().size();++ii){
					entry.p_index.addPositionForWord(w.word,w.getAllPositionsForThisWord().get(ii).getData());
				}
			}
		}
	}
		
	public void printHash(){
		for(int i = 0;i<st.length;i++){
			if (st[i]==null){
				
			}else{
				st[i].p_index.printWordList();
				System.out.println("");
			}
		}
	}
}

