package net.anei.cadpage.parsers.NH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NHMerrimackCountyParser extends FieldProgramParser {
  
  public NHMerrimackCountyParser() {
    super("MERRIMACK COUNTY","NH",
           "( EVENT:SKIP TIME:DATETIME! TYPE:CALL! LOC:ADDR! TXT:INFO+ | " +
             "TYPE:CALL TIME:DATETIME! LOC:ADDR! CITY:CITY! INFO+ | " +
             "TIME:DATETIME! CITY:CITY! LOC:ADDR! TYPE:CALL! TXT:INFO+ )");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@newlondonpd.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CAD")) data.strSource = subject;
    return parseFields(body.split("\n"), 4, data);
  }
}
