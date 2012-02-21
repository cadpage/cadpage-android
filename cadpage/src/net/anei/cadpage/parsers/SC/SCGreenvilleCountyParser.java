package net.anei.cadpage.parsers.SC;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/*
Greenville County, SC
Contact: Jrrichards1775@yahoo.com,8644440080@vtext.com

CAD:ACKNOWLEDGE CALL;105 CRIMSON GLORY WAY; TRAV;(S) (N)19V
CAD:FALLS;105 CRIMSON GLORY WAY;TRAV;MIRANDY CT;TINEKE WAY;(S) (N)19V;NG1
CAD:FIRE ALARM;8 ANDERS RD;GRVL;OLD MCELHANEY RD;(S) (N)24F;Kristy- AOA: sprinkler trip [04/26/11 12:28:12 THILL] ;NG1
CAD:ACKNOWLEDGE CALL;8 ANDERS RD; GRVL;(S) (N)24F
CAD:FIRE ALARM;32 HUNT ST;TRAV;ELIZABETH LN;ELIZABETH LN;(S) (N)17O;NAME: CHARLA SMITH, [04/26/11 13:34:03 THILL] SMOKE ALARM GOING OFF [04/26/11 13:33:49
CAD:ACKNOWLEDGE CALL;32 HUNT ST; TRAV;(S) (N)17O
CAD:ACKNOWLEDGE CALL;32 HUNT ST; TRAV;(S) (N)17O
CAD:FALLS;124 JAMISON RD;TRAV;FARMINGTON TRL;WEBB CREEK CT;(S) (N)18F;NG1

Contact: Kenneth Gosnell <ki4rdl@gmail.com>
Sender: 8643850725
CAD:DIABETIC PROBLEM;518 GOFORTH RD;LAND;BUTTER ST;BUTTER ST;(S) (N)4H;GM1
CAD:ABDOMINAL PAIN;178 DUFFS MOUNTAIN RD;MARI;DIST: 63.24 FT (S) (N)7H;GM1

Contact: Tare Kennedy <tare@owen-kennedy.com>
Sender: 8643850725
CAD:FALLS;70 LATIMER RIDGE RD;HONE;CORN RD;(S) (N)86O;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 76 year old, Male, Conscious, Breathing. Falls.
CAD:STROKE OR TIA;271 GREY RD;PELZ;DIST: 280.66 ft (S) (N)80V;243-3091 [01/04/12 06:30:45 CCHILDRESS] [Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT
CAD:OUTSIDE FIRE;419 CEDAR FALLS RD;FOUN;SWEET WATER RD;DUNKLIN BRIDGE RD;DIST: 86.71 ft (S) (N)80R;DK1
CAD:STRUCTURE FIRE;10612 AUGUSTA RD;BELT;BOYS HOME OF THE SOUTH;DAVENTON RD;KERMIT WATSON BLVD;DIST: 715.97 ft (S) (N)86A;DK1

 */


public class SCGreenvilleCountyParser extends DispatchOSSIParser {
  
  private static Properties CITY_CODES = buildCodeTable(new String[]{
      "BELT", "BELTON",
      "FOUN", "FOUNTAIN INN",
      "GRVL", "GREENVILLE",
      "HONE", "HONES PATH",
      "LAND", "LANDRUM",
      "MARI", "MARIETTA",
      "PELZ", "PELZER",
      "TRAV", "TRAVELERS REST"
  });
  
  public SCGreenvilleCountyParser() {
    super(CITY_CODES, "GREENVILLE COUNTY", "SC",
           "CALL ADDR CITY X/Z+? MAP NAME:NAME? INFO+");
  }
  
  private class MyMapField extends MapField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("(S) (N)")) return false;
      field = field.substring(7).trim();
      super.parse(field, data);
      return true;
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("MAP")) return new MyMapField();
    return super.getField(name);
  }
}
