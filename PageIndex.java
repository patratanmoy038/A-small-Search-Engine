
public class PageIndex {
	
	public MyLinkedList<WordEntry> wordlist;
	
	public PageIndex(){
		wordlist = new MyLinkedList<WordEntry>();
	}
	
	public int id;
	
	public void addPositionForWord(String str, Position p){
		
		if (wordlist.size() == 0){
			WordEntry nn = new WordEntry(str);
			wordlist.insertlast(nn);
			wordlist.get(0).getData().addPosition(p);
			
		}
		else{
			boolean br = false;
			for(int i=0;i<wordlist.size();i++){
				if ((wordlist.get(i).getData().word).equals(str)){
					wordlist.get(i).getData().addPosition(p);
					br=true;
					break;
				}
			}
			if(br==false){
					WordEntry nword = new WordEntry(str);
					nword.addPosition(p);
					wordlist.insertlast(nword);
			}
		}
	}
	
	public MyLinkedList<WordEntry> getWordEntries(){
		return wordlist;
	}
	public void printWordList(){
		
		for(int i=0;i<wordlist.size();i++){
			System.out.print(wordlist.get(i).getData().word+" , ");
			//System.out.println(wordlist.get(i).getData().printWordPosition());
			wordlist.get(i).getData().printWordPosition();
			System.out.println("");
		}
	}
}
