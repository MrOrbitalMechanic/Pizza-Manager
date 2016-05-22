/**
 * 
 * @author Roman Zhang
 * Fraction: represents a simple fraction: An integer numerator value and an integer denominator value.
 */
public class Fraction {
	
	public static void main(String args[]){
		//Fraction myFrac = new Fraction(2,16);
		System.out.println(getGCD(54, 10));
	}
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
		//this.numerator = Integer.parseInt(fullFrac[0]);
		//this.denominator = Integer.parseInt(fullFrac[1]);
		
		if(Integer.parseInt(fullFrac[0]) != 0 || Integer.parseInt(fullFrac[1]) != 0){
			int GCD = getGCD(this.numerator, this.denominator);
			this.numerator = Integer.parseInt(fullFrac[0])/GCD;
			this.denominator = Integer.parseInt(fullFrac[1])/GCD;
		}else{throw new PizzaException("Numerator or denominator cannot be zero");}
	}
	
	//Copy constructor
	public Fraction(Fraction copy){
		this.numerator = copy.getNumerator();
		this.denominator = copy.getDenominator();
		
	}
	
	public Fraction(int num, int denom){
		if (num > 0 && denom > 0){
			int GCD = getGCD(this.numerator, this.denominator);
			this.numerator = num/GCD;
			this.denominator = denom/GCD;
		}else{throw new PizzaException("Numerator or denominator cannot be zero");}
	}
	    
	/**
	 * reduce():
	 * @return : If reducible - returns reduced form of the original Fraction.
	 * 			 If irreducible - returns the original Fraction
	 */
	private static int getGCD(int num, int denom){
		if (num == 1 || denom == 1){return denom;}
		else{/*Do Nothing*/}
		if (num > denom){
			int originalDenom = denom;
			while(num % denom != 1){
				if(num % denom == 0){
					return denom;
				}else{
					int tempNum = denom;
					int tempDenom = num % denom;
					num = tempNum;
					denom = tempDenom;
				}
			}return originalDenom;
		}else if (denom > num){
			int originalNum = num;
			while (denom % num != 1){
				if(denom % num == 0){
					return num;
				}else{
					int tempNum = denom % num;
					int tempDenom = num ;
					num = tempNum;
					denom = tempDenom;
				}
			}return originalNum;
		}else{
			return 1;
		}
		//return denom;
		
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
