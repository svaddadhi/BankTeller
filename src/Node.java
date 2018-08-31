
public class Node<T> {
	private T item;
	private Node<T> next;
	
	//constructor
	public Node(T newItem){
		item = newItem;
		next = null;
	}
	
	//constructor
	public Node(T newItem, Node<T> nextNode){
		item = newItem;
		next = nextNode;
	}
	
	
	public void setItem(T newItem){
		item = newItem;
	}
	
	public Object getItem(){
		return item;
	}
	
	public void setNext(Node<T> nextNode){
		next = nextNode;
	}
	public Node<T> getNext(){
		return next;
	}
}
