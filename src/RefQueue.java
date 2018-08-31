
public class RefQueue<T> {
	private Node<T> lastNode;
	public int size;
	
	public RefQueue(){
		lastNode = null;
	}
	
	public boolean isEmpty(){
		return lastNode == null;
	}
	
	public void dequeueAll(){
		lastNode = null;
		size = 0;
	}
	
	public  void enqueue(T newItem){
		Node<T> newNode = new Node<T>(newItem);
		if(isEmpty()){
			newNode.setNext(newNode);
			size++;
		}
		else{
			newNode.setNext(lastNode.getNext());
			lastNode.setNext(newNode);
			size++;
		}
		lastNode = newNode;
	}
	
	public T dequeue(){
		Node<T> newNode = lastNode.getNext();
		if(newNode == lastNode){
			lastNode = null;
		}
		else{
		lastNode.setNext(newNode.getNext());
		}
		return (T) newNode.getItem();
	}
	
	public T peek(){
		Node<T> newNode = lastNode.getNext();
		if(!isEmpty()){
			return (T) newNode.getItem();
		}
		return null;
	}
	
}
