import java.awt.Color;
/**
 * Abstract Class Vegetable: Sub-Class of Ingredient; A vegetable ingredient topping on a PizzaManager Pizza.
 * Similar to Ingredient, Vegetable has a Money cost, int calories, and String description. 
 * Vegetables also have an instance Color. 
 * 
 * @author Roman Zhang
 *
 */
public abstract class Vegetable extends Ingredient{
	
	private Color myColor; //The Color of this Vegetable
	
	/**
	 * Vegetable Constructor: Takes argument for calories, cost, and description.
	 * Given default color GREEN.
	 * @param inCalories
	 * @param inCost
	 * @param inDescription
	 */
	public Vegetable(int inCalories, Money inCost, String inDescription){
		super(inCalories, inCost, inDescription);
		this.myColor = Color.GREEN;
	}
	
	/**
	 * Vegetable Constructor: Takes arguments for calories, cost, description, and color.
	 * @param inCalories
	 * @param inCost
	 * @param inDescription
	 * @param inColor
	 */
	public Vegetable(int inCalories, Money inCost, String inDescription, Color inColor) {
		super(inCalories, inCost, inDescription);
		this.myColor = inColor;
	}

	@Override
	public String toString(){
		return "" + this.getColor().toString() + super.toString();
	}
	
	/**
	 * public accessor method for Color.
	 * @return this Vegetable's instance color.
	 */
	public Color getColor(){
		return this.myColor;
	}
	
	/**
	 * public mutator method for Color.
	 * @param inColor: The color to be set to this Vegetable's instance color.
	 */
	public void setColor(Color inColor){
		this.myColor = inColor;
	}
	
	@Override
	public boolean equals(Object other){
		return super.equals(other) && this.myColor.equals(((Vegetable) other).getColor());
	}
}
