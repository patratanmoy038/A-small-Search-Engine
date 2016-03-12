import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SuppressWarnings("unused")
public class PageEntry {
	
	public String path;
	public PageIndex pindex;
	
	
	/*public static void main(String args[]){
		PageEntry p = new PageEntry();
		p.PageReader("stack_datastructure_wiki");
		//p.getPageIndex().printWordList();
		//System.out.println(p.getPageIndex().wordlist.size());
	}*/
	
	public PageEntry(){
		pindex = new PageIndex();
	}
	
	public void PageReader(String pageName){
		path = pageName;
		try{
			//System.out.println("haan");
			
			//Path wiki_path = Paths.get("C:\\Users\\Tanmoy\\Documents\\Workspace\\Search Engine\\src\\webpages",path);
			//System.out.println(path);
			String content = new String(Files.readAllBytes(Paths.get(path)));
			content = content.toLowerCase();
			
			
			String[] delims = {"{","}","[","]","<",">","=","(",")",".",",",";","'","?","#","!","-",":","\"","\n"};
			String[] remstopwords = {"a", "an", "the", "they", "these", "this", "for", "is","are", "was", "of", "or", "and", "does", "will", "whose"};
			String[] spmap = {"stacks", "structures","applictions"};
		
			
			for(int i = 0; i < delims.length; i++){
				content = content.replace(delims[i]," ");
			}
			
			/*for(int n=0;n<remstopwords.length;n++){
				content = content.replace(remstopwords[n]," ");
			}*/
			
			content = content.replace("  "," ");
			content = content.replace("  "," ");
			
			for(int k=0;k<spmap.length; k++){
				content = content.replace(spmap[k],spmap[k].substring(0,(spmap[k].length()-1)));
			}
			
			String[] words = content.split(" ");
			
			//System.out.println(words.length);
			
			for (int m=0;m<words.length;m++){
				Position new_posi = new Position(this,m);
				//System.out.println(new_posi.getWordIndex());
				//System.out.println(new_posi.getPageEntry().path);
				boolean flag = true;
				//System.out.println(words[m]);
				for(int n=0;n<remstopwords.length;n++){
					if(words[m].equals(remstopwords[n])){
						flag = false;
						break;
					}
				}
				
				if(flag == true){
					this.pindex.addPositionForWord(words[m],new_posi);
				}
			}
			/*for (int j=0; j<this.pindex.wordlist.size();j++){
			System.out.println(this.pindex.wordlist.get(j).getData().word+", "+this.pindex.wordlist.get(j).getData().relevance);
			}*/
		}
		
		
		
		catch(java.io.IOException e)
        {
            System.out.println("Error while reading file : "+e.toString());
        }	
	}
	
	public PageIndex getPageIndex(){
		return pindex;
	}
}
