package net.anei.cadpage.parsers.TX;


import net.anei.cadpage.parsers.dispatch.DispatchRedAlertParser;


public class TXTarrantCountyParser extends DispatchRedAlertParser {
  
  public TXTarrantCountyParser() {
    super("TARRANT COUNTY","TX");
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
}
