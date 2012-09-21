package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Union County, OH
Contact: "Daniel Boone Sr." <daniel.boonesr@gmail.com>
Sender: idnetworks@co.union.oh.us

FIRE, 121 E BLAGROVE ST 1/2 RICHWOOD, BEATTY AVE,RICHWOOD//N CLINTON ST,RICHWOOD,\n
HEART PROBLEMS, 10535 MAPLE DELL RD MARYSVILLE, STATE ROUTE 37,MARYSVILLE//, 53 YOF POSS HEART\n
FALL/BACK INJURY, 85 ROSE ST MAGNETIC SPRINGS, W CATHERINE ST,MAGNETIC SPRINGS//W MAGNETIC ST,MAGNETIC SPRINGS, DALE FAGG FELL AND HI
DIFFICULTY BREATHING, 14936 MILLER RD RICHWOOD, MCMILLEN RD,RICHWOOD//SNARE RD,RICHWOOD, 74 YO DB\n

 */


public class OHUnionCountyParser extends FieldProgramParser {
  
  public OHUnionCountyParser() {
    super(CITY_LIST, "UNION COUNTY", "OH",
           "CALL ADDR/S X X INFO+");
  }
  
  @Override
  public String getFilter() {
    return "idnetworks@co.union.oh.us";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    return parseFields(body.split(","), data);
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf("//");
      if (pt >= 0) field = field.substring(pt+2).trim();
      super.parse(field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCity.startsWith(field)) return;
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "DUBLIN",
    "MARYSVILLE",
    "[EDIT]VILLAGES",
    "MAGNETIC SPRINGS",
    "MILFORD CENTER",
    "PLAIN CITY",
    "RICHWOOD",
    "UNIONVILLE CENTER",
    
    // Unincorporated communities
    "ALLEN CENTER",
    "ARNOLD",
    "BRIDGEPORT",
    "BROADWAY",
    "BYHALIA",
    "CHUCKERY",
    "CLAIBOURNE",
    "DIPPLE",
    "ESSEX",
    "IRWIN",
    "JEROME",
    "LUNDA",
    "NEW CALIFORNIA",
    "NEW DOVER",
    "PEORIA",
    "PHARISBURG",
    "POTTERSBURG",
    "RAYMOND",
    "SOMERSVILLE",
    "WATKINS",
    "WOODLAND",
    "YORK CENTER",
    
    // Townships
    "ALLEN TWP",
    "CLAIBOURNE TWP",
    "DARBY TWP",
    "DOVER TWP",
    "JACKSON TWP",
    "JEROME TWP",
    "LEESBURG TWP",
    "LIBERTY TWP",
    "MILLCREEK TWP",
    "PARIS TWP",
    "TAYLOR TWP",
    "UNION TWP",
    "WASHINGTON TWP",
    "YORK TWP"
  };
}
