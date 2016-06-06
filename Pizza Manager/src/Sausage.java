/**
 * 
 * @author Roman
 *
 */
public class Sausage extends Meat{

	final static int CALORIES = 95;
	final static Money COST = new Money(0,90);
	final static String DESCRIPTION = "Made from ground meat; pork, beef, or veal, along with salt, spices and breadcrumbs";
	
	public Sausage() {
		super(CALORIES, COST, DESCRIPTION);
	}

}
