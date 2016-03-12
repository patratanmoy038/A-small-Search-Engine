
public class Position {
	
	public PageEntry page;
	public int index;
	
	public Position(PageEntry p,int wordIndex){
		page = p;
		index = wordIndex;
	}
	
	public PageEntry getPageEntry(){
		return page;
	}
	
	public int getWordIndex(){
		return index;
	}
	
}
