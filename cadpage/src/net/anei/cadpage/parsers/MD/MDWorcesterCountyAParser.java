package net.anei.cadpage.parsers.MD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class MDWorcesterCountyAParser extends DispatchOSSIParser {
 
  public MDWorcesterCountyAParser() {
    super(MDWorcesterCountyParser.CITY_LIST, "WORCESTER COUNTY", "MD",
    		   "SRC? CALL ADDR APT? PLACE? CITY/Y! X X INFO+ DATETIME");
  }
  
  @Override
  protected boolean parseMsg(String field, Data data) {
    if (!super.parseMsg(field, data)) return false;
    if (data.strCity.equalsIgnoreCase("NEW CHURCH")) data.strState = "VA";
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CITY", "CITY ST");
  }

  private static final Pattern APT_PTN = Pattern.compile("(?:APT|RM) *(.*)|(BLDG *.*)", Pattern.CASE_INSENSITIVE);
  private class MyAptField extends AptField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = APT_PTN.matcher(field);
      if (!match.matches()) return false;
      String apt = match.group(1);
      if (apt == null) apt = match.group(2);
      data.strApt = apt;
      return true;
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("[0-9]{1,2}00[A-Z]?|S[0-9]", true);
    if (name.equals("APT")) return new MyAptField();
    return super.getField(name);
  }
}
