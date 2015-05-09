package net.anei.cadpage.parsers.ID;

import net.anei.cadpage.parsers.dispatch.DispatchA22Parser;


public class IDGoodingCountyBParser extends DispatchA22Parser {
  
  public IDGoodingCountyBParser() {
   this("GOODING COUNTY", "ID");
  }
  
  public IDGoodingCountyBParser(String defCity, String defState) {
    super(defCity, defState);
  }
  
  @Override
  public String getFilter() {
    return "PagingService@sircomm.com";
  }

  @Override
  public String getAliasCode() {
    return "IDGoodingBCounty";
  }
}
