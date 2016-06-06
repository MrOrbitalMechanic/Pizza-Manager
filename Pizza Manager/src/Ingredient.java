/**
 * 
 * @author Roman
 *
 */
public abstract class Ingredient implements Comparable{

	private int calories;
	private Money cost;
	private String description;
	
	public Ingredient(int inCalories, Money inCost, String inDescription){
		this.calories = inCalories;
		this.cost = new Money(inCost);
		this.description = inDescription;
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString(){
		//todo:
	}
	
	public boolean equals(Object other){
		if(other instanceof Ingredient){
			Ingredient that = (Ingredient) other;
			return this.calories == that.getCalories() &&
					this.cost.equals(that.getCost()) &&
					this.description.equals(that.getDescription());
		}else{return false;}
	}

	public int getCalories() {
		return this.calories;
	}
	
	public Money getCost(){
		return new Money(this.cost);
	}
	
	public String getDescription(){
		return this.description;
	}
}
