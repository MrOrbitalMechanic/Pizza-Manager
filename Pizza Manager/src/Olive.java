import java.awt.Color;
/**
 * Class Olive: Sub-Class of Vegetable; Preset Instance variables.
 * 
 * @author Roman Zhang
 *
 */
public class Olive extends Vegetable{

	final static int CALORIES = 35;
	final static Money COST = new Money(0,40);
	final static Color COLOR = Color.BLACK;
	final static String DESCRIPTION = "Olives";
	
	/**
	 * Olive Constructor: Initializes calories, cost, description, and Color.
	 */
	public Olive() {
		super(CALORIES, COST, DESCRIPTION, COLOR);
	}

}
