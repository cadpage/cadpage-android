package net.anei.cadpage.parsers.MS;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Calhoun County, MS
Contact: Active911
Sennder: cadalerts@eforcesoftware.com
Agency name: Calhoun County 912 Location: Pittsboro, MS 

(Dispatch Alert) Call Type: BANNER EMR\nCity: VARDAMAN\nAddress: 10 CR 117
(Dispatch Alert) Call Type: BANNER EMR\nCity: VARDAMAN\nAddress: 123 N MAIN ST
(Dispatch Alert) Call Type: BANNER EMR\nCity: PITTSBORO\nAddress: 45 CR 104

*/

public class MSCalhounCountyParser extends FieldProgramParser {

  public MSCalhounCountyParser() {
    super("CALHOUN COUNTY", "MS",
          "Call_Type:CALL! City:CITY! Address:ADDR!");
  }
  
  @Override
  public String getFilter() {
    return "cadalerts@eforcesoftware.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch Alert")) return false;
    return parseFields(body.split("\n"), 3, data);
  }
}
