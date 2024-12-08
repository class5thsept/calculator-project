package edu.grinnell.csc207.util;

import java.math.BigInteger;

/**
 * Util class that defines the operations, denominator and numerator of a BigFrac.
 *
 * @author Leonardo Alves Nunes
 */
public class BigFraction {
  /**
   * All numbers are divided by one to match fraction pattern.
   */
  private static final BigInteger DEFAULT_DENOMINATOR = BigInteger.valueOf(1);
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * Numerator of the fraction (top number).
   */
  BigInteger num;

  /**
   * Denominator of the fraction (bottom number).
   */
  BigInteger denom;


  /**
   * Common divisor between numerator and denominator.
   */
  BigInteger commonDivisor;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Creates a fraction with a given numeratttor and denominator.
   * @param numerator
   * @param denominator
   */
  public BigFraction(BigInteger numerator, BigInteger denominator) {
    this.num = numerator;
    this.denom = denominator;

    this.commonDivisor = this.denom.gcd(this.num);
    this.num = this.num.divide(commonDivisor);
    this.denom = this.denom.divide(commonDivisor);
  } // BigFraction(BigInteger,BigInteger)

  /**
   * Creates a BigFraction given a numerator and denominator.
   * @param numerator
   * @param denominator
   */
  public BigFraction(int numerator, int denominator) {
    this.num = BigInteger.valueOf(numerator);
    this.denom = BigInteger.valueOf(denominator);

    this.commonDivisor = this.denom.gcd(this.num);
    this.num = this.num.divide(commonDivisor);
    this.denom = this.denom.divide(commonDivisor);
  } // BigFraction(int, int)

  /**
   * Creates a bigfraction given its string format(e.g. "1/2").
   * @param str
   */
  public BigFraction(String str) {
    if (str.contains("/")) {
      String[] parsed = str.split("/");
      this.num = BigInteger.valueOf(Integer.parseInt(parsed[0]));
      this.denom = BigInteger.valueOf(Integer.parseInt(parsed[1]));

      this.commonDivisor = this.denom.gcd(this.num);
      this.num = this.num.divide(commonDivisor);
      this.denom = this.denom.divide(commonDivisor);
    } else {
      this.num = BigInteger.valueOf(Integer.parseInt(str));
      this.denom = DEFAULT_DENOMINATOR;

      this.commonDivisor = this.denom.gcd(this.num);
      this.num = this.num.divide(commonDivisor);
      this.denom = this.denom.divide(commonDivisor);
    } // if else
  } // BigFraction(str)

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get the denominator of a fraction.
   *
   * @return BigInteger.
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()

  /**
   * Get the numerator of a fraction.
   *
   * @return BigInteger.
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()

  /**
   * Adds two fractions.
   *
   * @param val
   *   The fraction to be added.
   *
   * @return BigFraction.
   */
  public BigFraction add(BigFraction val) {
    BigInteger newNumerator = val.denominator().multiply(this.numerator())
        .add(val.numerator().multiply(this.denominator()));

    BigInteger newDenominator = val.denominator().multiply(this.denominator());

    this.commonDivisor = newDenominator.gcd(newNumerator);

    newNumerator = newNumerator.divide(commonDivisor);
    newDenominator = newDenominator.divide(commonDivisor);

    return new BigFraction(newNumerator, newDenominator);
  } // add(BigFraction)

  /**
   * Subtracts two fractions.
   *
   * @param val
   *   The fraction to be subtracted.
   *
   * @return BigFraction.
   */
  public BigFraction subtract(BigFraction val) {
    BigInteger newNumerator = this.numerator().multiply(val.denominator())
        .subtract(this.denominator().multiply(val.numerator()));

    BigInteger newDenominator = val.denominator().multiply(this.denominator());

    this.commonDivisor = newDenominator.gcd(newNumerator);
    newNumerator = newNumerator.divide(commonDivisor);
    newDenominator = newDenominator.divide(commonDivisor);

    return new BigFraction(newNumerator, newDenominator);
  } // subtract(BigFraction)

  /**
   * Multiplies two fractions.
   *
   * @param val
   *   The fraction to be multiplied by.
   *
   * @return BigFraction.
   */
  public BigFraction multiply(BigFraction val) {
    BigInteger newNumerator = val.numerator().multiply(this.numerator());
    BigInteger newDenominator = val.denominator().multiply(this.denominator());

    this.commonDivisor = newDenominator.gcd(newNumerator);
    newNumerator = newNumerator.divide(commonDivisor);
    newDenominator = newDenominator.divide(commonDivisor);

    return new BigFraction(newNumerator, newDenominator);
  } // multiply(BigFraction)

  /**
   * Divides two fractions.
   *
   * @param val
   *   The fraction to be divided by.
   *
   * @return BigFraction.
   */
  public BigFraction divide(BigFraction val) {
    BigInteger newNumerator = this.num.multiply(val.denominator());
    BigInteger newDenominator = this.denom.multiply(val.numerator());

    this.commonDivisor = newNumerator.gcd(newDenominator);
    newNumerator = newNumerator.divide(commonDivisor);
    newDenominator = newDenominator.divide(commonDivisor);

    return new BigFraction(newNumerator, newDenominator);
  } // divide(BigFraction)

  /**
   * Translate a fraction into the format num/demon as a string.
   * @return the string format of the fraction.
   */
  public String toString() {
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if
    if (this.denom.equals(BigInteger.ONE)) {
      return this.num + "";
    } // if
    return this.num + "/" + this.denom;
  } // toString()
} // divide (BigFraction val)
