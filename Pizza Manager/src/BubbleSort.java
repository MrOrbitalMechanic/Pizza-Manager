/**
 * Class BubbleSort: A sorting Object that utilizes the BubbleSort algorithm for 
 * sorting comparable objects.
 * @author Roman Zhang
 *
 */
public class BubbleSort extends Sort{
		
	/**
	 * sort(): Iteratively sorts a list of comparable data using the Bubble Sort 
	 * algorithm.
	 */
	@Override
	public void sort(int[] data, int first, int last){
		while (first <= last){//While there are still unsorted elements to look at
			incrementComparisons();
			int counter = 0;//starting at index 0...
			while(counter < last){//while the list runner is in bounds,
				incrementComparisons();
				if (data[counter] <= data[counter+1]){//if the current element is less than or equal to the next element
					incrementComparisons();
					counter++;//Increment the counter, do not swap anything
				}else{//If the current element is greater than the next,
					incrementComparisons();
					this.swap(data, counter, counter+1);//Swap the two elements
					counter++;//Increment the pointer
				}
			}last--;//The largest element is now at the end of the list, decrement the last index as it is now sorted
		}
	}
	
	/**
	 * swap(): Swaps the positions of two elements in input array data.
	 */
	@Override
	public void swap(int[] data, int idx1, int idx2){
		int tempIdx1Data = data[idx1];
		data[idx1] = data[idx2];
		data[idx2] = tempIdx1Data;
	}
}
