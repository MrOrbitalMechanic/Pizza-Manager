import java.awt.Color;
/**
 * 
 * @author Roman
 *
 */
public class Olive extends Vegetable{

	final static int CALORIES = 35;
	final static Money COST = new Money(0,40);
	final static Color COLOR = Color.BLACK;
	final static String DESCRIPTION = COLOR + " olives";
	
	public Olive() {
		super(CALORIES, COST, DESCRIPTION, COLOR);
	}

}
