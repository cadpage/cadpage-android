package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

/**
 * Davie County, NC
 */
public class NCDavieCountyBParser extends DispatchA3Parser {
  
  public NCDavieCountyBParser() {
    super("911:Call#", "DAVIE COUNTY", "NC",
          "ID Address:ADDR! APT APT! City:CITY! X X MAP Location:INFO1! Complaint:CODE% Desc:CALL% Caller:NAME Ph#:PHONE Units:UNIT SKIP INFO+");
  }
  
  @Override
  public String getFilter() {
    return "911@co.davie.nc.us";
  }
  
  @Override
  public String getSponsor() {
    return "Davie County";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace(" LocCmmt:", " Location:").replace(" Comp:", " Complaint:").replace(" PH#:", " Ph#");
    body = body.replace(" Description:", " Desc:");
    return super.parseMsg(body, data);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return WA_PTN.matcher(addr).replaceAll("WAY");
  }
  private static final Pattern WA_PTN = Pattern.compile("\\bWA\\b", Pattern.CASE_INSENSITIVE);
}
