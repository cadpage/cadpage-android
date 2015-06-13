package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchH01Parser;


public class MOFranklinCountyParser extends DispatchH01Parser {
  public MOFranklinCountyParser() {
    super("FRANKLIN COUNTY", "MO",
          "MARK! Workstation:SKIP! Print_Time:SKIP! User:SKIP! Location:ADDR! Response_Type:CALL! Zone_Name:MAP! Status_Name:SKIP! Status_Time:DATETIME! Handling_Unit:UNIT! Agency:SRC! NOTES+");
  }
  
  @Override
  public String getFilter() {
    return "@franklinmo.net";
  }
  
  @Override
  protected boolean parseHtmlMsg(String subject, String body, Data data) {
    if (! super.parseHtmlMsg(subject, body, data)) return false;
    if (data.strCity.equals("FRNKLN CNTY")) data.strCity = "FRANKLIN COUNTY";
    return true;
  }

  @Override
  public Field getField(String name) {
    if (name.equals("MARK")) return new SkipField("Franklin Co Response Email Report", true);
    return super.getField(name);
  }
 }