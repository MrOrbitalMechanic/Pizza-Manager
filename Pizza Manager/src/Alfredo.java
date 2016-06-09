/**
 * Class Alfredo: Sub-Class of Base; Preset Instance variables.
 * 
 * @author Roman Zhang
 *
 */
public class Alfredo extends Base{

	final static int CALORIES = 50;
	final static Money COST = new Money(0,80);
	final static String DESCRIPTION = "Alfredo: Parmesan cheese melted in butter";
	
	/**
	 * Alfredo Constructor: Initializes calories, cost, and description.
	 */
	public Alfredo() {
		super(CALORIES, COST, DESCRIPTION);
	}

}
