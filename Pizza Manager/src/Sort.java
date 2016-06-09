import java.util.Arrays;
/*
 * Sort Class - abstract parent class which defines the minimum requirements
 * to be a sort.  Subclasses must inherit from and implement the abstract methods below. 
 * Look in the main driver for example usage for your sorts.  Start by building a 
 * Bubble Sort, and comment out other Quick Sort code below to test your
 * first sort class independently before moving on to the more complex
 * Quick Sort subclass.
 * 
 * Author: Rob Nash
 * 
 */

public abstract class Sort {
	
	//TODO: you override this method with a concrete (ie, not abstract) sort mechanism
	public abstract void sort(ArrayList<Pizza> data, int first, int last);  //[first,...,last]
	
	//TODO: override this method with a concrete (ie, not abstract) swap mechanism
	public abstract void swap(ArrayList<Pizza> data, int idx1, int idx2);
	
	public static void main(String[] args) {
		/* Choose your data set below */
		//int[] input2 = {1,5,2,4,3,6,9,7,8,2};
		//int[] input3 = {13,1,60,59,52,23,31};		
		int[] input = {3,1,5,18,23,25,4,14,16,18,4,7,21,5};
		int[] input2 = {3,1,5,18,23,25,4,14};
		int[] input3 = {3,1,5,18,23,25,4,14};
		int[] input4 = {5,1};
		int[] input5 = {9,8,7,6,5,4,3,2,1};
		int[] input6 = {9,8,7,6,5,4,3,2,1};
		
		/* add or comment/uncomment your sort below */
		//displaySortResults(new QuickSort(), input5);
		//displaySortResults(new BubbleSort(), input6);
		//displaySortResults(new SelectionSort(), input3);
		
	}
	
	/*
	public static void displaySortResults(Sort sorter, int[] data) {
		sorter.resetComparisons();

		System.out.println(Arrays.toString(data));
		
		sorter.sort(data, 0, data.length-1);
				
		System.out.println(Arrays.toString(data));
		System.out.print(sorter.getClass().toString());
		System.out.println(",Comparisons: " + sorter.getComparisons()+"\n\n");
	}
	*/
	//Don't make changes to the code below.  What does the final modifier do?
	private int comparisons=0;
	
	public final int getComparisons() {
		return comparisons;
	}
	public final void resetComparisons() {
		comparisons = 0;
	}
	public final void incrementComparisons() {
		comparisons++;
	}
}