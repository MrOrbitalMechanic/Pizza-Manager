/**
 * 
 * @author Roman
 *
 */
public class Alfredo extends Base{

	final static int CALORIES = 50;
	final static Money COST = new Money(0,80);
	final static String DESCRIPTION = "Parmesan cheese melted in butter";
	
	public Alfredo() {
		super(CALORIES, COST, DESCRIPTION);
	}

}
