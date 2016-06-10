/**
 * Class ArrayList: An array based data structure that doubles in size when capacity is reached -
 * therefore having theoretically infinite capacity (as much as memory will allow). Objects can be 
 * inserted at a specified index, or simply added to the end of the list. Objects at a specified 
 * index in the list can be removed. Objects can be added or removed from the ArrayList in an 
 * arbitrary order.
 * 
 * CLASS INVARIANTS: 
 * - There are never any null spaces left between two occupied spaces in the ArrayList.
 * - ArrayList doubles in size when capacity is reached.
 *  
 * @author Roman Zhang
 * 
 */
public class ArrayList<T> {

	private T[] list;
	private int numElements;
	private static final int DEFAULTSIZE = 4; //The size this ArrayList will be initialized to by default.
	
	/**
	 * Default Constructor ArrayList(): Initializes this ArrayList to the given default size.
	 */
	public ArrayList(){
		this.list = (T[]) new Object[DEFAULTSIZE];
		this.numElements = 0;
	}
	
	/**
	 * Constructor ArrayList(int size): Initializes this ArrayList to the parameter int size.
	 * If input size is less than one, initialize this ArrayList to default size.
	 * @param size: The length which this ArrayList will be set to.
	 */
	public ArrayList(int size){
		if(size < 1){
			System.out.println("Cannot set size to zero. Setting to default size: " + DEFAULTSIZE);
			this.list = (T[]) new Object[DEFAULTSIZE];
		}else{
			this.list = (T[]) new Object[size];
			this.numElements = 0;
		}
	}
	
	/**
	 * add(Object toAdd): Adds input Object toAdd to the end of this ArrayList.
	 * @param toAdd: The Object to be added to the end of this ArrayList.
	 */
	public void add(T toAdd){
		if(toAdd == null){
			throw new RuntimeException("Error: null Object passed - ArrayList method add()");
		}else{
			if(this.numElements >= this.list.length - 1){ //If capacity has been reached, resize the ArrayList
				this.resize();						  
				this.add(toAdd); //Once the ArrayList has increased in capacity, run this method again.
			}else{
				this.list[this.numElements] = toAdd;
				this.numElements++;
			}
		}
	}
	
	/**
	 * insert(Object toAdd, int index): Adds input Object toAdd to the specified index in this ArrayList.
	 * All objects at and beyond this specified index are shifted one space to the right. 
	 * @param toAdd: The Object to be added to this ArrayList at the specified index.
	 * @param index: The index of this ArrayList at which Object toAdd is to be inserted.
	 */
	public void insert(T toAdd, int index){
		if(toAdd == null){
			throw new RuntimeException("Error: null Object passed - ArrayList method insert()");
		}else{
			if(index >= 0){ //Input index cannot be less than 0 (Out of bounds)
				if(this.numElements >= this.list.length - 1){
					this.resize();
					this.insert(toAdd, index);
				}else{
					/*If the input index is ahead of the next available space in the ArrayList,
					 * simply add input Object toAdd to the end of the ArrayList.
					 */
					if(index >= this.numElements){ 
						this.list[numElements] = toAdd; 
						this.numElements++;
					}else{
						this.shiftRight(index);
						this.list[index] = toAdd;
						this.numElements++;
					}	
				}
			}else{throw new RuntimeException("Error: Invalid index (ArrayList method insert()");}
		}
	}
	
	/**
	 * shiftRight(int atIndex): Helper method for use in insert(); shifts
	 * all current Elements in this ArrayList one space to the "right" to 
	 * prepare the ArrayList for the insertion of an Object in insert(). 
	 * @param atIndex: The index in this ArrayList past which the existing
	 * 				   elements in this ArrayList are to be shifted over.
	 */
	private void shiftRight(int atIndex){
		for(int i = this.numElements; i > atIndex; i--){
			this.list[i] = this.list[i - 1];
		}
	}
	
	/**
	 * remove(int index): Removes the Object at the specified input index in this Arraylist.
	 * All Objects located to the right of this specified index, if there are any, are shifted
	 * back one space to the left, filling the null space left.
	 * @param index: The index of this ArrayList at which its object is removed.
	 * @return The Object that has been removed.
	 */
	public T remove(int index){
		//Input argument index cannot be outside the active size of this ArrayList.
		if(index >= 0 && index < this.numElements){
			if(!this.isEmpty()){
				Object returnObject = this.list[index];
				/*If there is only one element in this ArrayList, simply remove it*/
				if(this.numElements == 1){this.list[index] = null;} 
				else{ 	
					/*If there are multiple elements, replace each current element in this ArrayList with
					 * the element one space ahead of it, starting at the argument index - effectively removing
					 * the Object at the specified index and filling back in the space where it was removed.*/
					this.shiftLeft(index);
				}this.numElements--; return (T) returnObject;
			}else{
				throw new RuntimeException("ArrayList is empty");
			}
		}else{throw new RuntimeException("Invalid Index");}
	}
	
	/**
	 * shiftLeft(int atIndex): Helper method for use in remove(); Shifts
	 * all elements in this ArrayList past the given index atIndex one 
	 * space to the "left", effectively removing the Object at the index. 
	 * @param atIndex: The index of this ArrayList past which the existing
	 * 				   elements in this ArrayList are shifted.
	 */
	private void shiftLeft(int atIndex){
		for(int i = atIndex; i < this.numElements - 1; i++){
			this.list[i] = this.list[i+1];
		}
	}
	
	/**
	 * size(): The number of occupied spaces in this ArrayList.
	 * @return The number of elements currently occupying this ArrayList.
	 */
	public int size(){
		return this.numElements;
	}
	
	/**
	 * get(int index): Returns a reference to the object at the specified input index in this ArrayList.
	 * @param index: The index of this ArrayList at which its object is returned.
	 * @return The reference to the Object at the specified index.
	 */
	public T get(int index){
		if((index >= 0 && index < this.numElements) && !this.isEmpty()){
			return (T) this.list[index];
		}else{return null;}
	}
	
	/**
	 * isEmpty(): Determines whether or not there are no elements currently in this ArrayList.
	 * @return True if this ArrayList is empty.
	 * 		   False if this ArrayList has at least one item in it.
	 */
	public boolean isEmpty(){
		return this.numElements == 0;
	}
	
	/**
	 * indexOf(): Finds the index of the FIRST occurrence of the input Object toFind in this ArrayList.
	 * If toFind does not exist, return -1.
	 * @param toFind: The Object to be located in this ArrayList, if it exists.
	 * @return The int index of the first occurrence of toFind in this ArrayList.
	 * 		   -1 if the Object toFind does not exist in this ArrayList.
	 */
	public int indexOf(Object toFind){
		if(toFind == null){
			System.out.println("Error: null Object passed - ArrayList method indexOf()");
			return -1;
		}else{
			int indexCounter = 0;
			while(indexCounter < this.numElements){
				if(this.list[indexCounter].equals(toFind)){
					return indexCounter;
				}else{indexCounter++;}
			}return -1;
		}
	}
	
	/**
	 * toString(): A String representation of all of the Obejcts currently stored in this ArrayList.
	 */
	@Override
	public String toString(){
		String listString = "";
		for(Object element: this.list){
			if(element != null){
				listString += element.toString() + "\n";
			}else{break;}
		}return listString;
	}
	
	/**
	 * equals():
	 * @return True if this Array list and input Object other(if it is an instance of ArrayList)
	 *  		have the same size and Objects with the same value in the same order.
	 *  	   False if input Object other is not an instance of ArrayList OR the sizes are not equal
	 *  		OR the Objects contained are not equal and in similar order.
	 */
	@Override
	public boolean equals(Object other){
		if(other instanceof ArrayList && other != null && this.size() == ((ArrayList)other).size()){
			int arrayCounter = 0;
			while(arrayCounter < this.size()){
				if(this.list[arrayCounter].equals(((ArrayList)other).get(arrayCounter))){
					arrayCounter++;
				}else{return false;}
			}return true;
		}else{return false;}
	}
	
	/**
	 * Private method resize(): Helper method used in add() and insert() to double the size of this
	 * ArrayList when current capacity is reached. Copies all elements currently in this ArrayList
	 * to a new array that is double the size of the old array.
	 */
	private void resize(){
		T[] copyArray = (T[]) this.copyList();
		this.list = (T[]) new Object[copyArray.length * 2];
		for(int i = 0; i < copyArray.length; i++){
			this.list[i] = (T) copyArray[i];
		}
	}
	
	/**
	 * Private method copyList(): Helper method used in resize() to create a copy of 
	 * all Object elements in this ArrayList. 
	 * @return An Object[] clone of this current ArrayList's internal Object array.
	 */
	private Object[] copyList(){
		Object[] returnList = new Object[this.list.length];
		for(int i = 0; i < this.list.length; i++){
			returnList[i] = this.list[i];
		}return returnList;
	}
	
	/*
	private void swap(int idx1, int idx2){
		Pizza tempIdx1Data = new Pizza((Pizza) this.remove(idx1));
		//data.insert(new Pizza((Pizza) data.remove(idx2)), idx1);
		//data.insert(tempIdx1Data, idx2);
		//data.insert(new Pizza((Pizza) data.remove(idx1+1)), idx2);
		Pizza tempIdx2Data = new Pizza((Pizza) this.remove(idx2-1));
		this.insert((T) tempIdx2Data, idx1);
		this.insert((T) tempIdx1Data, idx2);
	}
	*/
}
