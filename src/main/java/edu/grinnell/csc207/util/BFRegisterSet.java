package edu.grinnell.csc207.util;

/**
 * Util class for the register, which is used for storing values.
 *
 * @author Leonardo Alves Nunes
 */
public class BFRegisterSet {
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+
  BigFraction[] stores = new BigFraction[26];

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+
  public BFRegisterSet() {
    this.stores[0] = new BigFraction("1/1");
  } // BFRegisterSet()

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Stores the current value of the calculator at a letter.
   *
   * @param register
   *   letter(location) to be stored.
   * 
   * @param val
   *   value to be stored in the register.
   * 
   * @return void.
   */
  public void store(char register, BigFraction val) {
    stores[(int) register - 97] = val;
  } // store(char,BigFraction)

  /**
   * Get a value from a specified location in the register.
   *
   * @param register
   *   letter(location) to be searched.
   * 
   * @return BigFraction.
   */
  public BigFraction get(char register) {
    return stores[(int) register - 97];
  } // get(char)
} // BFRegisterSet
