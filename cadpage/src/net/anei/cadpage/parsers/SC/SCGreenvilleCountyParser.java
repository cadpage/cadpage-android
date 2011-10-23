package net.anei.cadpage.parsers.SC;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;
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

 */


public class SCGreenvilleCountyParser extends DispatchOSSIParser {
  
  private static Properties CITY_CODES = buildCodeTable(new String[]{
      "GRVL", "GREENVILLE",
      "LAND", "LANDRUM",
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
