package net.anei.cadpage.parsers.CO;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class COKitCarsonCountyParser extends FieldProgramParser {
  
  public COKitCarsonCountyParser() {
    super(CITY_LIST, "KIT CARSON COUNTY", "CO",
           "EVENT:UNIT! TIME:DATETIME! TYPE:CALL! LOC:ADDR/S! TXT:INFO!");
  }
  
  @Override
  public String getFilter() {
    return "kccdispatch@yahoo.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if(!subject.equals("CAD")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  public Field getField(String  name) { 
	  if (name.equals("UNIT")) return new UnitField("\\d{4}",true);
	  if (name.equals("DATETIME")) return new DateTimeField("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}:\\d{2}", true);
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    return HWY_385_PTN.matcher(sAddress).replaceAll("US 385");
  }
  
  private static final Pattern HWY_385_PTN = Pattern.compile("\\bHWY *385\\b");

  private static final String[] CITY_LIST = new String[] { 
    "BETHUNE",
    "BURLINGTON",
    "FLAGLER",
    "SEIBERT",
    "STRATTON",
    "VONA"
  };
}
