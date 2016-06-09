/**
 * Class Pepperoni: Sub-Class of Meat; Preset Instance variables.
 * 
 * @author Roman Zhang
 *
 */
public class Pepperoni extends Meat{

	final static int CALORIES = 95;
	final static Money COST = new Money(0,90);
	final static String DESCRIPTION = "Pepperoni: An American variety of salami, usually made from cured pork and beef mixed together. ";
	
	/**
	 * Pepperoni Constructor: Initializes calories, cost, and description.
	 */
	public Pepperoni() {
		super(CALORIES, COST, DESCRIPTION);
	}

}
