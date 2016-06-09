/**
 * Abstract Class Base: Sub-Class of Ingredient; The base sauce or dressing on a PizzaManager Pizza.
 * Similar to Ingredient, Vegetable has a Money cost, int calories, and String description.
 * Base has no unique instance variables.
 * 
 * @author Roman Zhang
 *
 */
public class Base extends Ingredient{

	/**
	 * Base Constructor(): Takes argument for calories, cost, and description.
	 * @param inCalories
	 * @param inCost
	 * @param inDescription
	 */
	public Base(int inCalories, Money inCost, String inDescription) {
		super(inCalories, inCost, inDescription);
	}

}
