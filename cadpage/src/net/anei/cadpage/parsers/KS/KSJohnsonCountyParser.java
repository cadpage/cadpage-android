package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
/**
 * Johnson County, KS
 */
public class KSJohnsonCountyParser extends FieldProgramParser {

  public KSJohnsonCountyParser() {
    super("JOHNSON COUNTY", "KS",
           "Add:ADDR! Apt:APT Loc:PLACE Nature:CALL! Grid:MAP! Incident:ID Cross:X");
  }
  
  @Override
  public String getFilter() {
    return "93001,ecc1@jocogov.org,ecc2@jocogov.org,ecc3@jocogov.org,@jocofd1.org,@jocoems.org";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    body = body.replaceAll("Incident#", "Incident:");
    return super.parseMsg(body, data);
  }
}
