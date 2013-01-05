package net.anei.cadpage.parsers.AR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;


public class ARGarlandCountyParser extends DispatchProQAParser {
  
  public ARGarlandCountyParser() {
    super("GARLAND COUNTY", "AR",
           "CALL ADDR APT? PLACE? CITY ZIP INFO+");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@lifenetems.org";
  }
  
  private static final Pattern CALL_PTN = Pattern.compile("(\\d)-(.*)");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CALL_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strPriority = match.group(1);
      data.strCall = match.group(2).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "PRI CALL";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("APT")) return new AptField(".{1,4}");
    if (name.equals("ZIP")) return new SkipField("[0-9]{5}", true);
    return super.getField(name);
  }
}
