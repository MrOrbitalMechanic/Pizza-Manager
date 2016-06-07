/**
 * 
 * @author Roman
 *
 */
public class Pizza implements PizzaComparable{

	private ArrayList<Ingredient> ingredientList;
	private Shape pizzaShape;
	private Fraction pizzaFraction;
	private Money pizzaCost;
	private int pizzaCalories;
	
	
	public Pizza(){
		this.ingredientList = new ArrayList<Ingredient>();
		this.setRemaining(new Fraction(1,1));
		this.pizzaCost = new Money();
		addIngredient(new Marinara());
		addIngredient(new Mozzarella());
		addIngredient(new Pepperoni());
		addIngredient(new Pepper());
		this.setShape(new Circle(12));
	}
	
	public Fraction getRemaining(){
		return new Fraction(this.pizzaFraction);
	}
	
	public void setRemaining(Fraction remaining){
		this.pizzaFraction = new Fraction(remaining);
	}
	
	public int getCalories(){
		return this.pizzaCalories;
	}
	
	public Money getCost(){
		return new Money(this.pizzaCost);
	}
	
	public double getRemainingArea(){
		return (this.pizzaShape.getArea() * (this.pizzaFraction.getNumerator()/this.pizzaFraction.getDenominator()));
	}
	
	public void setShape(Shape s) { pizzaShape = (Shape)s.clone();}
	
	public Shape getShape() { return (Shape) pizzaShape.clone();}
	
	public void addIngredient(Ingredient toAdd){
		this.ingredientList.add(toAdd);
		this.pizzaCost.add(new Money(toAdd.getCost()));
		this.pizzaCalories += toAdd.getCalories();
	}
	
	public void eatSomePizza(Fraction amount){
		int numeratorDifference = this.pizzaFraction.getNumerator() - 
				(this.pizzaFraction.getDenominator() * amount.getNumerator());
		if(numeratorDifference == 0){throw new PizzaException("This pizza has now been completely eaten");}
		else if(numeratorDifference < 0){throw new NegativePizzaException("Error: Negative pizza remaining after eaten");}
		else{
			this.pizzaFraction = new Fraction(numeratorDifference, this.pizzaFraction.getDenominator());
		}
	}
	
	public String toString(){
		String retStr = "";
		retStr += "A " + this.pizzaShape.toString() + " pizza with " + this.pizzaFraction.toString() +
				" remaining." + "\n" + "The ingredients are:" + "\n";
		for (int i = 0; i < ingredientList.size(); i++){
			retStr += ((Ingredient) ingredientList.get(i)).toString() + "\n";
		}
		retStr += "Total calories: " + this.pizzaCalories + "\n";
		retStr += "Total cost: " + this.pizzaCost.toString();
		
		return retStr;
		
	}
	
	@Override
	public int compareTo(Object other) {
		if(other instanceof Pizza){
			Pizza that = (Pizza) other;
			int thisDelta = (int)this.pizzaCost.getMoney();
			int thatDelta = (int) that.getCost().getMoney();
			return thisDelta - thatDelta;
		}else{throw new PizzaException("Invalid compareTo object");}
	}

	@Override
	public int compareToBySize(Object other) {
		if(other instanceof Pizza){
			Pizza that = (Pizza) other;
			int thisDelta = (int)this.getRemainingArea();
			int thatDelta = (int) that.getRemainingArea();
			return thisDelta - thatDelta;
		}else{throw new PizzaException("Invalid compareTo object");}
	}

	@Override
	public int compareToByCalories(Object other) {
		if(other instanceof Pizza){
			Pizza that = (Pizza) other;
			int thisDelta = this.pizzaCalories;
			int thatDelta = that.getCalories();
			return thisDelta - thatDelta;
		}else{throw new PizzaException("Invalid compareTo object");}
	}

	
}
