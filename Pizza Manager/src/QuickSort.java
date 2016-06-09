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
	public void sort(ArrayList<Pizza> data, int first, int last){
		if (first < last){
			incrementComparisons();
			Pizza pivot = data.get(last);
			int primaryPointer = last - 1; 
			int secondaryPointer = last - 1; //second reference pointer serving as a temporary element holder.

			while (primaryPointer >= first){//While the left pointer is in bounds
				incrementComparisons();
				
				if (data.get(primaryPointer).compareTo(pivot) <= 0){//if the pointer is less than pivot value
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
	
	public void sortByCalories(ArrayList<Pizza> data, int first, int last){
		if (first < last){
			incrementComparisons();
			Pizza pivot = data.get(last);
			int primaryPointer = last - 1; 
			int secondaryPointer = last - 1; //second reference pointer serving as a temporary element holder.

			while (primaryPointer >= first){//While the left pointer is in bounds
				incrementComparisons();
				
				if (data.get(primaryPointer).compareToByCalories(pivot) <= 0){//if the pointer is less than pivot value
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
	
	public void sortBySize(ArrayList<Pizza> data, int first, int last){
		if (first < last){
			incrementComparisons();
			Pizza pivot = data.get(last);
			int primaryPointer = last - 1; 
			int secondaryPointer = last - 1; //second reference pointer serving as a temporary element holder.

			while (primaryPointer >= first){//While the left pointer is in bounds
				incrementComparisons();
				
				if (data.get(primaryPointer).compareToBySize(pivot) <= 0){//if the pointer is less than pivot value
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
