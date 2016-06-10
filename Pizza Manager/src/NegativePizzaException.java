/**
 * Class NegativePizzaException: A PizzaException to be thrown only when a negative difference in Pizza fractions has occurred.
 * 
 * @author Roman Zhang
 *
 */
public class NegativePizzaException extends PizzaException{
	
	public NegativePizzaException(){
		super();
	}
	
	/**
	 * Constructor NegativePizzaException(): Outputs a specified String message
	 * @param message
	 */
	public NegativePizzaException(String message){
		super(message);
	}
}
