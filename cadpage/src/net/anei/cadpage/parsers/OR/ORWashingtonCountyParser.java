package net.anei.cadpage.parsers.OR;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Washington County, OR
Contact: Phillip Duncan <phil860@gmail.com>
Sender:  930010001-0050

MVA-UKN INJURY SW TUALATIN VALLEY HW/SW331ST AV (33098 TUALATIN VALLEY/331ST) HIL MAP: 5377D UNIT: C2 E01 R8
ABDOMINAL PAIN 985 N DAVIS ST (DEAD END & N 10TH AV) CON MAP: 5375D UNIT METWA STA8
BREATHING PROB 39470 SW GEIGER RD (SW LAFOLLETT RD & FERN HILL RD) CON MAP: 5574B UNIT: METWA STA8
SICK PERSON/UNKO 1045 N ADAIR ST (N 10TH AV & N 10TH-11TH AL) CON MAP: 5375D UNIT: METWA STA8
RESIDENTIAL FIRE 822 N 28TH AV (N HOLLADAY DR & N 27TH AV) CON MAP: 5376D UNIT: METWA TIMERC CAS8 CFDUTY SIRN08 E813 E814 E815 E421 R8 T03 COCB1

Clackamas County, OR
Contact: Tyree Zander <tzander.depoebayfire@gmail.com>
Sender: 777109496789
    UNCON/FAINTING 37905 SE SERBAN RD (SE BLUFF RD & SE BAUMBACK RD) SAN MAP: 6013B UNIT: E74 M1
    
Contact: zak delair <zakdelair117@gmail.com>
Sender: 93001003
UNK PROB/MN DOWN 95 82ND DR (SAFEWAY (GLADSTONE)) GLA MAP: 6398D UNIT: R101 M1

Contact: Active911
[] PRE NOTIFICATION 59185 E CHALET PL (DEAD END & E EAST RD) SAN MAP: 6324A UNIT: SQ252 SQ251 M1 2509\r\n\r\n\n
[] BREATHING PROB. 59185 E CHALET PL (DEAD END & E EAST RD) SAN MAP: 6324A UNIT: SQ252\r\n\r\n\n
[] PRE NOTIFICATION 59454 E SLEEPY HOLLOW DR (E EAST RD & E BARLOW TRAIL RD) SAN MAP: 6324B UNIT: SQ252 SQ251 M1 2509\r\n\r\n\n
[] PRE NOTIFICATION 27160 E MARION RD (E ROAD 10 & E ROAD 20) RHO MAP: 6731A UNIT: SQ252 M1 3709\r\n\r\n\n
[] PRE NOTIFICATION 59454 E SLEEPY HOLLOW DR (E EAST RD & E BARLOW TRAIL RD) SAN MAP: 6324B UNIT: SQ252 SQ251 M1 2509\r\n\r\n\n
[] UNKNOWN TYP FIRE 31315 E MULTORPOR DR (SKI BOWL (EAST)) GOV MAP: 6939 UNIT: E251 E254 2509\r\n\r\n\n
[] FIRE ALARM, COMM 30521 E MELDRUM ST (E LIGE LN & E GOVERNMENT CAMP LP) GOV MAP: 6939 UNIT: E251 E254 WT251 2509\r\n\r\n\n

*/

public class ORWashingtonCountyParser extends FieldProgramParser {
  
  public ORWashingtonCountyParser() {
    this("WASHINGTON COUNTY", "OR");
  }
  
  public ORWashingtonCountyParser(String defCity, String defState) {
    super(defCity, defState,
           "ADDR/SC! MAP:MAP! UNIT:UNIT!");
  }
  
  @Override
  public String getAliasCode() {
    return "ORWashingtonCounty";
  }
  
  @Override
  public String getFilter() {
    return "930010,777";
  }

  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String addr;
      String city = p.getLastOptional(')');
      if (city.length() > 0) {
        addr = p.get('(');
        data.strCross = p.get();
      } else {
        city = p.getLast(' ');
        addr = p.get();
      }
      parseAddress(StartType.START_CALL, addr, data);
      data.strCity = convertCodes(city, CITY_CODES);
      
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " X CITY";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BRI", "BRIGHTWOOD",
      "HIL", "HILLSBORO",
      "CON", "CORNELIUS",
      "EAG", "EAGLE CREEK",
      "FOR", "FOREST GROVE",
      "GLA", "GLADSTONE",
      "GOV", "GOVERNMENT CAMP",
      "RHO", "RHODODENDRON",
      "SAN", "SANDY",
      "WEL", "WELCHES"
 });
}
