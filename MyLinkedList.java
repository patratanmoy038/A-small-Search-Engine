
@SuppressWarnings("hiding")
public class MyLinkedList<Object> {

	public Node<Object> Head;
	public Node<Object> Tail;
	public int listcount;
		
	public MyLinkedList() {
		Head = null;
		Tail = null;
		listcount = 0;
		
	}
	
	public void insertfirst(Object a){
		Node<Object> temp = new Node<Object>(a);
		if (listcount == 0){
			Head = temp;
			Tail = temp;
			listcount++;
		}
		else{
			temp.setNext(Head);
			Head = temp;
			listcount++;
		}
	}
	
	
	public void insertlast(Object a){
		Node<Object> temp = new Node<Object>(a);
		if (listcount == 0){
			Head = temp;
			Tail = temp;
			listcount++;
		}
		else{
			Tail.setNext(temp);
			temp.setNext(null);
			Tail = temp;
			listcount++;
		}
	}
	
	public void insert(Object a, int n ){
		int i = 1;
		Node<Object> temp = new Node<Object>(a);
		Node<Object> temphead = Head;
		while (i < n){
			temphead = temphead.getNext();
			i++;
		}
		temp.setNext(temphead.getNext());
		temphead.setNext(temp);
		listcount++;
	}
	
	public Node<Object> get(int index){
		Node<Object> temp = Head;
		if (index < 0 || index > listcount){
			return null;
		}
		else{
			for (int i =0;i<index;i++){
				temp = temp.getNext();
	        	}
			return temp;
			}    
		}
	
	public boolean isContain(Object a){
		Node<Object> temp = Head;
		while(temp != null){
		if (temp.getData()==a){
			return true;
		}else
		{	
			temp=temp.getNext();
			}
		}return false;
	}
	
	public int size(){
		return listcount;
	}
	
	public boolean remove(int index){
        if (index < 1 || index > size())
            return false;
 
        Node<Object> temp = Head;
        for (int i = 1; i < index; i++) {
            if (temp.getNext() == null)
                return false;
 
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        listcount--; 
        return true;
    }
	
	public void remove(Object o){
		Node<Object> temp = Head;
		if (Head.getData() == o){
			Head = Head.getNext();
			temp = null;
		}else{
		for (int i = 1;i<listcount;i++){
			if (temp.getNext().getData() == o){
				temp.getNext().setNext(null);
				temp.setNext(temp.getNext().getNext());
				}
			}
		}
	}
}

@SuppressWarnings("hiding")
class Node<Object> {
	
	Node<Object> next;
	Object data;
	
	public Node(Object dataValue) {
        next = null;
        data = dataValue;
    }
	
	public Object getData(){
		return data;
	}
	
	public void setData(Object dataValue) {
        data = dataValue;
    }
	
	public Node<Object> getNext() {
        return next;
    }
	
	public void setNext(Node<Object> nextvalue){
		next = nextvalue;
		}
	}
