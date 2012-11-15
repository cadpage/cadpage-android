package net.anei.cadpage.parsers.NJ;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/**
 * Mercer County, NJ
 */
public class NJMercerCountyParser extends FieldProgramParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("; Disp: ?\\d\\d:\\d\\d;");
  
  
  public NJMercerCountyParser() {
    super("MERCER COUNTY", "NJ",
           "UNIT:UNIT! CALL:CALL! PLACE:PLACE! ADDR:ADDR! BLDG:APT! APT:APT! CITY:CITY! XSTREETS:X! ID:ID! DATE:DATE! TIME:TIME! INFO:INFO");
  }
  
  @Override
  public String getFilter() {
    return "noreply_lifecomm@verizon.net";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    if (RUN_REPORT_PTN.matcher(body).find()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    
    return super.parseFields(body.split(";"), data);
  }
}
