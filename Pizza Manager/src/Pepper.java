import java.awt.Color;

/**
 * 
 * @author Roman
 *
 */
public class Pepper extends Vegetable{

	final static int CALORIES = 35;
	final static Money COST = new Money(0,40);
	final static Color COLOR = Color.GREEN;
	final static String DESCRIPTION = COLOR + " peppers";
	
	public Pepper() {
		super(CALORIES, COST, DESCRIPTION, COLOR);
		
	}


}
