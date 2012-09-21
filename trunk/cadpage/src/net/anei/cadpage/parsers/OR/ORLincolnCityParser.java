package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*    
Lincoln City, OR
Contact: Andrew Cooper <andrew.cooper1@live.com>
Sender: Group_Page_Notification@usamobility.net

UNKMED1 NLF () Loc:1550 SE 14TH ST: 5 Rcvd: 12:10:54 Units: D1141 E12133366 Comments: 75 YO FEMALE SEVERE MIGRANE HEADAC
FIRES NLF () Loc:1543 NE 14TH ST Rcvd: 20:57:13 Units: C1161 E12129759 Comments: STRUCTURE FIRE HYDE PARK [75]
WATER1 NLF () Loc:NW LOGAN RD & ACCESS Rcvd: 13:51:1 Units: D1141 E12130984 Comments: 3 KIDS OUT SURFING 200 YARDS SOUT
FALL1 NLF () Loc:175 SILETZ HW Rcvd: 00:10:35 Units: Q1636 E12127387 Comments: MEDICS REQUESTING ASSIST WITH LIFT ASSIST
ACC1 NLF () Loc:NE 20TH PL & NE WEST DEVILS LAKE RD Rcvd: 12:40:26 Units: D1141 E12112828 Comments: SINGLE VEH MVA UNK INJURY LIGHT SMOKE FROM

*/

public class ORLincolnCityParser extends FieldProgramParser {
  
  public ORLincolnCityParser() {
    super("LINCOLN CITY", "OR",
          "CALL! Loc:ADDR Rcvd:TIME! Units:UNIT! Comments:INFO");
  }
  
  @Override
  public String getFilter() {
    return "Group_Page_Notification@usamobility.net";
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (!field.endsWith(" ()")) abort();
      field = field.substring(0,field.length()-3).trim();
      super.parse(field, data);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.lastIndexOf(':');
      if (pt >= 0) {
        data.strApt = field.substring(pt+1).trim();
        field = field.substring(0,pt);
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
