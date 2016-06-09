import java.awt.Color;

/**
 * Class Pepper: Sub-Class of Vegetable; Preset Instance variables.
 * 
 * @author Roman Zhang
 *
 */
public class Pepper extends Vegetable{

	final static int CALORIES = 35;
	final static Money COST = new Money(0,40);
	final static Color COLOR = Color.GREEN;
	final static String DESCRIPTION = "Peppers";
	
	/**
	 * Pepper Constructor: Initializes calories, cost, description, and Color.
	 */
	public Pepper() {
		super(CALORIES, COST, DESCRIPTION, COLOR);
		
	}


}
