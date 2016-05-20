/**
 * 
 * @author Roman Zhang
 * Fraction: represents a simple fraction: An integer numerator value and an integer denominator value.
 */
public class Fraction {
	
	private String[] fullFrac = new String[2];
	private final int numerator;
	private final int denominator;
	
	
	private Fraction(){
		this.numerator = 1;
		this.denominator = 1;
	}
	
	/**
	 * 
	 * @param frac
	 */
	public Fraction(String frac){
		this.fullFrac = frac.split("/", 2);
		this.numerator = Integer.parseInt(fullFrac[0]);
		this.denominator = Integer.parseInt(fullFrac[1]);
		if(this.numerator == 0 || this.denominator == 0){/*Do nothing*/}
		else{throw new PizzaException("Numerator or denominator cannot be zero");}
	}
	
	//Copy constructor
	public Fraction(Fraction copy){
		this.numerator = copy.getNumerator();
		this.denominator = copy.getDenominator();
		
	}
	
	public Fraction(int num, int denom){
		if (num > 0 && denom > 0){
			this.numerator = num;
			this.denominator = denom;
		}else{throw new PizzaException("Numerator or denominator cannot be zero");}
	}
	    
	/**
	 * reduce():
	 * @return : If reducible - returns reduced form of the original Fraction.
	 * 			 If irreducible - returns the original Fraction
	 */
	public int getGCD(int num, int denom){
		if (num > denom){
			if (num % denom != 1){
				int tempNum = denom;
				int tempDenom = num % denom;
				if(tempNum % tempDenom == 0){
					return tempDenom;
				}else{
					return getGCD(tempNum,tempDenom);
				}
			}
		}else if (denom > num){
			
		}else{
			return 1;
		}
		
	}

	/**
	 * toString(): Checks the working status of String's .split() 
	 * @return the representation of this Fraction object as a String.
	 */
	public String toString()
	{
		return this.numerator + "/" + this.denominator;
	}
	/**
	 * @return this Fraction's numerator value.
	 */
	public int getNumerator(){
		return this.numerator;
	}
	/**
	 * @return this Fraction's denominator value.
	 */
	public int getDenominator(){
		return this.denominator;
	}
	/**
	 * @param other
	 * @return boolean value representing the value equality of this Fraction and Fraction other.
	 */
	public boolean equals(Fraction other){
		return (this.numerator == other.getNumerator() && 
				this.denominator == other.getDenominator());
	}
}
