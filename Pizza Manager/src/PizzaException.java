/**
 * Class PizzaException: A general RuntimeException for PizzaManager.
 * 
 * @author Roman Zhang
 *
 */
public class PizzaException extends RuntimeException{

	/**
	 * Default Constructor:
	 */
	public PizzaException(){
		super();
	}
	
	/**
	 * Constructor PizzaException(): Outputs a specified String message
	 * @param message
	 */
	public PizzaException(String message){
		super(message);
	}
}
