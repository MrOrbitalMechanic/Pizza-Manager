/**
 * Class Stack: A linked Stack data structure using internal Nodes 
 * instead of Arrays to store and organize data. 
 * @author Roman Zhang
 *
 */
public class Stack extends List{

	public static void main(String[] args){
		Stack stackOne = new Stack();
		
		stackOne.push('G');
		stackOne.push('o');
		stackOne.push('d');
		stackOne.insert('s', 1231414);
		System.out.println(stackOne.size());
		System.out.println(stackOne);
		while(!stackOne.isEmpty()){
			System.out.println(stackOne.pop());
		}
		System.out.println(stackOne.size());
		System.out.println(stackOne);
		//stackOne.pop();
	}
	
	/**
	 * insert(): Invokes push().
	 */
	@Override
	public void insert(Object next, int index){this.push(next);}
	
	/**
	 * push(): Inserts input Object next at the "end" this Stack.
	 * @param next: The Object to be added to this Stack.
	 */
	public void push(Object next){
		super.insert(next,this.size());
	}
	
	/**
	 * remove(): Invokes pop().
	 */
	@Override
	public Object remove(int index){return this.pop();}
	
	/**
	 * pop(): Removes the Object at the tail of this Stack.
	 * @return The removed Object
	 */
	public Object pop(){
		return super.remove(this.size()-1);
	}
}
