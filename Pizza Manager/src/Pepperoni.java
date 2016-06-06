/**
 * 
 * @author Roman
 *
 */
public class Pepperoni extends Meat{

	final static int CALORIES = 95;
	final static Money COST = new Money(0,90);
	final static String DESCRIPTION = "An American variety of salami, usually made from cured pork and beef mixed together. ";
	
	public Pepperoni() {
		super(CALORIES, COST, DESCRIPTION);
	}

}
