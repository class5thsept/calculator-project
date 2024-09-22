package edu.grinnell.csc207.util;

import java.math.BigInteger;

/**
 * Util class that defines the operations, denominator and numerator of a BigFrac.
 *
 * @author Leonardo Alves Nunes
 */
public class BigFraction {
  private static final BigInteger DEFAULT_DENOMINATOR = BigInteger.valueOf(1);
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+
  BigInteger num;
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+
  public BigFraction(BigInteger numerator, BigInteger denominator) {
    this.num = numerator;
    this.denom = denominator;

    BigInteger commonDivisor = this.denom.gcd(this.num);
    this.num = this.num.divide(commonDivisor);
    this.denom = this.denom.divide(commonDivisor);
  } // BigFraction(BigInteger,BigInteger)

  public BigFraction(int numerator, int denominator) {
    this.num = BigInteger.valueOf(numerator);
    this.denom = BigInteger.valueOf(denominator);

    BigInteger commonDivisor = this.denom.gcd(this.num);
    this.num = this.num.divide(commonDivisor);
    this.denom = this.denom.divide(commonDivisor);
  } // BigFraction(int, int)

  public BigFraction(String str) {
    if (str.contains("/")) {
      String[] parsed = str.split("/");
      this.num = BigInteger.valueOf(Integer.parseInt(parsed[0]));
      this.denom = BigInteger.valueOf(Integer.parseInt(parsed[1]));

      BigInteger commonDivisor = this.denom.gcd(this.num);
      this.num = this.num.divide(commonDivisor);
      this.denom = this.denom.divide(commonDivisor);
    } else {
      this.num = BigInteger.valueOf(Integer.parseInt(str));
      this.denom = DEFAULT_DENOMINATOR;

      BigInteger commonDivisor = this.denom.gcd(this.num);
      this.num = this.num.divide(commonDivisor);
      this.denom = this.denom.divide(commonDivisor);
    } // if else
  } // BigFraction(str)

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  public BigInteger denominator() {
    return this.denom;
  } // denominator()

  public BigInteger numerator() {
    return this.num;
  } // numerator()


  public BigFraction add(BigFraction val) {
    this.num = val.denominator().multiply(this.numerator())
        .add(val.numerator().multiply(this.denominator()));

    this.denom = val.denominator().multiply(this.denominator());

    BigInteger commonDivisor = this.denom.gcd(this.num);
    this.num = this.num.divide(commonDivisor);
    this.denom = this.denom.divide(commonDivisor);

    return this;

  } // add(BigFraction)

  public BigFraction subtract(BigFraction val) {
    this.num = val.numerator().multiply(this.denominator())
        .subtract(val.denominator().multiply(this.numerator()));

    this.denom = val.denominator().multiply(this.denominator());

    BigInteger commonDivisor = this.denom.gcd(this.num);
    this.num = this.num.divide(commonDivisor);
    this.denom = this.denom.divide(commonDivisor);

    return this;

  } // subtract(BigFraction)

  public BigFraction multiply(BigFraction val) {
    this.num = val.numerator().multiply(this.numerator());

    this.denom = val.denominator().multiply(this.denominator());

    BigInteger commonDivisor = this.denom.gcd(this.num);
    this.num = this.num.divide(commonDivisor);
    this.denom = this.denom.divide(commonDivisor);

    return this;
  } // multiply(BigFraction)

  public BigFraction divide(BigFraction val) {
    BigInteger resultNumerator = this.numerator();
    BigInteger resultDenominator = this.denominator();

    resultNumerator = resultNumerator.multiply(val.denominator());

    resultDenominator = resultDenominator.multiply(val.numerator());

    BigInteger commonDivisor = resultNumerator.gcd(resultDenominator);
    this.num = resultNumerator.divide(commonDivisor);
    this.denom = resultDenominator.divide(commonDivisor);

    return new BigFraction(this.num, this.denom);
  } // divide(BigFraction)

  public String toString() {
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if 
    return this.num + "/" + this.denom;
  } // toString()
}
