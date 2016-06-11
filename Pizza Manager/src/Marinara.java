/**
 * Class Marinara: Sub-Class of Base; Preset Instance variables.
 * 
 * @author Roman Zhang
 *
 */
public class Marinara extends Base{

	final static int CALORIES = 45;
	final static Money COST = new Money(1,5);
	final static String DESCRIPTION = "Marinara: An Italian sauce that originated in Naples, made with tomatoes, garlic, herbs, and onions.";
	
	/**
	 * Marinara Constructor: Initializes calories, cost, and description.
	 */
	public Marinara() {
		super(CALORIES, COST, DESCRIPTION);
	}

}
