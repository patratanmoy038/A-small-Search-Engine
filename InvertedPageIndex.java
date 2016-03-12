public class InvertedPageIndex{
	
	public MySet<PageEntry> myset;
	
	public MyHashTable htable;
	
	public InvertedPageIndex(){
		myset = new MySet<PageEntry>();
		htable = new MyHashTable(100003);
	}
	
	public void addPage(PageEntry p){
		for(int z=0;z<p.getPageIndex().getWordEntries().size();z++){
			htable.addPositionsForWord(p.getPageIndex().getWordEntries().get(z).getData());
			//System.out.print(p.getPageIndex().getWordEntries().get(z).getData().word+", ");
			
		}
		//System.out.println(" ");
		myset.addElement(p);
	}
	
	public MySet<PageEntry> getPagesWhichContainWord(String str){
		
		MySet<PageEntry> myset2 = new MySet<PageEntry>();
		int bash = htable.hashfunction(str);
		if(htable.st[bash]==null){
			System.out.println("No webpage contains word " +str);
		}
		else{
			HashEntry pdex = htable.st[bash];
			//System.out.println(htable.st[bash].p_index.wordlist.size());
			//System.out.println(htable.st[bash].p_index.wordlist.get(0).getData().positions.size());
			
			/*for(int s=0;s<pdex.p_index.getWordEntries().size();s++){
				for(int e=0;e<pdex.p_index.getWordEntries().get(s).getData().positions.size();e++){
					System.out.print(pdex.p_index.getWordEntries().get(s).getData().positions.get(e).getData().getPageEntry().path+","+pdex.p_index.getWordEntries().get(s).getData().positions.get(e).getData().getWordIndex()+", ");
				}
			}*/
			//System.exit(0);
			for(int s=0;s<pdex.p_index.getWordEntries().size();s++){
				if(pdex.p_index.getWordEntries().get(s).getData().word.equals(str)){
					for(int f=0;f<pdex.p_index.getWordEntries().get(s).getData().positions.size();f++){
						PageEntry pass = pdex.p_index.wordlist.get(s).getData().positions.get(f).getData().getPageEntry();
						if (myset2.list.size() == 0){
							myset2.addElement(pass);
						}
						else{
							int k=1;
							for(int ss=0;ss<myset2.list.size();ss++){
								if(myset2.list.get(ss).getData().path.equals(pass.path)){
									k = 0;
									break;
								}
								else{
									k = 1;
								}
							}
							if (k == 1){
								myset2.addElement(pass);
							}
						}
					}	
				}
			}
			String[][] nw = new String[myset2.list.size()][2];
			/*for(int zu =0; zu<myset2.list.size();zu++){
				for(int m=0;m<myset2.list.get(zu).getData().pindex.wordlist.size();m++){
					System.out.println(myset2.list.get(zu).getData().pindex.wordlist.get(m).getData().relevance);
				}
			}*/
			//System.exit(0);
			for(int zu =0; zu<myset2.list.size();zu++){
				for(int m=0;m<myset2.list.get(zu).getData().pindex.wordlist.size();m++){
					if (myset2.list.get(zu).getData().pindex.wordlist.get(m).getData().word.equals(str)){
						nw[zu][0]= myset2.list.get(zu).getData().path;
						nw[zu][1]= Double.toString(myset2.list.get(zu).getData().pindex.wordlist.get(m).getData().relevance);
					}
				}
			}
			for(int n=0;n<nw.length;n++){
				for (int d = 0; d < nw.length-1; d++) {
				        if (Double.parseDouble(nw[d][1]) < Double.parseDouble(nw[d+1][1])){
				          String swap = nw[d][1];
				          nw[d][1] = nw[d+1][1];
				          nw[d+1][1] = swap;
			        }
				}
			}for(int c=0;c<nw.length;c++){
				System.out.print(nw[c][0]+", "+nw[c][1]+", ");
			}
			
		}	return myset2;
	}
}
