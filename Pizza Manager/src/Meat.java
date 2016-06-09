/**
  Abstract Class Meat: Sub-Class of Ingredient; A meat ingredient topping on a PizzaManager Pizza.
 * Similar to Ingredient, Meat has a Money cost, int calories, and String description. 
 * Meat has no unique instance variables 
 * 
 * @author Roman Zhang
 */
public abstract class Meat extends Ingredient{

	/**
	 * Meat Constructor: Takes argument for calories, cost, and description.
	 * @param inCalories
	 * @param inCost
	 * @param inDescription
	 */
	public Meat(int inCalories, Money inCost, String inDescription) {
		super(inCalories, inCost, inDescription);
	}

	

}
