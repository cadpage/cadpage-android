package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*    
Sample Benton County Page
Contact: kencx@peak.org
Sender: alerts@corvallis.ealertgov.com
(Corvallis Alert) INC: CODE 1 MEDICAL\nADD:1740 MAIN ST\nAPT:\nCITY:PHILOMATH\nX:N 17TH ST * N 18TH ST\nMAP:540-365\nCFS:0907010-119\nDIS:PHILOMATH FIRE
(Corvallis Alert) INC:COMM FIRE ALARM\nADD:421 S 19TH ST\nAPT:\nCITY:PHILOMATH\nX:ASH ST * CEDAR ST\nMAP:540-360\nCFS:100410-188\nDIS:PHILOMATH FIRE\nDIS:PHI
(Corvallis Alert) INC:UNKNOWN MEDICAL\nADD:504 MELVILL CRESCENT AV [PHILOMATH]\nAPT:\nCITY:PHILOMATH\nX:SUNSHINE AV\nMAP:550-385\nCFS:101710-223\nDIS:PHILOM
(Corvallis Alert) INC:BICYCLE ACCIDENT\nADD:DECKER RD and DECKER RIDGE RD\nAPT:\nCITY:PHILOMATH\nX:DECKER RD * BANKS LN\nMAP:480-420\nCFS:070611-52\nDIS:BEN

*/

public class ORBentonCountyParser extends FieldProgramParser {
  
  // List of streets that extend wholly or partly into a region that Google does
  // not recognize as part of Philomath
  private static final String[] NOT_IN_PHILOMATH = new String[]{
    "BANKS",
    "BREWSTER",
    "BEAVER CREEK",
    "BLUEROCK",
    "DECKER",
    "GRASS HEIGHTS",
    "LINVILLE",
    "MARYS PEAK",
    "NEUMAN",
    "PETERSON",
    "STARR CREEK"
  }; 
  
  public ORBentonCountyParser() {
    super("BENTON COUNTY", "OR",
          "INC:CALL! ADD:ADDR! APT:APT CITY:CITY! X:X MAP:MAP CFS:ID DIS:UNIT");
  }
  
  @Override
  public String getFilter() {
    return "alerts@corvallis.ealertgov.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (! subject.equals("Corvallis Alert")) return false;
    if (!parseFields(body.split("\n"), data)) return false;
    
    // Now for some special fixes to work around Dispatch map issues
    if (data.strCity.equals("PHILOMATH")) {
      data.strAddress = data.strAddress.replace("MELVILL CRESCENT AV","MELVILL CRESCENT");
      String tmp = data.strAddress.toUpperCase();
      for (String badRoad : NOT_IN_PHILOMATH) {
        if (tmp.contains(badRoad)) {
          data.strCity = "";
          break;
        }
      }
    }
    
    return true;
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      parseAddress(p.get('['), data);
      data.strCity = p.get(']');
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
