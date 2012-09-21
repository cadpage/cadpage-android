package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*    
Cecil County, MD
Contact: "bradfordsnyder@verizon.net" <bradfordsnyder@verizon.net>
Sender: waterwitch73@zoominternet.net

ABDOMINAL PAIN\r\n01A01 (ABDOMINAL PAIN )\r\n35 N MAIN ST\r\nCENTER ST\r\nVANNORT DR\r\nPD\r\n12010817\r\n20:20:03\r\nMB 700  EMS OPS\r\n@A07 @PM1\r\n[P ABD PAIN ;22 YEAR OLD,
DIABETIC\n254 N MAIN ST\nVANNORT DR\nGRANITE AVE\nPD\n08:00:00\n[P DIABETIC ;81 YEAR OLD, FEMALE, CONSCIOUS, BREATHING.  DIABETICPROBLEMS.\n11021185\nEMS OPS
FALL\r\n\n17A01 (FALL )\r\n\n31 HEATHER LN @PILOT TRAVEL CENTER\r\n\nPV\r\n\n12010495\r\n\n04:47:10\r\n\nEMS OPS 0602\r\n\n@A06 P1 @A07\r\n\n[P MALE THAT FELL-POSSIBLE FX WRIST ;39 YEAR O
CHILD LOCKED IN AUTO\r\n\nCHILD (CHILD LOCKED IN AUTO)\r\n\n848 JACOB TOME MEMORIAL HWY\r\n\nWAIBEL RD\r\n\nDOWNIN LN\r\n\nPD\r\n\n12010532\r\n\n17:22:53\r\n\nOPS 6   704\r\n\n@E07 @A07\r\n\nBABY
[Update]\r\n\nOVERDOSE\r\n\n23C01 (OVERDOSE )\r\n\n11 LAGOON DR\r\n\nPD\r\n\n12010560\r\n\n12:18:18\r\n\nEMS     MB 701\r\n\n@A07 P1 @E07\r\n\n[P CARDIAC ARREST ;21 YEAR OLD, MALE, UNCONSCIOU
OVERDOSE\r\n\n23C01 (OVERDOSE )\r\n\n11 LAGOON DR\r\n\nPD\r\n\n12010560\r\n\n12:18:18\r\n\nEMS     MB 701\r\n\n@A07 @PM1\r\n\n[P CARDIAC ARREST ;21 YEAR OLD, MALE, UNCONSCIOUS, NOT BREATH
OVERDOSE\r\n\n23D01 (OVERDOSE )\r\n\n39 MAPLE HILL DR\r\n\nBUTTONWOOD LN\r\n\nBIRCH CT\r\n\nPD\r\n\n12010568\r\n\n17:54:55\r\n\nEMS OPS 701\r\n\n@A07 @PM1\r\n
GAS LEAK OUTSIDE\r\n\nGASOUT (GAS LEAK OUTSIDE )\r\n\nCONOWINGO RD / RT 222 - ROCK SPRING\r\n\nCONO\r\n\n12010571\r\n\n18:31:19\r\n\nFB 705  OPS 6\r\n\n@E07\r\n\nRT 1 RT 222 INTERSECTION 
HOUSE FIRE\r\n\nHOUSE (HOUSE FIRE )\r\n\n161 WILLARD DR\r\n\nSTITES LN\r\n\nLONGACRE DR\r\n\nNE\r\n\n12010825\r\n\n22:43:45\r\n\nFB 402  OPS 6\r\n\n@R04 @T04 @E04 @E04 @L04 @A04 @T08 @E05 @E0
FALL\r\n\n17D01 (FALL )\r\n\n188 SKYLINE DR\r\n\nCONO\r\n\n12010787\r\n\n10:10:41\r\n\nEMS OPS MB705\r\n\n@A07 @PM1\r\n\n[P MAN FELL OFF THE ROOF ;40 YEAR OLD, MALE, UNCONSCIOUS, BREATHIN
CHEST PAIN\n\n10D04 (CHEST PAIN )\n\n52 CRAIG CT\n\nCONO\n\n12005115\n\n21:13:22\n\nEMS OSP 0703\n\n@A07 @PM1\n\n443 655 0295 CEL[P HUSB HAVING CHEST PAINS ;51 YEAR OLD, MA

 */

public class MDCecilCountyDParser extends FieldProgramParser {

  public MDCecilCountyDParser() {
    super(CITY_CODES, "CECIL COUNTY", "MD",
           "CALL CODE? ADDR X/Z+? CITY ID? TIME! INFO+");
  }

  @Override
  public String getFilter() {
    return "waterwitch73@zoominternet.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(body.split("\n+"), 4, data);
  }

  private static final Pattern CODE_PTN = Pattern.compile("\\d{1,2}[A-Z]\\d{1,2}|[A-Z]{2,6}");
  private class MyCodeField extends CodeField {
    @Override
    public boolean checkParse(String field, Data data) {
      int pt = field.indexOf('(');
      if (pt >= 0) field = field.substring(0,pt).trim();
      if (! CODE_PTN.matcher(field).matches()) return false;
      data.strCode = field;
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('@');
      if (pt >= 0) {
        data.strPlace = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  private static final Pattern ID_PTN = Pattern.compile("\\d{8}");
  private static final Pattern OPS_PTN = Pattern.compile("\\bOPS\\b");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (ID_PTN.matcher(field).matches()) {
        if (data.strCallId.length() == 0) {
          data.strCallId = field;
          return;
        } else if (data.strCallId.equals(field)) return;
      }
      field = field.replaceAll("  +", " ");
      if (field.startsWith("@")) data.strUnit = field.replace("@", "");
      else if (OPS_PTN.matcher(field).find()) data.strChannel = field;
      else {
        if (field.startsWith("[")) field = field.substring(1).trim();
        super.parse(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "INFO ID UNIT CH";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("ID")) return new IdField("\\d{8}", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CONO", "CONOWINGO",
      "NE",   "NORTH EAST",
      "PD",   "PORT DEPOSIT",
      "PV",   "PERRYVILLE"
  });
}
