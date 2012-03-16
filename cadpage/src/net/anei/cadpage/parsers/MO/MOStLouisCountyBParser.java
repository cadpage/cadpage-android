package net.anei.cadpage.parsers.MO;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
St Louis County, MO
Contact: Steve <steve@stlouisarsenal.com>
Sender: alert@scfa911.org

(Dispatch) DIFFICULTY BREATHING \n\n1762 LEMAY FERRY RD, Apt. APT 313 \n1617 \nMapRegions: L29-49, LE Card # 4143 CrossStreets: LE Card# 4143 0.00 mi \nCall Number: 7182
(Dispatch) ANIMAL BITE \n\n325 W ARLEE AVE \n1117 1614 \nMapRegions: K29-49, LE Card # 4271 CrossStreets: LE Card# 4271 0.00 mi \nCall Number: 718281
(Dispatch) FALL \n\n2116 KEVIN DR \n1617 \nMapRegions: K30-49, LE Card # 4130 CrossStreets: LE Card# 4130 0.00 mi \nCall Number: 718280
(Dispatch) OBS \n\n812 DAMMERT AVE \n1617 \nMapRegions: K29-49, LE Card # 4064 CrossStreets: LE Card# 4064 0.00 mi \nCall Number: 718269
(Dispatch) SICK CASE \n\n115 W ETTA AVE \n1614 \nMapRegions: K29-49, LE Card # 4273 CrossStreets: LE Card# 4273 0.00 mi \nCall Number: 718257
(Dispatch) AMBT \n\n4400 BIG CHIEF DR \n1617 1134 \nMapRegions: AF Card# 3031, L28-49 CrossStreets: AZTEC DR 0.01 mi E TURQUOISE DR 0.06 mi NW \nCall Number: 718255
(Dispatch) DIFFICULTY BREATHING \n\n1762 LEMAY FERRY RD, Apt. APT 313 \n1617 \nMapRegions: L29-49, LE Card # 4143 CrossStreets: LE Card# 4143 0.00 mi \nCall Number: 7182
(Dispatch) VEHACC \n\nGREEN PARK RD & REAVIS BARRACKS RD \n1710 1614 1757 \nMapRegions: L29-49, LE Card # 4107, LE Card # 4201, ME Card# 1665, ME Card# 747 CrossStreets
(Dispatch) ASTFIR \n\n317 EAST DAVIS \n1614 \nMapRegions:  CrossStreets: \nCall Number: 718231
(Dispatch) ACCIDENTAL INJURY \n\n373 TUCKAHOE DR \n1617 \nMapRegions: K31-59, LE Card # 4248 CrossStreets: LE Card# 4248 0.00 mi \nCall Number: 718226
(Dispatch) VEHACC \n\nLEMAY FERRY RD & FANNIE AVE \n1614 1617 \nMapRegions: K28-49, LE Card # 4299 CrossStreets: \nCall Number: 718216

*/


public class MOStLouisCountyBParser extends FieldProgramParser {
  
  public MOStLouisCountyBParser() {
    super("ST LOUIS COUNTY", "MO",
          "CALL CALL ADDR UNIT! MapRegions:MAP! CrossStreets:X Call_Number:ID");
  }
  
  @Override
  public String getFilter() {
    return "alert@scfa911.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch")) return false;
    body = body.replace(" CrossStreets:", "\nCrossStreets:");
    return parseFields(body.split("\n"), 5, data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String sApt = null;
      int pt = field.indexOf(',');
      if (pt >= 0) {
        sApt = field.substring(pt+1).trim();
        if (sApt.startsWith("Apt. ")) sApt = sApt.substring(5).trim();
        if (sApt.startsWith("APT ")) sApt = sApt.substring(4).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
      if (sApt != null) {
        data.strApt = append(data.strApt, "-", sApt);
      }
    }
  }
  
  private static final Pattern MAP_PTN = Pattern.compile("[A-Z]\\d\\d-\\d\\d");
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(',');
      if (pt >= 0) {
        String p1 = field.substring(0,pt).trim();
        String p2 = field.substring(pt+1).trim();
        if (MAP_PTN.matcher(p1).matches()) {
          field = p1;
          data.strSupp = p2;
        } else if (MAP_PTN.matcher(p2).matches()) {
          field = p2;
          data.strSupp = p1;
        }
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "MAP INFO";
    }
  }
  
  private static final Pattern CARD_PTN = Pattern.compile("\\b[A-Z]{2} Card# \\d{4} 0\\.00 mi\\b");
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = CARD_PTN.matcher(field).replaceAll("").trim();
      field = field.replaceAll("  +", " ");
      super.parse(field, data);
      
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
}
