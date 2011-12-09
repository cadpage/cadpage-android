package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*    
North East, MD (in Cecil County)
Contact: Dave Simmons <acdave0911@gmail.com>
Sender: nefc911@nefc.com

10C04 (CHE\nCHEST PAIN\n322 E CECIL AVE @NORTH BAY MED\nNE\nMECHANICS VALLEY RD\n06/14/11\n11:21:54\nDR SCHADEV'S OFFICE[P CHEST ;41 YEAR OLD, FEMALE, CONSCIOUS
31A01 (UNC\nUNCON/SYNCOPAL\n161 WILLARD DR\nNE\nSTITES LN\n06/13/11\n08:53:56\n[P MOM FELL ;76 YEAR OLD, FEMALE, CONSCIOUS, BREATHING. UNCONSCIOUS/FAINTING (NE
AUTO (AUTO\nAUTOMOBILE FIRE\n98.5 I95 NB HWY\nNE\nRED TOAD RD\n06/13/11\n14:13:17\nAUTO ON FIRE//CAN SEE FLAMES AND SMOKE\nOPS 6   0495S\n04
HOUSE (HOU\nHOUSE FIRE\n354 W MAIN ST\nELK\nBLUEBALL AVE\n06/13/11\n19:20:42\nFIRE IN THE STOVE WAS FULLY INVOLVED COULD BE OUT SMOKE IN THE RESIDENCE\nOPS 7
HOUSE (HOU\nHOUSE FIRE\n122 WHITEHALL RD\nELK\nCHESSMAN CIR\n06/13/11\n15:44:45\nSMOKE FROM BASEMENT//BLACK\nOPS 6   0304\n03\n

*/

public class MDNorthEastParser extends FieldProgramParser {
  
  public MDNorthEastParser() {
    super(CITY_CODES, "NORTH EAST", "MD",
           "CODE CALL ADDR X/Z+? CITY X/Z? DATE TIME INFO CH UNIT");
  }
  
  @Override
  public String getFilter() {
    return "nefc911@nefc.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (! parseFields(body.split("\n"), data)) return false;
    if (data.strCall.startsWith(data.strCode)) data.strCode = "";
    if (data.strCity.equals("OOC")) {
      data.strCity = data.defCity = data.defState = "";
    }
    return true;
  }
  
  private class MyCodeField extends CodeField {
    @Override
    public void parse(String field, Data data) {
      super.parse(new Parser(field).get('('), data);
    }
  }
  
  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strPlace = p.getLastOptional('@');
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  private static final Pattern MAP_PTN = Pattern.compile("\\b\\d{4}[A-Z]?$");
  private class MyChannelField extends ChannelField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = MAP_PTN.matcher(field);
      if (match.find()) {
        data.strMap = match.group();
        field = field.substring(0,match.start()).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CH MAP";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("DATE")) return new DateField("\\d\\d/\\d\\d/\\d\\d", true);
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("CH")) return new MyChannelField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "NE",   "North East",
      "ELK",  "Elkton",
      "CHAR", "Charlestown",
      "PV",   "Perryville",
      "RS",   "Rising Sun",
      "PD ",  "Port Deposit",
      "WAR",  "Warwick",
      "CHES", "Chesapeake City",
      "CONO", "Conowingo",
      "EARL", "Earlville",
      "CCLT", "Cecilton",
      "COLO ","Colora",
      
      "OOC", "OOC"
      
  });
}
