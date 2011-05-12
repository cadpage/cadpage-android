package net.anei.cadpage.parsers.AL;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Lauderdale County, AL
Contact: Justin Gallien <jgfireemt@gmail.com>
Sender: 911paging@florenceal.org

PRI: KLEMS AD: 1688 COUNTY RD 31 CNTY  TIME: 21:12:32 EV: MD-BREATHING -:  CS1: DIXIELAND DR CS2: COUNTY RD 417 RE:  34YOM CHEST PAIN DIFFICULTY BREATHING
PRI: KLEMS AD: 101 HAYGOOD CIR CNTY  TIME: 20:30:29 EV: MD-FALL-MINOR -:  CS1: HWY 43 CS2: HWY 43 RE:  ALT# 931-242-1174 -087.544169 +34.975694 83 YOF FALL POSSIBLE HIP INJURY\
PRI: KLEMS AD: 1001 HWY 72 KILL: @MCDONALDS  TIME: 00:31:04 EV: MD-SEIZURE -:  CS1:  CS2:  RE:  ALT# 256-702-9165 -087.585777 +34.846252 20YOF ACTIVE SIEZURE
PRI: KLEMS TIME: 00:57:11 EV: MD-TRAUMA -:  CS1: HWY 72 CS2: COUNTY RD 29 RE:  6657301
PRI: GHVFD AD: 3479 COUNTY RD 25 CNTY  TIME: 04:22:42 EV: FIRE-STRUCTURE -: OTHER CS1: WEST FORK DR CS2: PRIVATE DRIVE RE:  ALT# 256-702-4551 -087.535736 +34.930687 BUILDING ON FIRE
PRI: KLVFD AD: J C MAULDIN HWY KILL  TIME: 16:28:30 EV: WRECK-INJURY -: BLOCKAGE CS1: HWY 72 CS2: BRUSH CREEK RD RE:  ALT# 256-810-6502 -087.556701 +34.856937 CALLER REPORTING WRECK UNKNOWN INJURIES
PRI: KLEMS AD: 830 LOCKE SIX RD KILL: @KILLEN PARK  TIME: 09:00:31 EV: MD-UNCONSCIOUS -:  CS1: PEDEN ST CS2: BRUSH CREEK RD RE:  ALT# 256-762-4010 -087.556701 +34.856937 7 YEAR OLD MALE HAS PASSED OUT IS BREATHING WIL BE AT THE FIELD IN THE HOLE
PRI: KLVFD AD: 1161 HWY 72 KILL: @FOODLAND  TIME: 14:37:33 EV: MD-TRAUMA -: SNAKEBIT CS1:  CS2:  RE:  ALT# 256-247-8813 -087.390038 +34.846100 CALLER ADVISED HER SON HAS BEEN BITTEN BY A COPPERHEAD SNAKE 38 YEAR OLD MALE HAS BEEN BITTEN ON THE HAND WILL BE DRIVING A GREEN PATHFINDER
PRI: EMA AD: LL(-87:39:45.5030,34:47:57.4231): @WEATHER  TIME: 01:55:09 EV: WEATHER -: TSTORM-WARNG CS1:  CS2:  RE:  SPECIAL ADDRESS COMMENT: no ad SEVERE THUNDERSTORM WARNING TIL 2:30AM

 */


public class ALLauderdaleCountyParser extends FieldProgramParser {
  
  private static final Properties CITY_TABLE = buildCodeTable(new String[]{
      "CNTY", "",
      "ANDE", "ANDERSON",
      "KILL", "KILLEN",
      "ROGE", "ROGERSVILLE",
      "STFL", "ST FLORIAN"
  });
  
  public ALLauderdaleCountyParser() {
    super(CITY_TABLE, "LAUDERDALE COUNTY", "AL",
        "PRI:SRC! AD:ADDR/S TIME:SKIP! EV:CALL! CS1:X CS2:X RE:INFO");
  }
  
  @Override
  public String getFilter() {
    return "911paging@florenceal.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strAddress.length() == 0) {
      if (data.strCross.length() == 0) return false;
      data.strAddress = data.strCross;
      data.strCross = "";
    }
    return true;
  }
  
  // Address field must parse : @<place name> syntax
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strPlace = p.getLastOptional(": @");
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  // Call field has a funny -: convention
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("-:", "-");
      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  // INFO field may have cell phone # & GPS location
  private static final Pattern CELL_INFO_PTN = 
      Pattern.compile("^ALT# ([\\d\\-]+) ([+\\-]\\d+\\.\\d+ [+\\-]\\d+\\.\\d+)\\b");
  private class MyInfoField extends InfoField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = CELL_INFO_PTN.matcher(field);
      if (match.find()) {
        data.strPhone = match.group(1);
        data.strGPSLoc = match.group(2);
        field = field.substring(match.end()).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "PHONE GPS INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
