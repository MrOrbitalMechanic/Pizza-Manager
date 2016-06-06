import java.awt.Color;
/**
 * 
 * @author Roman
 *
 */
public abstract class Vegetable extends Ingredient{
	
	private Color myColor;
	
	public Vegetable(int inCalories, Money inCost, String inDescription){
		super(inCalories, inCost, inDescription);
		this.myColor = Color.GREEN;
	}
	
	public Vegetable(int inCalories, Money inCost, String inDescription, Color inColor) {
		super(inCalories, inCost, inDescription);
		this.myColor = inColor;
	}

	public String toString(){
		//todo:
	}
	
	public Color getColor(){
		return this.myColor;
	}
	
	public void setColor(Color inColor){
		this.myColor = inColor;
	}
	
	public boolean equals(Object other){
		return super.equals(other) && this.myColor.equals(((Vegetable) other).getColor());
	}
}
