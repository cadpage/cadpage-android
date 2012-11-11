package net.anei.cadpage.parsers.PA;


import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;




public class PAClarionCountyParser extends DispatchBParser {
 
  public PAClarionCountyParser() {
    super(CITY_LIST, "CLARION COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@oes.clarion.pa.us";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("911-CENTER:");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.toUpperCase().endsWith(" BORO")) {
      data.strCity = data.strCity.substring(0,data.strCity.length()-5).trim();
    }
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "CALLENSBURG BORO",
    "CLARION BORO",
    "EAST BRADY BORO",
    "EMLENTON BORO",
    "FOXBURG BORO",
    "HAWTHORN BORO",
    "KNOX BORO",
    "NEW BETHLEHEM BORO",
    "RIMERSBURG BORO",
    "SHIPPENVILLE BORO",
    "SLIGO BORO",
    "ST PETERSBURG BORO",
    "STRATTANVILLE BORO",
    
    "ASHLAND TWP",
    "BEAVER TWP",
    "BRADY TWP",
    "CLARION TWP",
    "ELK TWP",
    "FARMINGTON TWP",
    "HIGHLAND TWP",
    "KNOX TWP",
    "LICKING TWP",
    "LIMESTONE TWP",
    "MADISON TWP",
    "MILLCREEK TWP",
    "MONROE TWP",
    "PAINT TWP",
    "PERRY TWP",
    "PINEY TWP",
    "PORTER TWP",
    "REDBANK TWP",
    "RICHLAND TWP",
    "SALEM TWP",
    "TOBY TWP",
    "WASHINGTON TWP"
  };
}