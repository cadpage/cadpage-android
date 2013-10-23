package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;



public class OHKnoxCountyParser extends DispatchEmergitechParser {
  
  public OHKnoxCountyParser() {
    super(null, new int[]{59,60}, CITY_LIST, "KNOX COUNTY", "OH");
    addSpecialWords("HYATT");
    
  }

  @Override
  public String getFilter() {
    return "Dispatch@smtp-server.Columbus.rr.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // We have to do a lot of massaging to get the message back to standard form
    // including recovering a square bracket unit that might have been interpreted
    // as the message subject
    if (body.startsWith("Dispatch:")) body = body.substring(9).trim();
    else if (subject.length() > 0) body = '[' + subject + ']' + body;
    
    // Fix some word breaks the basic logic won't catch
    body = body.replace(" SP ARTA ", " SPARTA ");
    body = body.replace(" FREDERICKTOW N ", " FREDERICKTOWN ");

    if (!super.parseMsg(body, data)) return false;
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{

    "MOUNT VERNON",

    "CENTERBURG",
    "DANVILLE",
    "FREDERICKTOWN",
    "GAMBIER",
    "GANN",
    "MARTINSBURG",
    "UTICA",

    "BERLIN TWP",
    "BROWN TWP",
    "BUTLER TWP",
    "CLAY TWP",
    "CLINTON TWP",
    "COLLEGE TWP",
    "HARRISON TWP",
    "HILLIAR TWP",
    "HOWARD TWP",
    "JACKSON TWP",
    "JEFFERSON TWP",
    "LIBERTY TWP",
    "MIDDLEBURY TWP",
    "MILFORD TWP",
    "MILLER TWP",
    "MONROE TWP",
    "MORGAN TWP",
    "MORRIS TWP",
    "PIKE TWP",
    "PLEASANT TWP",
    "UNION TWP",
    "WAYNE TWP",

    "BANGS",
    "BLADENSBURG",
    "HOWARD",
    "MOUNT LIBERTY",
  };
}
