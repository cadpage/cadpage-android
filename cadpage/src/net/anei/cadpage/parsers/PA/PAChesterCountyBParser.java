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

*/


public class PAChesterCountyBParser extends FieldProgramParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "NGARDN", "NEW GARDEN TWP",
      "LGROVE", "LONDON GROVE TWP"
      
  });
  
  public PAChesterCountyBParser() {
    super(CITY_CODES, "CHESTER COUNTY", "PA",
           "CALL ADDRPL! X? APT? INFO+? CITY! INFO+? DATE SKIP NAME? PHONE");
  }


  @Override
  protected boolean parseMsg(String body, Data data) {
    
    return parseFields(body.split("\n"), data);
  }
  
  private class AddressPlaceField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      super.parse(p.get(" - "), data);
      data.strName = p.get();
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR PLACE";
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
  // (marks the end of the INFO fields
  private static final Pattern DATE_PATTERN = Pattern.compile("\\d\\d/\\d\\d/\\d\\d\\d\\d");
  private class DateField extends SkipField {
    public DateField() {
      setPattern(DATE_PATTERN);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRPL")) return new AddressPlaceField();
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("DATE")) return new DateField();
    return super.getField(name);
  }
} 
