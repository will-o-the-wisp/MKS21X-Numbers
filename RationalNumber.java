public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
      super(0);//this value is ignored!
      if(deno == 0){
        numerator = 0;
        denominator = 1;
      }
      else {
        numerator = nume;
        denominator = deno;
      }
      this.reduce();
  }

  public double getValue(){
    return (double)getNumerator()/(double)getDenominator();//???
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
      return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
      return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
      return new RationalNumber(getDenominator(),getNumerator());
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return (getNumerator()==other.getNumerator() && getDenominator()==other.getDenominator());
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    if(getDenominator() == 1) {
      return getNumerator() + "";
    }
    else if(getNumerator() == 0){
      return "0";
    }
    else {
      return getNumerator() + "/" + getDenominator();
    }
  }



  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    /*use euclids method or a better one*/
    int big = a;
    int small = b;
    int prev;
    while (small > 0) {
      prev = small;
      small = big % small;
      big = prev;
    }
    return big;
  }



  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int gcd = gcd(Math.abs(numerator),Math.abs(denominator));
    numerator = numerator/gcd;
    denominator = denominator/gcd;
    if(denominator < 0){
      numerator = -1*numerator;
      denominator = -1*denominator;
    }
  }



  /******************Operations!!!!****************/


  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    return new RationalNumber(getNumerator()*other.getNumerator(),getDenominator()*other.getDenominator());
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return this.multiply(other.reciprocal());
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    return new RationalNumber (getNumerator()*other.getDenominator()+other.getNumerator()*getDenominator(),
      getDenominator()*other.getDenominator());
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    return new RationalNumber (getNumerator()*other.getDenominator()-other.getNumerator()*getDenominator(),
      getDenominator()*other.getDenominator());
  }
}
