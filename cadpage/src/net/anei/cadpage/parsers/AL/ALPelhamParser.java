package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.dispatch.DispatchA19Parser;
/**
 * Pelham, AL
 */
public class ALPelhamParser extends DispatchA19Parser {
  
  public ALPelhamParser() {
    super("PELHAM", "AL");
  }
  
  @Override
  public String getFilter() {
    return "myates@pelhamonline.com,dellann@pelhamonline.com,spillmancad@pelhamonline.com";
  }
}
