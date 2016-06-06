/**
 * 
 * @author Roman
 *
 */
public class Marinara extends Base{

	final static int CALORIES = 45;
	final static Money COST = new Money(0,80);
	final static String DESCRIPTION = " An Italian sauce that originated in Naples, made with tomatoes, garlic, herbs, and onions.";
	
	public Marinara() {
		super(CALORIES, COST, DESCRIPTION);
	}

}
