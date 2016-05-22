/**
 * Class Square: A quadrilateral Shape with four equal side lengths. 
 * @author Roman Zhang
 *
 */
public class Square extends Rectangle{

	/**
	 * Constructor Square(): Initializes parameters to superclass Rectangle's 
	 * constructor, initializing sideLength to the width and the height of 
	 * the Rectangle, resulting in a square.
	 * @param inX
	 * @param inY
	 * @param sideLength
	 */
	public Square(int inX, int inY, int sideLength){
		super(inX,inY,sideLength,sideLength);
	}
}
