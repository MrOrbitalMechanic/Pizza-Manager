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
	/*
	 *  TODO: Data definitions here.  
	 */
	private ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
	/* 
	 * The console interface is defined in the start method 
	 * You can exit or extend the code below to accomplish all of 
	 * the outcomes defined in the homework document
	 */
	public void start() {
		//this.pizzaList = new ArrayList<Pizza>();
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
								//todo:
							  	break;	
				case	'S':    
				case	's': 	System.out.println("QuickSorting pizzas by (S)ize");
							 	//todo:
							 	break;		  
				case	'C':    
				case	'c':  	System.out.println("QuickSorting pizzas by (C)alories");
							  	//todo
							  	break;
				case	'B':
				case	'b':	System.out.println("(B)inary search over pizzas by calories(int).  QuickSorting first. What calorie count are you looking for?");
								//todo:
				case    'R':
				case 	'r':	System.out.println("(R)everse order of Pizzas with a Stack" );
								//todo:				
				case    'Q':
				case 	'q':	System.out.println("(Q)uitting!" );

								runCondition = false;
								break;
				default:	System.out.println("Unrecognized input - try again");
			}
		}

	}

	private void eatSomePizza(Scanner keys) {
		String inFraction = keys.next();
		Fraction fractionToEat = new Fraction(inFraction);
		System.out.println("Index of pizza you would like to eat?");
		int indexOfPizza = keys.nextInt();
		if (pizzaList.size() > 0){
			if (indexOfPizza > 0 && indexOfPizza < pizzaList.size()){
				try{
					((Pizza) pizzaList.get(indexOfPizza)).eatSomePizza(fractionToEat);
				}
				catch (NegativePizzaException e){
					System.out.print("Enter a valid fraction");
				}
				catch(PizzaException i){
					pizzaList.remove(indexOfPizza);
				}
			}else{throw new PizzaException("Invalid index of Pizza");}
		}else{System.out.println("There are currently no pizzas stored");}
	}
	
	private void addRandomPizza() {
		this.pizzaList.add(new Pizza());
	}

	private void displayAllPizzas() {
		for (int i = 0; i < pizzaList.size(); i++){
			System.out.println(pizzaList.get(i).toString() + "\n");
		}
	}

	private void quickSortByPrice() {  
		//todo:
	}
	
	private void quickSortBySize() {
		//todo:
	}
	
	private void quickSortByCalories() {
		//todo:
	}
	
	private int binarySearchByCalories(int cals) {
		//todo:
		return -1;
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