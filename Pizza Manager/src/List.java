/**
 * Class List: A linked list data structure using internal Nodes instead
 * of Arrays to store and organize data. 
 * @author Roman Zhang
 *
 */
public class List {

	public static void main(String[] args){
		List listOne = new List();
		
		
		listOne.recInsert('t', 0);
		//listOne.insert('s', );
		
		
		//listOne.insert('s', 50);
		/*
		for(int i = 0; i < 50; i++){
			listOne.insert(i, i);
		}
		*/
		/*
		for(int i = 50; i > 0; i--){
			listOne.insert(i, 0);
		}
		*/
		/*
		for(int i = 1; i <= 50; i++){
			listOne.insert(i, 0);
		}
		*/
		//System.out.println(listOne.size());
		//System.out.println(listOne);
		//System.out.println(listOne.get(0));
		//System.out.println(listOne.indexOf('R'));
		//listOne.remove(1);
		//listOne.remove(2);
		/*
		for(int i = 49; i >= 0; i--){
			System.out.println(listOne.remove(i));
		}
		*/
		/*
		while(!listOne.isEmpty()){
			listOne.remove(0);
		}
		*/
		System.out.println(listOne.size());
		System.out.println(listOne);
	}
	
	private Node head = null; //The start of the linked list
	/**
	 * Private Nested Class Node: Small container class whose only 
	 * purpose is to store a data Object and a reference to the next
	 * Node in the List sequence. 
	 * 
	 * @author Roman Zhang
	 */
	private class Node{
		Object data; //The Object data contained in this Node
		Node next; //The node referenced to by this Node.
		public Node(Object inData, Node nextNode){
			data = inData;
			next = nextNode;
		}
	}
	
	/**
	 * insert(): Links a Node (containing argument Object next and a 
	 * reference to the Node previously located at the argument index) to
	 * the Node that pointed to the Node at the current index. Effectively 
	 * inserts argument Object next at the argument index, moving the Object
	 * previously at the index to the "right" in this List. 
	 * @param next: The Object to be added to the specified index in 
	 * 				this List.
	 * @param index: This position in this List at which the Object next
	 * 				 is to be added.
	 */
	public void insert(Object next, int index){
		if(next == null)throw new LinkedListException("Invalid Index"); //Check for null Object input
		if(index > this.size())throw new LinkedListException("Null Object");	//Check for invalid index
		if (this.isEmpty()){ //If this List is empty
				/*Assign a new Node with input Object next and a
				 *null reference to this List's head.*/
				this.head = new Node(next,null); 
		}else{
			if(index == 0){ //Inserting at the head
				Node previousHead = this.head;
				this.head = new Node(next,previousHead);
			}else if(index == 1){ //Inserting at the head's next node
				Node previousHeadNext = this.head.next;
				this.head.next = new Node(next,previousHeadNext); 
			}else if(index == this.size()){ //Inserting at the "tail"
				this.getNodeAt(index-1).next = new Node(next,null);
			}else{
				Node nodeAtIndex = this.getNodeAt(index,this.head);
				this.getNodeAt(index-1).next = new Node(next,nodeAtIndex);
			}
		}
	}
	
	public void recInsert (Object thing, int index) {
		if( index > 0 && index < this.size()){
			head = recInsert(thing,head,index);
		}else{/*Error*/}
	}
	
	private Node recInsert (Object input , Node current ,int index){
		if(index == 0){
			Node previousCurrent = current;
			current = new Node(input ,previousCurrent);
			return current;
		}
		else{
			Node previousNext = current.next;
			current.next = recInsert(input , previousNext, index-1); 
			return current;
		}
	}
	
	/**
	 * get():
	 * @param index: The index in this List at which to find the Object
	 * @return The OBJECT contained in the node at this input index
	 */
	public Object get(int index){
		return this.getNodeAt(index).data;
	}
	
	/**
	 * indexOf():
	 * @param inObject
	 * @return An integer representing the position in this List at which
	 * 			argument Object inObject is found.
	 * 		   -1 if inObject does not exist in this List.
	 */
	public int indexOf(Object inObject){
		if(inObject == null) throw new LinkedListException("Null Object");
		Node current = this.head;
		int listCounter = 0;
		while(current != null){
			if (current.data.equals(inObject)){return listCounter;}
			else{
				listCounter++;
				current = current.next;
			}
		}return -1;
		
	}
	
	
	/**
	 * PRIVATE method getNodeAt(): Private helper method used to get
	 * the reference at the specified index. This method exists
	 * solely as an easy to invoke version of the recursive 
	 * getNodeAt(index,Node current) - That is to say that 
	 * getNodeAt(index,Node current) executes the desired function
	 * completely on its own, but the developer would need to specify: 
	 * getNodeAt(index, this.head) at every invocation of the method;
	 * it is assumed that Node current must start at the head.
	 * Therefore, this method getNodeAt() does not need to exist, it
	 * just serves as a more straightforward application of this 
	 * function for the developer.
	 * 
	 * @param index: The position in this List at which the Node 
	 * is to be returned.
	 * @return The node located at the specified index.
	 */
	private Node getNodeAt(int index){
		return this.getNodeAt(index,this.head);
	}
	
	/**
	 * PRIVATE method getNodeAt(): Recursively traverses each Node of 
	 * this List starting at the head to find the Node at the 
	 * specified index.
	 * METHOD INVARIANT:
	 * 	BEFORE this method is invoked, the validity of the input index
	 * 	is to have been checked.
	 * @param index
	 * @param current: The currently pointed Node in the List
	 * @return The Node located at the specified index of this List.
	 */
	private Node getNodeAt(int index,Node current){
		if(index > 0){
			return getNodeAt(--index,current.next);
		}else{
			return current;
		}
	}

	/**
	 * remove(): Links the Node before the indexed Node to the Node 
	 * formerly linked to the indexed node; removes the 
	 * only reference to the indexed node,effectively removing it 
	 * from the List.
	 * @param index
	 * @return The Object removed from this List
	 */
	public Object remove(int index){
		if(!this.isEmpty()){ //Check if list is empty.
			if(index < this.size()){ //Check for null Object input
				Object returnObject = this.get(index); //The removed Object
				if(index == 0){ //When removing the Node at the head
					Node newHead = this.head.next;
					this.head = newHead;
				}else if(index == 1){//When removing the head's next Node
					Node newHeadNext = this.getNodeAt(index+1);
					this.head.next = newHeadNext;
				}else if(index == this.size()-1){// When removing the "tail"
					this.getNodeAt(index-1).next = null;
				}else{
					this.getNodeAt(index-1).next = this.getNodeAt(index+1);
				}return returnObject;
			}else{
				throw new LinkedListException("Invalid Index");
			}
		}else{
			throw new LinkedListException("List is Empty");
		}
	}
	
	public Object recRemove(int index){
		Object retObj = this.get(index);
		this.head = recRemove(index, this.head);
		return retObj;
	}
	
	private Node recRemove(int index, Node current){
		if (index > 0){
			current.next = recRemove(index - 1, current.next);
		}else{
			current = current.next;
		}return current;
	}
	/**
	 * size(): Invokes the recursive size() method which counts
	 * the number of Nodes (Objects) currently in this List.
	 * @return The number of Objects currently stored in this List.
	 */
	public int size(){
		return this.size(this.head);
	}
	
	/**
	 * PRIVATE method size():
	 * @param nextNode
	 * @return The number of Nodes (Objects) currently stored
	 * 			in this List
	 */
	private int size(Node nextNode){
		if(nextNode != null){
			return 1 + size(nextNode.next);
		}else{return 0;}
	}
	
	/**
	 * toString(): Returns a String representation of this List 
	 * separated by line.
	 */
	@Override
	public String toString(){
		Node current = this.head;
		String retVal = "";
		while(current != null){
			retVal += current.data + "\n";
			current = current.next;
		}
		return retVal;
	}

	/**
	 * isEmpty():
	 * @return True if the head of this List is null (no objects)
	 * 			False if at least the head holds a Node.
	 */
	public boolean isEmpty(){
		return this.head == null;
	}
}
