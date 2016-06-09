/**
 * Class Goat:  Sub-Class of Cheese; Preset Instance variables.
 * @author Roman
 *
 */
public class Goat extends Cheese{

	final static int CALORIES = 60;
	final static Money COST = new Money(0,55);
	final static String DESCRIPTION = "Goat Cheese: Premium cheese made from goat's milk";
	
	/**
	 * Goat Constructor: Initializes calories, cost, and description.
	 */
	public Goat() {
		super(CALORIES, COST, DESCRIPTION);
	}

}
