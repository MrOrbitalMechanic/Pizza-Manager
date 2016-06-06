/**
 * 
 * @author Roman
 *
 */
public class Mozzarella extends Cheese {

	final static int CALORIES = 60;
	final static Money COST = new Money(0,55);
	final static String DESCRIPTION = "A southern Italian cheese traditionally made from Italian buffalo milk by the pasta filata method.";
	
	public Mozzarella() {
		super(CALORIES, COST, DESCRIPTION);
	}

}
