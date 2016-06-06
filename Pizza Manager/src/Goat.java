/**
 * 
 * @author Roman
 *
 */
public class Goat extends Cheese{

	final static int CALORIES = 60;
	final static Money COST = new Money(0,55);
	final static String DESCRIPTION = "Premium cheese made from goat's milk";
	
	public Goat() {
		super(CALORIES, COST, DESCRIPTION);
	}

}
