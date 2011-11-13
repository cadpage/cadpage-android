package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Delaware County, PA (variant E)

Contact: George Millison <george.millison@colonialelectric.com>
Sender: oakmont1@comcast.net
18:03\nHAVERFORD RD & WOODCREST AV\nFD INVESTIGATION\nHAVERFORD RD\nWOODCREST AV

*/

public class PADelawareCountyEParser extends FieldProgramParser {
  
  public PADelawareCountyEParser() {
    super("DELAWARE COUNTY", "PA",
           "TIME! ADDR CALL! X/Z+");
  }
  
  @Override
  public String getFilter() {
    return "oakmont1@comcast.net";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return parseFields(body.split("\n"), data);
  }
  
  private class MyTimeField extends TimeField {
    public MyTimeField() {
      setPattern(Pattern.compile("\\d\\d:\\d\\d"), true);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new MyTimeField();
    return super.getField(name);
  }
}
