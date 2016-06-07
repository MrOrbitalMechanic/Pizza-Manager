/**
 * Class Money: Represents a USD currency value in Dollars and Cents.
 * A Money object can have a custom amount added, but not subtracted.
 * A Money object can also have its current value completely replaced with 
 * another custom value.
 * 
 * @author Roman Zhang
 */
public class Money {
	
	private int dollars;
	private int cents;
	
	/**
	 * Default No-Arg Constructor Money(): Gives this Money object a default value
	 * of one Dollar and zero Cents.
	 */
	public Money(){
		this.dollars = 0;
		this.cents = 0;
	}
	/**
	 * Constructor Money(int dol): Initializes this instance dollar to the parameter input dol. 
	 * Initializes cents to zero.
	 * @param dol: The dollar value given to this Money object.
	 */
	public Money(int dol){
		if(isValid(dol)){
			this.dollars = dol;
			this.cents = 0;
		}else{System.out.println("Error: Invalid Dollar value: Money constructor(int dol)...Exiting"); System.exit(-1);}
	}
	
	/**
	 * Constructor Money(int dol, int cent): Initializes this instance dollar and cent to 
	 * parameter inputs dol and cent if dol OR cent are greater than zero. 
	 * Initializes this Money object's instance dollar and cent by invoking the Money
	 * method setMoney(), which takes dol and cent as arguments.
	 * Throws an error if dol and cent are both equal to or less than zero, then exits
	 * the program.
	 * 
	 * @param dol: The dollar value given to this Money object.
	 * @param cent: The cent value given to this money object.
	 */
	public Money(int dol, int cent){
		if((this.isValid(dol) && this.isValid(cent)) || this.isValid(cent)){
			this.setMoney(dol, cent);
		}else{System.out.println("Error: Invalid Dollar or Cent value: Money constructor(int dol, int cent)...Exiting"); System.exit(-1);}
	}
	
	public Money(double wholeValue){
		if(wholeValue > 0){
			int wholeAmount = (int)wholeValue;
			int decimalAmount = (int)wholeValue - wholeAmount;
			this.dollars = wholeAmount;
			this.cents = decimalAmount;
		}else{throw new PizzaException("Invalid wholeValue");}
	}
	/**
	 * Copy Constructor Money(Money other): Initializes this Money object's dollars and cents 
	 * instance variables to the values of another Money object's  dollars and cents by invoking
	 * the two-argument constructor Money(int dol, int cent). 
	 * @param other: The Money object whose dollar and cent values are to be copied.
	 */
	public Money(Money other){
		this(other.getDollars(),other.getCents());
	}
	
	/**
	 * getMoney(): Finds this Money object's total real value by converting its cents instance
	 * variable to 1/100th of a dollar, then adding it to the dollar value.
	 * @return This Money object's total monetary value as a double (in the form $xx.xx).
	 */
	public double getMoney(){
		double retVal = this.dollars + (this.cents / 100);
		return retVal;
	}
	
	/**
	 * setMoney(): Sets this Money object's dollars and cents instance variables to the 
	 * dol and cent arguments. If the cent argument value exceeds 99, it will be converted
	 * to one dollar, which will be added to this Money object's instance dollars.  
	 * @param dol: The dollar value to be set to this Money object's instance dollars.
	 * @param cent: The cent value to be set to this Money object's instance cents.
	 */
	public void setMoney(int dol, int cent){
		if ((this.isValid(dol) && this.isValid(cent)) || this.isValid(cent)){
			this.dollars = dol;
			if(cent > 99){
				int dollarAddition = cent / 100;
				int remainder = cent % 100;
				this.dollars += dollarAddition;
				this.cents = remainder;
			}else{this.cents = cent;}
		}else{System.out.println("Error: Invalid Dollar or Cent value: Money method setMoney()");}
	}
	
	/**
	 * add(Money other): Increases this Money object's instance dollar and cent values by 
	 * another Money objects' dollar and cent values by invoking the two-argument 
	 * add(int dol, int cent) method.
	 * @param other: The money object whose dollar and cent values are to be added to this Money
	 * object's dollar and cent values.
	 */
	public void add(Money other){
		if(other != null){
			this.add(other.getDollars(), other.getCents());
		}else{System.out.println("Error: Null money passed: add(Money other)");}
	}
	
	/**
	 * add(int dol): Increases this Money object's instance dollar value by a custom dollar
	 * argument value dol.
	 * @param dol: The dollar value to increase this Money object's dollar value by.
	 */
	public void add(int dol){
		if(this.isValid(dol)){
			this.dollars += dol;
		}else{System.out.println("Error: Invalid Dollar value: Money method add()");}
	}
	
	/**
	 * add(int dol, int cent): Increases this Money object's instance dollar and cent values by 
	 * custom dollar and cent argument values dol & cent. If the cent argument value exceeds 99, 
	 * it will be converted to one dollar, which will be added to this Money object's instance 
	 * dollars.  
	 * @param dol: The dollar value to increase this Money objects's dollar value by.
	 * @param cent: The cent value to increase this Money objects's cent value by.
	 */
	public void add(int dol,int cent){
		if(this.isValid(dol) || this.isValid(cent)){
			this.dollars += dol;
			if(this.cents + cent > 99){
				int dollarAddition = (this.cents + cent) / 100;
				int remainder = (this.cents + cent) % 100;
				this.dollars += dollarAddition;
				this.cents = remainder;
			}else{this.cents += cent;}
		}else{System.out.println("Error: Invalid Dollar or Cent value: Money method add()");}
	}
	
	/**
	 * equals(Object other): If the argument Object other is an instance of Money, compares 
	 * the full monetary value of other to this Money object's full monetary value(as a double).
	 * @param other: The Object (if it is an instance of Money) whose value is to be compared to 
	 * this Money object's value.
	 * @return True if this Money object's full double value is equal to the other Money object's
	 * 		   value.
	 * 		   False if the two Money object's values are not equal.
	 */
	@Override
	public boolean equals(Object other){
		if (other != null && other instanceof Money){
			return (((Money) other).getMoney() == this.getMoney());
		}else{System.out.println("Error: Invalid or Null input Object: Money method equals(Object o)"); return false;}
	}
	
	/**
	 * toString(): Gets this Money object's written value representation.
	 * @return This Money object's USD monetary representation as a string in the format "$xx.xx".
	 */
	@Override
	public String toString(){
		String retVal = "$" + this.dollars +".";
		if(this.cents < 10){
			retVal += "0" + this.cents;
		}else{retVal += this.cents;}
		return retVal;
	}
	
	/**
	 * isValid(): Used to check if an input dollar or cent amount is greater than zero.
	 * @param inputValue: The dollar or cent value to be checked for validity.
	 * @return True if inputValue is not negative.
	 * 		   False if inputValue is negative.
	 */
	private boolean isValid(int inputValue){
		return inputValue > 0;
	}
	
	/**
	 * getDollars(): Accessor method for accessing this Money object's instance dollars value.
	 * @return This Money object's integer dollar value.
	 */
	public int getDollars(){
		return this.dollars;
	}
	
	/**
	 * getCents(): Accessor method for accessing this Money object's instance cents value.
	 * @return this Money object's integer cent value.
	 */
	public int getCents(){
		return this.cents;
	}
}
