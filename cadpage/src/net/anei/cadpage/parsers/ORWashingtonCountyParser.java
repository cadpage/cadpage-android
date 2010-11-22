package net.anei.cadpage.parsers;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
Washington County, OR
Contact: Phillip Duncan <phil860@gmail.com>
Sender:  930010001-0050

MVA-UKN INJURY SW TUALATIN VALLEY HW/SW331ST AV (33098 TUALATIN VALLEY/331ST) HIL MAP: 5377D UNIT: C2 E01 R8
ABDOMINAL PAIN 985 N DAVIS ST (DEAD END & N 10TH AV) CON MAP: 5375D UNIT METWA STA8
BREATHING PROB 39470 SW GEIGER RD (SW LAFOLLETT RD & FERN HILL RD) CON MAP: 5574B UNIT: METWA STA8
SICK PERSON/UNKO 1045 N ADAIR ST (N 10TH AV & N 10TH-11TH AL) CON MAP: 5375D UNIT: METWA STA8
RESIDENTIAL FIRE 822 N 28TH AV (N HOLLADAY DR & N 27TH AV) CON MAP: 5376D UNIT: METWA TIMERC CAS8 CFDUTY SIRN08 E813 E814 E815 E421 R8 T03 COCB1
*/

public class ORWashingtonCountyParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "OR";
  private static final String DEF_CITY = "WASHINGTON COUNTY";
  
  private static final String[] KEYWORDS = new String[]{
    "LOC", "MAP", "UNIT"
  };
  
  private static final Properties CITY_TABLE = buildCodeTable(new String[]{
      "HIL", "HILLSBORO",
      "CON", "CORNELIUS",
      "FG",  "FOREST GROVE"
  });
  
  public ORWashingtonCountyParser() {
    super(DEF_STATE);
  }

  @Override
  public boolean isPageMsg(String body) {
    return body.contains(" MAP:");
  }

  @Override
  protected void parse(String body, Data data) {

    data.defState=DEF_STATE;
    data.defCity=DEF_CITY;

    Properties props = parseMessage("LOC:" + body, KEYWORDS);
    
    Parser p = new Parser(props.getProperty("LOC", ""));
    data.strCity = p.getLastOptional(')');
    if (data.strCity.length() > 0) {
      data.strCross = p.getLastOptional('(');
    } else {
      data.strCity = p.getLast(' ');
    }
    
    data.strCity = convertCodes(data.strCity, CITY_TABLE);
    
    parseAddress(StartType.START_CALL, p.get(), data);
    
    data.strMap = props.getProperty("MAP", "");
    data.strUnit = props.getProperty("UNIT", "");
  }
}
