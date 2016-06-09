/**
 * Class Mozzarella: Sub-Class of Cheese; Preset Instance variables
 * 
 * @author Roman Zhang
 *
 */
public class Mozzarella extends Cheese {

	final static int CALORIES = 60;
	final static Money COST = new Money(0,55);
	final static String DESCRIPTION = "Mozzarella, A southern Italian cheese traditionally made from Italian buffalo milk by the pasta filata method.";
	
	/**
	 * Mozzarella Constructor: Initializes calories, cost, and description.
	 */
	public Mozzarella() {
		super(CALORIES, COST, DESCRIPTION);
	}

}
