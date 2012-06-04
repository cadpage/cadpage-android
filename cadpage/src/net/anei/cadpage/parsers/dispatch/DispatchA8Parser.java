package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*

Madison County, NY
(Dispatch) Dispatch ** 15:16 ** CHEST PAIN ** 3578 MUTTON HILL RD , FENNER ( FRANCIS RD / WYSS R ** - ** KENT, GEORGE SR ** 315-655-2533 **
(Dispatch) Dispatch ** 17:21 ** ALARM - FIRE - COLLEGE ** 22 SULLIVAN , CAZENOVIA VILLAGE ( GREEN /) ** - ** CAZENOVIA COLLE ** 315-655-7271 **
Dispatch ** 21:35 ** BREATHING PROBLEM ** @HUBBARD HALL (5 SULLIVAN ST (CAZENOVIA VILLAGE ) ** HUBBARD HALL- **  **  **
Dispatch ** 21:42 ** WATER PROBLEM ** 3243 ROUTE 20 , NELSON ** - ** michael manion ** 6559325 **
Dispatch ** 16:22 ** BREATHING PROBLEM ** 4188 MEADOW HILL RD , CAZENOVIA ( / ROUTE 20) ** - **  **  **
Dispatch ** 21:42 ** WATER PROBLEM ** 3243 ROUTE 20 , NELSON ** - ** michael manion ** 6559325 **
FRM:lfdfire@verizon.net\nMSG:13:54 ** MVA - UNKNOWN ** OXBOW RD \\ CLOCKVILLE RD (, LINCOLN) ** - **  **  **
FRM:lfdfire@verizon.net\nMSG:00:20 ** UNCONSCIOUS/FAINTING ** 6765 OXBOW RD , LINCOLN ( INGALLS CORNER ** - ** HUGHES, DUANE ** 315-697-261 ** 
FRM:lfdfire@verizon.net\nMSG:07:04 ** BREATHING PROBLEM ** 6998 NELSON RD , LINCOLN ** - ** ROSEKRANS DOUGL ** 315-697-986 ** 

*/


public class DispatchA8Parser extends FieldProgramParser {

  private static final Pattern DELIM = Pattern.compile("\\*\\*");
  
  protected DispatchA8Parser(String defCity, String defState) {
    super(defCity, defState,
           "DISPATCH? TIME CALL ADDR PLACE NAME PHONE! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "cazfd@fdcms.com,cazfire1@windstream.net,lfdfire@verizon.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(DELIM.split(body), 6, data);
  }
  
  // Place field needs to strip off trailing dash
  // and is complete ignored if place was set in address field parsing
  private class BasePlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("-")) field = field.substring(1).trim();
      if (field.endsWith("-")) field = field.substring(0, field.length()-1).trim();
      
      if (field.startsWith("APT ")) {
        int pt = field.indexOf(',', 4);
        if (pt < 0) pt = field.indexOf(' ', 4);
        if (pt < 0) pt = field.length();
        data.strApt = field.substring(4,pt).trim();
        field = field.substring(Math.min(pt+1, field.length())).trim();
      }
      
      if (field.equals(data.strPlace)) return;
      data.strPlace = append(data.strPlace, " - ", field);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("DISPATCH")) return new SkipField("Dispatch", true);
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d(?::\\d\\d)?");
    if (name.equals("PLACE")) return new BasePlaceField();
    return super.getField(name);
  }
  
}
	