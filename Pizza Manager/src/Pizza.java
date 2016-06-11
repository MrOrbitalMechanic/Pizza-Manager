/**
 * Class Pizza: A Comparable Pizza in a PizzaManager. Pizzas have a list (ArrayList) of ingredients, 
 * a shape (circle or square), a Fraction representing the remaining Pizza, A Money total price of
 * the Pizza in Dollars, and an integer calorie count. Pizzas can be compared by cost, remaining area, 
 * and calories.
 * 
 * @author Roman Zhang
 *
 */
public class Pizza implements PizzaComparable{

	private ArrayList<Ingredient> ingredientList; //The list of Ingredients on this Pizza
	private Shape pizzaShape; //Shape of this Pizza (Circle or Square)
	private Fraction pizzaFraction; //Fraction representing remaining Pizza
	private Money pizzaCost; //Cost of this Pizza
	private int pizzaCalories; //Number of calories in this Pizza
	
	/**
	 * Default Constructor Pizza(): Creates an instance of a Pizza with random shape, one random Vegetable
	 * subclass, one random Meat subclass, one random Base subclass, and one random Cheese subclass.
	 */
	public Pizza(){
		this.ingredientList = new ArrayList<Ingredient>();
		this.setRemaining(new Fraction(1,1));
		this.pizzaCost = new Money();
		
		int randomShape = (int)(Math.round(Math.random()));
		if (randomShape == 0) this.pizzaShape = new Circle(12);
		else this.pizzaShape = new Square(12);
		
		int randomBase = (int)(Math.round(Math.random()));
		if (randomBase == 0) addIngredient(new Marinara());
		else addIngredient(new Alfredo());
		
		int randomCheese = (int)(Math.round(Math.random()));
		if (randomCheese == 0) addIngredient(new Goat());
		else addIngredient(new Mozzarella());
		
		int randomMeat = (int)(Math.round(Math.random()));
		if (randomMeat == 0) addIngredient(new Pepperoni());
		else addIngredient(new Sausage());
		
		int randomVeg = (int)(Math.round(Math.random()));
		if (randomVeg == 0) addIngredient(new Pepper());
		else addIngredient(new Olive());
		
		
		/*
		addIngredient(new Marinara());
		addIngredient(new Mozzarella());
		addIngredient(new Pepperoni());
		addIngredient(new Pepper());
		this.setShape(new Circle(12));
		*/
	}
	
	/**
	 * getRemaining(): Accessor method for this Pizza's remaining Fraction
	 * @return this Pizza's current Fraction
	 */
	public Fraction getRemaining(){
		return new Fraction(this.pizzaFraction);
	}
	
	/**
	 * setRemaining(): Mutator method for setting this Pizza's Fraction.
	 * @param remaining
	 */
	public void setRemaining(Fraction remaining){
		this.pizzaFraction = new Fraction(remaining);
	}
	
	/**
	 * getCalories(): Accessor method for this Pizza's calories
	 * @return this Pizza's current calorie amount.
	 */
	public int getCalories(){
		return this.pizzaCalories;
	}
	
	/**
	 * getCost(): Accessor method for this Pizza's current cost.
	 * @return this Pizza's current Money cost.
	 */
	public Money getCost(){
		return new Money(this.pizzaCost);
	}
	
	/**
	 * getRemainingArea(): calculates this Pizza's remaining area based on it's Shape's whole area 
	 * and its current Fraction remaining.
	 * @return The area of this Pizza's Shape multiplied by the Fraction remaining.
	 */
	public double getRemainingArea(){
		return (this.pizzaShape.getArea() * (this.pizzaFraction.getNumerator()/this.pizzaFraction.getDenominator()));
	}
	
	/**
	 * setShape(): Mutator method for setting this Pizza's shape.
	 * @param s
	 */
	public void setShape(Shape s) { pizzaShape = (Shape)s.clone();}
	
	/**
	 * getShape(): Accessor method for this Pizza's Shape.
	 * @return this Pizza's current Shape (Either a Circle or a Square).
	 */
	public Shape getShape() { return (Shape) pizzaShape.clone();}
	
	/**
	 * addIngredient(): Adds Ingredient toAdd to this Pizza's list of Ingredients.
	 * Adds the Ingredient's cost to this Pizza's whole cost.
	 * Adds the Ingredient's calories to this Pizza's whole calorie amount.
	 * @param toAdd: The Ingredient to be topped onto this Pizza
	 */
	public void addIngredient(Ingredient toAdd){
		this.ingredientList.add(toAdd);
		this.pizzaCost.add(new Money(toAdd.getCost()));
		this.pizzaCalories += toAdd.getCalories();
	}
	
	/**
	 * eatSomePizza(): Subtracts this Pizza's fraction amount by input Fraction amount.
	 * @param amount: Fraction to be subtracted to this Pizza
	 */
	public void eatSomePizza(Fraction amount){
		int sharedDenominator = this.pizzaFraction.getDenominator() * amount.getDenominator(); //Finds the common denominator between this Pizza's Fraction and the input Fraction amount.
		int numeratorDifference = (this.pizzaFraction.getNumerator() * amount.getDenominator()) - //Finds the difference between this Pizza's fraction ration and the input Fraction's ratio.
				(this.pizzaFraction.getDenominator() * amount.getNumerator());
		if(numeratorDifference == 0){throw new PizzaException("This pizza has now been completely eaten");} //If this Pizza's remaining fraction is zero after the subtraction, throw an exception to be handled
																											//to remove this Pizza from the PizzaManager.
		else if(numeratorDifference < 0){throw new NegativePizzaException("Error: Negative pizza remaining after eaten");} //If the difference results in a negative number, throw an error to be handled by PizzaManager
		else{
			this.pizzaFraction = new Fraction(numeratorDifference, sharedDenominator);
		}
	}
	
	@Override
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
