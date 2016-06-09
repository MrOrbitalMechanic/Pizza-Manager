/**
 * Class Sausage: Sub-Class of Meat; Preset Instance variables.
 * 
 * @author Roman Zhang
 *
 */
public class Sausage extends Meat{

	final static int CALORIES = 95;
	final static Money COST = new Money(0,90);
	final static String DESCRIPTION = "Sausage: Made from ground meat; pork, beef, or veal, along with salt, spices and breadcrumbs";
	
	/**
	 * Sausage Constructor: Initializes calories, cost, and description.
	 */
	public Sausage() {
		super(CALORIES, COST, DESCRIPTION);
	}

}
