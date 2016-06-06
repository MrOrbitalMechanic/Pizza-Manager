import java.awt.Color;

/**
 * 
 * @author Roman
 *
 */
public class Pepper extends Vegetable{

	final static int CALORIES = 35;
	final static Money COST = new Money(0,40);
	final static String DESCRIPTION = "Green Bell Peppers";
	final static Color COLOR = Color.GREEN;
	
	public Pepper() {
		super(CALORIES, COST, DESCRIPTION, COLOR);
		
	}


}
