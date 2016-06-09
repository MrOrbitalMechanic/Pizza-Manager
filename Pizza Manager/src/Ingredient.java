/**
 * Abstract Class Ingredient: An abstract Ingredient on a PizzaManager Pizza.
 * Implements the Comparable interface; comparable by COST.
 * Has a Money cost, int calories, and String description.
 * @author Roman Zhang
 *
 */
public abstract class Ingredient implements Comparable{

	private int calories; //Number of calories per serving of this Ingredient
	private Money cost; //Cost per serving of this Ingredient in Dollars
	private String description; //Description of this Ingredient
	
	/**
	 * Ingredient Constructor: Takes arguments for calories, cost, and description.
	 * @param inCalories
	 * @param inCost
	 * @param inDescription
	 */
	public Ingredient(int inCalories, Money inCost, String inDescription){
		this.calories = inCalories;
		this.cost = new Money(inCost);
		this.description = inDescription;
	}
	
	@Override
	public int compareTo(Object other) {
		if(other instanceof Ingredient){
			Ingredient that = (Ingredient) other;
			int thisDelta = (int)this.cost.getMoney();
			int thatDelta = (int)that.getCost().getMoney();
			return thisDelta - thatDelta;
		}else{throw new PizzaException("Invalid compareTo object");}
	}
	
	@Override
	public String toString(){
		return this.description + " with " + this.calories + " calories per serving " + "and costs " + this.cost.toString();
	}
	
	@Override
	public boolean equals(Object other){
		if(other instanceof Ingredient){
			Ingredient that = (Ingredient) other;
			return this.calories == that.getCalories() &&
					this.cost.equals(that.getCost()) &&
					this.description.equals(that.getDescription());
		}else{return false;}
	}

	/**
	 * public accessor method getCalories():
	 * @return This Ingredient's calories
	 */
	public int getCalories() {
		return this.calories;
	}
	
	/**
	 * public accessor method getCost():
	 * @return This Ingredient's cost as a Money object
	 */
	public Money getCost(){
		return new Money(this.cost);
	}
	
	/**
	 * public accessor method getDescription():
	 * @return this Ingredient's description.
	 */
	public String getDescription(){
		return this.description;
	}
}
