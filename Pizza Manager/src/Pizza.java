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
		this.pizzaFraction = new Fraction(1,1);
		// TODO
	}
	
	public Fraction getRemaining(){
		return new Fraction(this.pizzaFraction);
	}
	
	public void setRemaining(Fraction remaining){
		// TODO
	}
	
	public int getCalories(){
		return this.pizzaCalories;
	}
	
	public Money getCost(){
		return new Money(this.pizzaCost);
	}
	
	public double getRemainingArea(){
		return this.pizzaShape.getArea();
	}
	
	public void setShape(Shape s) { pizzaShape = (Shape)s.clone();}
	
	public Shape getShape() { return (Shape) pizzaShape.clone();}
	
	public void addIngredient(Ingredient toAdd){
		// TODO
	}
	
	public void eatSomePizza(Fraction amount){
		// TODO
	}
	
	public String toString(){
		// TODO
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareToBySize(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareToByCalories(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
