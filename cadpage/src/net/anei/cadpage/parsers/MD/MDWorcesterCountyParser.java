package net.anei.cadpage.parsers.MD;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/*
Worcester County, MD
Contact:james johnson <jjohnson1179@gmail.com>
Contact: BIGJOHNSON1179@vtext.com
CAD:300;FALLS;5914 BOX IRON RD;GIRDLETREE;PINE ST;TAYLOR LANDING RD;11/23/2010 08:31:38
CAD:300;SICK PERSON;5822 DUKES RD;GIRDLETREE;RAILROAD AVE;SNOW HILL RD;11/16/2010 09:21:04
CAD:300;FALLS;5914 BOX IRON RD;GIRDLETREE;PINE ST;TAYLOR LANDING RD;11/23/2010 08:31:38
CAD:100;TRAFFIC TRANSPORTATION ACC;3543 AYDELOTTE RD;DIST: 7.94 FT;POCOMOKE;BRANTLEY RD;SHEEPHOUSE RD;11/16/2010 00:31:42
CAD:100;PROPANE OR NATURAL GAS LEAK;1010 CLARKE AVE;POCOMOKE;ANN ST;MCMICHAEL AVE;11/12/2010 10:31:09
CAD:100;FIRE ALARM;125 NEWTOWNE BLVD;HOLIDAY INN EXPRESS;POCOMOKE;OLD SNOW HILL RD;11/12/2010 08:15:38
CAD:100;TRAFFIC TRANSPORTATION ACC;DIVIDING CREEK RD/WORTH RD;DIST: 25.70 FT;POCOMOKE;11/10/2010 15:20:42
CAD:MUTUAL AID ASSIST OUTSIDE AGY;4264 FIREHOUSE ST;NEWCHURCH STATION 1;NEW CHURCH;DEPOT ST;LANKFORD LN;11/08/2010 20:34:48
CAD:100;TRAFFIC TRANSPORTATION ACC;OCEAN HWY/WORCESTER HWY;PRIOR TO 113;POCOMOKE;11/08/2010 01:15:41
CAD:100;UNCONSCIOUS FAINTING;275 NEWTOWNE BLVD;BLDG LOWES;LOWES OF POCOMOKE;POCOMOKE;OLD SNOW HILL RD;11/07/2010 11:25:06
CAD:100;BREATHING PROBLEMS;906-16 LYNNHAVEN DR;POCOMOKE;8TH ST;HALEYS WAY;10/24/2010 06:58:01
CAD:S5;MUTUAL AID ASSIST OUTSIDE AGY;8987 COURTHOUSE HILL RD;POCOMOKE;DIVIDING CREEK RD;WALLACE TAYLOR RD;10/22/2010 22:01:04
CAD:100;UNCONSCIOUS FAINTING;1130 OLD VIRGINIA RD;POCOMOKE NAZARENE CHURCH;POCOMOKE;OCEAN HWY;SOUTHERN FIELDS DR;10/17/2010 11:32:35
CAD:100;CARDIAC OR RESPIRATORY ARREST;2330 WORCESTER HWY;GRND FLR;POCOMOKE;OLD SNOW HILL RD;LAMBERTSON RD;10/18/2010 19:23:41
CAD:100;RESIDENTIAL STRUCTURE FIRE;208 14TH ST;POCOMOKE;MARKET ST;CEDAR RUN;10/23/2010 07:12:12
CAD:100;BREATHING PROBLEMS;906-16 LYNNHAVEN DR;POCOMOKE;8TH ST;HALEYS WAY;10/24/2010 06:58:01  

Station codes
100=POCOMOKE CITY
200= STOCKTON MD
300=GIRDLETREE MD. WITCH IS WERE I AM
400=SNOWHILL MD
500=NEWARK MD
600=BERLIN MD
700=OCEAN CITY MD BUT THEY HAVE DIFF DISPATCH THE THE REST OF THE COUNTY
800=SHOWELL
900=BISHOPVILLE
NO 1000 STATION
1100=OCEAN PINES

Accomack County, VA msg should NOT be accepted
CAD:ABDOMINAL PAIN/BACK PAIN;33063 STONEY CREEK RD;ATLA;A27;C1;GENE WAYNE LN;FLEMING RD
*/

public class MDWorcesterCountyParser extends DispatchOSSIParser {
  
  private static final String[] CITY_LIST = new String[]{
    "POCOMOKE",
    "BERLIN",
    "OCEAN CITY",
    "SNOW HILL",
    "BISHOPVILLE",
    "GIRDLETREE",
    "NEWARK",
    "OCEAN PINES",
    "SHOWELL",
    "STOCKTON",
    "WEST OCEAN CITY",
    "WHALEYVILLE",
    "BOXION",
    "CEDARTOWN",
    "FRIENDSHIP",
    "GERMANTOWN",
    "GOODWILL",
    "KLEJ GRANGE",
    "LIBERTOWN",
    "NASSAWANGO HILLS",
    "POPLARTOWN",
    "PUBLIC LANDING",
    "SINNEPUXENT",
    "SOUTH POINT",
    "TAYLORVILLE",
    "WHITEON"
    
    
  };
 
  public MDWorcesterCountyParser() {
    super(CITY_LIST, "WORCESTER COUNTY", "MD",
    		   "SRC? CALL ADDR PLACE? CITY! X X INFO+ DATETIME!");
  }
  
  private static final Pattern SOURCE_PAT = Pattern.compile("[0-9]{1,2}00|S[0-9]");
  private class MySourceField extends SourceField {
    public MySourceField() {
      setPattern(SOURCE_PAT);
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("SRC")) return new MySourceField();
    return super.getField(name);
  }
}
