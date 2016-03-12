public class SearchEngine{

	public InvertedPageIndex empty;
	public MyLinkedList<String> ss;
	
	public SearchEngine() {
		empty = new InvertedPageIndex();
		ss = new MyLinkedList<String>();
	}

	public void performAction(String actionMessage) {
		String z = actionMessage;
		String[] temp = z.split(" ");
		
		if(temp[0].equals("addPage")){
			String[] splited = z.split(" ");
			String id = splited[1];
			PageEntry nn = new PageEntry();	
			boolean flag = true;
			for(int k=0;k<ss.size();k++){
				if (ss.get(k).getData().equals(id)){
					flag = false;
					break;
				}
				else{
					flag = true;
				}
			}
			if (flag == true){
				nn.PageReader(id);
				ss.insertlast(id);
				empty.addPage(nn);
				System.out.println("The Page "+id+" has been added");
				System.out.println(" ");
			}
			else{
				System.out.println("This Page is already added");
				System.out.println(" ");
			}
		}
	
		
		else if(temp[0].equals("queryFindPagesWhichContainWord")){
			String[] splited = z.split(" ");
			String pages = splited[1];
			System.out.print("The following pages contains word "+pages+": " );
			empty.getPagesWhichContainWord(pages);
			System.out.println(" ");
			
		}
		
		else if(temp[0].equals("queryFindPositionsOfWordInAPage")){
			String[] splited = z.split(" ");
			String str = splited[1];
			String doc = splited[2];
			
			boolean flagg=false;
			for(int d=0;d<empty.myset.list.size();d++){
				if(empty.myset.list.get(d).getData().path.equals(str)){
					flagg = true;
					break;
				}
			}
			if (flagg = true){
				PageEntry xx = new PageEntry();
				xx.PageReader(doc);
				empty.addPage(xx);
				MyHashTable zs = new MyHashTable(100003);
				
				for(int zz=0;zz<xx.getPageIndex().getWordEntries().size();++zz){
					zs.addPositionsForWord(xx.getPageIndex().getWordEntries().get(zz).getData());
				}
				//zs.printHash();
				int mash = zs.hashfunction(str);
				HashEntry pgdex = new HashEntry();
				pgdex = zs.st[mash];
				if (pgdex== null){
					System.out.println("This word is not in webpage "+doc);
				}
				boolean flag = true;
				int s;
				for(s=0;s<pgdex.p_index.getWordEntries().size();++s){
					if(!pgdex.p_index.getWordEntries().get(s).getData().word.equals(str)){
						flag = false;//
					}
					else{
						flag = true;
						break;
					}
				}
				if (flag == true){
					//System.out.println("Bucky");
					//System.exit(0);
					//System.out.println(pgdex.p_index.getWordEntries().get(s).getData().positions.size());
					//System.out.println("Bucky");
					System.out.print(str+": ");
					for(int ss=0;ss<pgdex.p_index.getWordEntries().get(s).getData().positions.size();ss++){
						System.out.print(pgdex.p_index.getWordEntries().get(s).getData().positions.get(ss).getData().getWordIndex()+",");
						
					}
					System.out.println(" ");
				}
				else{
					System.out.println("The word "+str+" is not present in "+doc);
					System.out.println(" ");
				}
			}
		}
	}
}
