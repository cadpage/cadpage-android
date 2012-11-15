package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class PAWestmorelandCountyParser extends FieldProgramParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "HEMP_T",    "HEMPFIELD TWP",
      "MT_PLEAS_T","MT PLEASANT TWP",
      "N_HUNT_T",  "N HUNTINGDON TWP",
      "PENN_T",    "PENN TWP",
      "SEWICK_T",  "SEWICKELY TWP",
      
      "IRWIN_B",   "IRWIN",
      "MANOR_B",   "MANOR",
      "N_IRWIN_B", "NORTH IRWIN",
      "N_STANTN_B","NEW STANTON",
      "PENN_B",    "PENN",
      "SUTERSVL_B","SUTERSVILLE",
      "SW_GBG_B",  "SW GREENSBURG",
      "YNGWD_B",   "YOUNGWOOD"

  });
  
  public PAWestmorelandCountyParser() {
    super("WESTMORELAND COUNTY", "PA",
           "Loc:ADDR/S X-sts:X Inc:ID NATURE:CALL! CALLER:NAME TOC:SKIP Comments:INFO Response_text:SKIP Disp:UNIT");
  }
  
  @Override
  public String getFilter() {
    return "alert@emgcall.net,alert@emgcall.net,@ecm2.us,incident@wcvfd3.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace("Inc#:", "Inc:").replaceAll("\\s+", " ");
    
    if (!super.parseMsg(body, data)) return false;
    
    // Intersections go in the cross street and leave the Loc: field empty
    if (data.strAddress.length() == 0) {
      if (data.strCross.length() == 0) return false;
      data.strAddress = data.strCross;
      data.strCross = "";
    }
    return true;
  }
  
  // Address field parser
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String fld, Data data) {
      Parser p = new Parser(fld);
      data.strPlace = p.getLastOptional(":");
      if (data.strPlace.startsWith("@")) data.strPlace = data.strPlace.substring(1).trim(); 
      data.strCity = convertCodes(p.getLast(' '), CITY_CODES); 
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY PLACE";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
