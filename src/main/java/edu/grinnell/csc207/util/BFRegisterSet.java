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
  } 

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+
  public void store(char register, BigFraction val) {
    stores[(int) register - 97] = val;

  } // store(char,BigFraction)

  public BigFraction get(char register) {
    return stores[(int) register - 97];
  } // get(char)
 } // BFRegisterSet
