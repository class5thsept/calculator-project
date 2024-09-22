package edu.grinnell.csc207.util;

import java.math.BigInteger;

/**
 * Util class that executes the calculator's operations.
 *
 * @author Leonardo Alves Nunes
 */
public class BFCalculator {
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+
  BigFraction lastValue;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  public BFCalculator(BigFraction lastValue) {
    this.lastValue = lastValue;
  } // BFCalculator(BigFraction)

  public BFCalculator() {} // BFCalculator

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+
  public BigFraction get() {
    return this.lastValue;
  } // get(BigFraction)

  public void add(BigFraction val) {
    BigFraction result = val.add(lastValue);

    if (result.denom.equals(BigInteger.valueOf(1))) {
      System.out.println(result.num);
    } else {
      System.out.println(result.num + "/" + result.denom);
    } // if else
  } // add(BigFraction)

  public void subtract(BigFraction val) {
    BigFraction result = val.subtract(lastValue);

    if (result.denom.equals(BigInteger.valueOf(1))) {
      System.out.println(result.num);
    } else {
      System.out.println(result.num + "/" + result.denom);
    } // if else
  } // substract(BigFraction)

  public void multiply(BigFraction val) {
    BigFraction result = val.multiply(lastValue);

    if (result.denom.equals(BigInteger.valueOf(1))) {
      System.out.println(result.num);
    } else {
      System.out.println(result.num + "/" + result.denom);
    } // if else
  } // multiply(BigFraction)

  public void divide(BigFraction val) {
    BigFraction result = val.multiply(lastValue);

    if (result.denom.equals(BigInteger.valueOf(1))) {
      System.out.println(result.num);
    } else {
      System.out.println(result.num + "/" + result.denom);
    } // if else
  } // divide(BigFraction)

  public void clear() {
    this.lastValue.num = BigInteger.valueOf(0);
    this.lastValue.denom = BigInteger.valueOf(1);
  } // clear
} // class BFCalculator
