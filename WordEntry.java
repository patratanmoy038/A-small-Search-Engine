
public class WordEntry {
	
	public String word;
	public MyLinkedList<Position> positions;
	public double relevance;
	
	public WordEntry(String w){
		word = w;
		positions = new MyLinkedList<Position>();
		relevance = 0;
	}
	
	public void addPosition(Position p){
		positions.insertlast(p);
		relevance =relevance + (1/(((double)(p.getWordIndex()+1))*((double)(p.getWordIndex()+1))));
	}
	
	public void addPositions(MyLinkedList<Position> ps){
		for(int i=0;i<ps.size();i++){
			positions.insertlast(ps.get(i).getData());
			//relevance =relevance + (1/(((double)(p.getWordIndex()+1))*((double)(p.getWordIndex()+1))));
		}
	}
	
	public MyLinkedList<Position> getAllPositionsForThisWord(){
		return positions;
	}
	
	public void printWordPosition(){
		for(int i=0;i<positions.size();i++){
			System.out.print(positions.get(i).getData().getWordIndex()+" ,");
		}
	}
}
