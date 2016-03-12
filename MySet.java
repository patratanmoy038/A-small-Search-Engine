
public class MySet<T> {
	
	public MyLinkedList<T> list = new MyLinkedList<T>();
	
	public void addElement(T element){
		list.insertlast(element);
	}
	
	public MySet<T> Union(MySet<T> otherset){
		for (int i=0;i<list.size();i++){
			if(otherset.list.isContain(list.get(i).getData())==true){
				otherset.addElement(list.get(i).getData());
			}
			else{
				otherset.addElement(list.get(i).getData());
			}
		}return otherset;
	}
	
	public MySet<T> Intersection(MySet<T> otherset){
		for (int i=0;i<list.size();i++){
			if(otherset.list.isContain(list.get(i).getData())==true){
				otherset.addElement(list.get(i).getData());
			}
		}return otherset;
	}

}
