package net.anei.cadpage.parsers.TX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.Cadpage3Parser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Montgomery County, TX
 */
public class TXMontgomeryCountyCParser extends Cadpage3Parser {
  
  private static final Pattern RUN_REPORT_PTN = 
      Pattern.compile("ID#:([-\\d]+) ; Unit:([A-Z0-9]+) ; (AC - Assignment Complete ; .*)");
  
  public TXMontgomeryCountyCParser() {
    super("MONTGOMERY COUNTY", "TX");
    setFieldList("ID UNIT CALL PLACE ADDR CITY MAP");
  }
  
  @Override
  public String getFilter() {
    return "tritechcad@mchd-tx.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CAD Message")) return false;
    
    Matcher match = RUN_REPORT_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = "RUN REPORT";
      data.strCallId = match.group(1);
      data.strUnit = match.group(2);
      data.strPlace = match.group(3);
      return true;
    }
    
    if (!body.startsWith("ID:")) return false;
    return super.parseMsg(body, data);
  }
}
