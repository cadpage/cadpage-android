package net.anei.cadpage.parsers.DE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class DEWilmingtonBParser extends FieldProgramParser {
  
  public DEWilmingtonBParser() {
    super("WILMINGTON", "DE",
           "From:SKIP! Loc:ADDR! Inc:CALL! Time:DATETIME! Narr:INFO");
  }
  
  @Override
  public String getFilter() {
    return "WLPD@state.de.us";
  }

  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d\\d/\\d\\d/\\d\\d) (\\d\\d:\\d\\d) (\\d{4}-\\d{8})(?: +(.*))?");
  private class MyDateTimeField extends DateTimeField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      data.strTime = match.group(2);
      data.strCallId = match.group(3);
      data.strUnit = getOptGroup(match.group(4));
    }
    
    @Override
    public String getFieldNames() {
      return "DATE TIME ID UNIT";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    return super.getField(name);
  }
}


