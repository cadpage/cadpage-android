package net.anei.cadpage.parsers.PA;
import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;


/* 
Chester County, PA (version B)
Contact: Jason Wilkins <j.wilkins728@gmail.com>

OVERDOSE - ALS *\n300 CEDAR SPRINGS RD - LIBERTY KNOLL APTS\nW BALTIMORE PK & CEDAR WOODS CI\nAPT 205\nNGARDN\n3RD HAND INFO/RP NOT ON LOC/UNK AGE MALE SAID HE OD'S ON ON PILLS/RP PUT ME ON HOLD\n02/21/2011\n15:09\n610-388-7400
UNKNOWN TYPE FIRE *\n10 ALTEMUS DR\nWATSON MILL RD & DEAD END\nBROAD RUN KNOLL\nACROSS FROM ABV 1/4 MILE\nNGARDN\nSEES FIRE UNSURE IF ITS A BUILDING OR TRASH\n02/21/2011\n08:27\nRIOFSKI, LINDA P\n610-274-0906
HOUSE FIRE *\n109 GARDEN STATION RD\nE AVONDALE RD & WHITESTONE RD\nLGROVE\nSTOVE INSIDE BASMENT ON FIRE\n02/20/2011\n17:50\nA/F\n610-322-0944/C
ALARM - FIRE *\n8822 GAP NEWPORT PK\nCROSSAN LA & PENN GREEN RD\nRESD - LAFFERTY 610-268-2861\nNGARDN\nSMOKE DETECTOR IN KITCHEN - ENTER THRU BACK DO OR\n02/12/2011\n19:57\nLIFE ALERT-645\n800-638-8222
[Update]\nSMOKE / ODOR INVEST (OUTSIDE)\nRT 41 / RT 841\nLGROVE\nHEAVY SMOKE CONDITION IN THE AREA - UNK WHAT'S IT'S ACTUALLY COMING FROM\n02/16/2011\n02:18\nROCHESTER, RANDOLF\n717-468-8174
SMOKE / ODOR INVEST (OUTSIDE)\nRT 41 / RT 841\nLGROVE\nHEAVY SMOKE CONDITION IN THE AREA - UNK WHAT'S IT'S ACTUALLY COMING FROM\n02/16/2011\n02:18\nROCHESTER, RANDOLF\n717-468-8174

Contact: Christopher Bakey <ceb5070@gmail.com>
Sender: longwoodfire@comcast.net <From%3Alongwoodfire@comcast.net>

CHIMNEY FIRE **1905 LENAPE UNIONVILLE RD*RED LION RD & MUNICIPAL BOUNDA*POCOPS*21:30*WOOD STOVE IN BASEMENT, F
HOUSE FIRE **241 SAGINAW RD*LEWISVILLE RD & HOLLOW ROCK LA*NEWLON*12:52*DETAILS TO FOLLOW
ACCIDENT - SERIOUS **N BROAD ST / E LINDEN ST*KNTSQR*11:31*1 VEH, BLOCKING, CAR SMOK
FUEL SPILL **1001 HICKORY HILL RD*HONEYTREE LA & HILLENDALERD*PNSBRY*18:15*250 GALLON OIL TANK FOR F
OUT BUILDING / SHED FIRE **6 CARNATION LA*14:54*25 ENG ASSIST D59 – SHED
RELOCATE FIRE / EMS UNITS*23 FIREHOUSE WY - STATION 23*GAP NEWPORT PK & DEAD END*AVNDAL*21:18*MIC251 COVERING SOUTH
ALARM - CARBON MONOXIDE **5 COOPERSHALWK LA, CHADDS FORD*09:12*ENG25 ASST D59
ALARM - FIRE **815 E BALTIMORE PK - HILTON GARDENS INN*SCHOOLHOUSE RD & ONIX DR*EMARLB*20:25*GEN FIRE – NOTIYFING
NOTIFY FIRE CHIEF*1695 LENAPE RD - POCOPSON HOME*RED BRIDGE LA & LENAPE UNIONVI*POCOPS*03:12*RP ADV RESIDENT PULLED FI
BARN FIRE **382 W STREET RD - NEW BOLTON CTR MAIN CM*WIDENER LA & BYRD RD*EMARLB*19:32*SMOKE IN BARN - NO FIRE S
CHIMNEY FIRE **1905 LENAPE UNIONVILLE RD*RED LION RD & MUNICIPAL BOUNDA*POCOPS*21:30*WOOD STOVE IN BASEMENT, F

Contact: jtg5097@yahoo.com <jtg5097@yahoo.com>
Sender: wgfc22@comcast.net
(Dispatch) 05/31/11 * 13:30:52 * SYNCOPE/FAINTING - ALS * * 880 W BALTIMORE PK ,58 * LEWIS RD & PUSEY MILL RD * PENN * WELLNESS CENTER OFFICE-SOUTHER * GRANDEL,
(Dispatch) 05/31/11 * 11:10:31 * OTHER TYPE RESCUE * * 880 W BALTIMORE PK ,58 * LEWIS RD & PUSEY MILL RD * PENN * IN PLOT-YMCA *  * 910-750-762 * 2264 *  * 22 *
(Dispatch) 05/31/11 * 09:30:53 * HYPO TENSION - ALS * * 774 W GLENVIEW DR ,58 * PHEASANT WY & EDGEWOOD CT * PENN * - *  * 610-345-136 * 2203 *  * 22 * Dispatch *
(Dispatch) 05/31/11 * 00:36:12 * BARN FIRE * * 248 HOOD RD ,48 * MUNICIPAL BOUNDARY & N MOSQUITO LA * WMARLB * - *  * 610-316-731 * 3604   * 36 * Dispatch *


*/


public class PAChesterCountyBaseParser extends FieldProgramParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "NGARDN", "NEW GARDEN TWP",
      "LGROVE", "LONDON GROVE TWP",
      "POCOPS", "POCOPSON TWP",
      "NEWLON", "NEW LONDON TWP",
      "KNTSQR", "KENNETT SQUARE",
      "PNSBRY", "",
      "AVNDAL", "AVONDALE",
      "EMARLB", "EAST MARLBOROUGH TWP",
      "WMARLB", "WEST MARLBOROUGH TWP",
      "PENN",   "PENN TWP"
  });
  
  public PAChesterCountyBaseParser(String programStr) {
    super(CITY_CODES, "CHESTER COUNTY", "PA", programStr);
  }
  
  private class AddressPlaceField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      super.parse(p.get(" - "), data);
      data.strPlace = p.get();
      data.strAddress = data.strAddress.replaceAll("\\bLA\\b", "LN");
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR PLACE";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.contains("&")) return false;
      parse(field, data);
      return true;
    }
  }
  
  private class MyAptField extends AptField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      if (field.startsWith("APT ")) {
        field = field.substring(4).trim();
      } else if (field.length() > 4) return false;
      
      parse(field, data);
      return true;
    }
  }

  // Date field is skipped, but must match proper date format
  // Format is enforced even if not condition decision is required
  private static final Pattern DATE_PATTERN = Pattern.compile("\\d\\d/\\d\\d/\\d\\d\\d\\d");
  private class DateField extends SkipField {
    public DateField() {
      setPattern(DATE_PATTERN, true);
    }
  }
  
  // Time field is also skipped, but must match proper time format
  // Format is enforced even if not condition decision is required
  private static final Pattern TIME_PATTERN = Pattern.compile("\\d\\d:\\d\\d");
  private class TimeField extends SkipField {
    public TimeField() {
      setPattern(TIME_PATTERN, true);
    }
  }
  
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRPL")) return new AddressPlaceField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("DATE")) return new DateField();
    if (name.equals("TIME")) return new TimeField();
    return super.getField(name);
  }
} 
