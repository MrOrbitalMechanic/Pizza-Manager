//package pizzaMainClasses;
import java.util.Scanner;

/*  PizzaManager Skeleton File
 *  CSS 161, Final Project
 * 
 * 	This class is a starting point for your final project and is incomplete.
 *  Start by reading the documentation(comments), and then the code.  Find the 
 *  empty stub methods you are to fill in using a Top-Down approach (see the
 *  assignment for more information on this and Stepwise Refinement)
 * 
 *  Author: Rob Nash
 */

public class PizzaManager {
	
	private ArrayList<Pizza> pizzaList;
	/* 
	 * The console interface is defined in the start method 
	 * You can exit or extend the code below to accomplish all of 
	 * the outcomes defined in the homework document
	 */
	public void start() {
		this.pizzaList = new ArrayList<Pizza>();
		char selection='q';
		
		Scanner foo = new Scanner(System.in);
		boolean runCondition = true;
		while(runCondition == true) {
			displayAllPizzas();
			displayInstructions();
			
			
			 //foo.nextChar() doesn't exist, so now what?
			selection = foo.next().charAt(0);
			
			switch(selection) {
				case	'A':    
				case	'a':	System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
								addRandomPizza();
								break;
				case	'H':    
				case	'h':	System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
								for(int i = 0; i < 101; i++){
									addRandomPizza();
								}
								break;					
				case	'E':    
				case	'e':	System.out.println("Eating a fraction of a pizza. How much? (a/b)");
								eatSomePizza(foo);
								break;			
				case	'P':    
				case	'p': 	System.out.println("QuickSorting pizzas by (P)rice");
								this.quickSortByPrice();
							  	break;	
				case	'S':    
				case	's': 	System.out.println("QuickSorting pizzas by (S)ize");
							 	this.quickSortBySize();
							 	break;		  
				case	'C':    
				case	'c':  	System.out.println("QuickSorting pizzas by (C)alories");
							  	this.quickSortByCalories();
							  	break;
				case	'B':
				case	'b':	System.out.println("(B)inary search over pizzas by calories(int).  QuickSorting first. What calorie count are you looking for?");
								this.quickSortByCalories();
								int calsToFind = foo.nextInt();
								if (calsToFind >= 0){
									System.out.println(this.binarySearchByCalories(calsToFind));
								}else{System.out.println("Invalid calories to find. Try again.");}
								break;
				case    'R':
				case 	'r':	System.out.println("(R)everse order of Pizzas with a Stack" );
								this.reverseOrder();
								break;
				case    'Q':
				case 	'q':	System.out.println("(Q)uitting!" );
								runCondition = false;
								break;
				default:	System.out.println("Unrecognized input - try again");
			}
		}

	}

	/**
	 * eatSomePizza(): Takes input from the key Scanner for the Fraction of Pizza to be eaten, and which Pizza in the 
	 * List is to be eaten. If the subtraction of the Pizza results to 0, remove that Pizza from the List.
	 * If the difference is negative, prompt the user to enter a valid Fraction.
	 * @param keys
	 */
	private void eatSomePizza(Scanner keys) {
		String inFraction = keys.next(); //The String input read from the Scanner
		Fraction fractionToEat = new Fraction(inFraction);
		System.out.println("Index of pizza you would like to eat?");
		int indexOfPizza = keys.nextInt();
	
		if (indexOfPizza >= 0 && indexOfPizza < pizzaList.size()){
			try{
				(pizzaList.get(indexOfPizza)).eatSomePizza(fractionToEat);
			}
			catch (NegativePizzaException e){
				System.out.println("Resulting Pizza difference is negative: Enter a valid fraction");
				eatSomePizza(keys);
			}
			catch(PizzaException i){
				pizzaList.remove(indexOfPizza);
				System.out.println("This pizza has now been completely eaten.");
			}
		}else{
			System.out.println("Invalid index; Please enter a valid index");
			//eatSomePizza(keys);
		}
	
	}
	
	/**
	 * addRandomPizza(): adds a Pizza with Random specifications to this PizzaManager's list
	 */
	private void addRandomPizza() {
		this.pizzaList.add(new Pizza());
	}

	/**
	 * displayAllPizzas(): Prints to console all Pizzas currently stored in this PizzaManager's list
	 */
	private void displayAllPizzas() {
		for (int i = 0; i < pizzaList.size(); i++){
			System.out.println(pizzaList.get(i).toString() + "\n");
		}
	}

	/**
	 * quickSortByPrice(): Uses the quicksort algorithm to recursively rearrange the Pizza's in this
	 * PizzaManager in ascending order by their price.
	 */
	private void quickSortByPrice() {  
		QuickSort priceSort = new QuickSort();
		priceSort.sort(this.pizzaList, 0, pizzaList.size()-1);
	}
	
	/**
	 * quickSortBySize(): Uses the quicksort algorithm to recursively rearrange the Pizza's in this
	 * PizzaManager in ascending order by their remaining area.
	 */
	private void quickSortBySize() {
		QuickSort sizeSort = new QuickSort();
		sizeSort.sortBySize(this.pizzaList, 0, pizzaList.size()-1);
	}
	
	/**
	 * quickSortByCalories(): Uses the quicksort algorithm to recursively rearrange the Pizza's in this
	 * PizzaManager in ascending order by their calories.
	 */
	private void quickSortByCalories() {
		QuickSort calorieSort = new QuickSort();
		calorieSort.sortByCalories(this.pizzaList, 0, pizzaList.size()-1);
	}
	
	/**
	 * binarySearchByCalories(): Uses the recursive binary search algorithm to locate the index of a Pizza with a specified 
	 * number of calories in this PizzaManager.
	 * @param cals: The specified number of calories to be found 
	 * @return The index of the Pizza with the exact number of specified calories "cals"
	 */
	private int binarySearchByCalories(int cals) {
		return recursiveBinarySearch(cals,0,this.pizzaList.size()-1);
	}
	
	/**
	 * recursiveBinarySearch(): Standalone recursive binary search algorithm for use in this PizzaManager's 
	 * binarySearchByCalories.
	 * @param toFind
	 * @param first
	 * @param last
	 * @return The index of the specified value in this PizzaList.
	 */
	private int recursiveBinarySearch(int toFind,int first,int last){
		if(first < last){
			int mid = (first+last)/2;
			if(toFind < this.pizzaList.get(mid).getCalories()){
				return recursiveBinarySearch(toFind,first, mid - 1);
			}else if (toFind > this.pizzaList.get(mid).getCalories()){
				return recursiveBinarySearch(toFind,mid + 1, last);
			}else{
				return mid;
			}
		}else{return -1;}
	}
	
	/**
	 * reverseOrder(): Uses a Stack to reverse the order of Pizza's in this PizzaManager's List.
	 */
	private void reverseOrder(){
		Stack reverserStack = new Stack();
		while(!this.pizzaList.isEmpty()){
			reverserStack.push(this.pizzaList.remove(0));
		}
		
		while(!reverserStack.isEmpty()){
			this.pizzaList.add((Pizza) reverserStack.pop());
		}
	}
	/*
	 * No need to edit functions below this line, unless extending the menu or
	 * changing the instructions
	 */
	private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nQuickSort pizzas by (P)rice\nQuickSort pizzas by (S)ize\nQuickSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(R)everse order of pizzas with a stack\n(Q)uit\n";
	private void displayInstructions() {
		System.out.println(instructions);	
	}
	/*
	 * Notice the one-line main function.
	 */
	public static void main(String[] args) {
		new PizzaManager().start();
	}
}