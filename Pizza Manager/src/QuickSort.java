/**
 * Class QuickSort: A sorting Object that utilizes the Quicksort algorithm for 
 * sorting comparable objects.
 * @author Roman Zhang
 *
 */
public class QuickSort extends BubbleSort{

	/**
	 * sort(): Recursively sorts a list of comparable Objects using the quicksort algorithm.
	 */
	@Override
	public void sort(int[] data, int first, int last){
		if (first < last){
			incrementComparisons();
			int pivot = data[last];
			int primaryPointer = last - 1; 
			int secondaryPointer = last - 1; //second reference pointer serving as a temporary element holder.

			while (primaryPointer >= first){//While the left pointer is in bounds
				incrementComparisons();
				if (data[primaryPointer] <= pivot){//if the pointer is less than pivot value
					incrementComparisons();
					primaryPointer--;// increment the second pointer
				}else{
					incrementComparisons();
					swap(data,primaryPointer,secondaryPointer);
					secondaryPointer--;
					primaryPointer--;
				}
			}
			swap(data, secondaryPointer + 1, last);
			sort(data, first, secondaryPointer);//sort the left partition
			sort(data, secondaryPointer + 2, last);//sort the right partition
		}else{
			incrementComparisons();
		}
	}
}