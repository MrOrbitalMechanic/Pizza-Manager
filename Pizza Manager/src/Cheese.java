/**
  Abstract Class Cheese: Sub-Class of Ingredient; A cheese topping on a PizzaManager Pizza.
 * Similar to Ingredient, Cheese has a Money cost, int calories, and String description. 
 * Cheese has no unique instance variables.
 * 
 * @author Roman Zhang
 *
 */
public abstract class Cheese extends Ingredient {

	/**
	 * Cheese Constructor: Takes argument for calories, cost, and description.
	 * @param inCalories
	 * @param inCost
	 * @param inDescription
	 */
	public Cheese(int inCalories, Money inCost, String inDescription) {
		super(inCalories, inCost, inDescription);
	}

}
