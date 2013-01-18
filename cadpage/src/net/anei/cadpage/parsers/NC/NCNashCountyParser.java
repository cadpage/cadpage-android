package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class NCNashCountyParser extends DispatchOSSIParser {
  
  public NCNashCountyParser() {
    super("NASH COUNTY", "NC",
           "SKIP ADDR! SKIP SKIP CITY! UNK EMPTY+? CALL! SKIP PLACENAME UNK UNIT INFO+");
  }
  
  @Override
  public String getFilter() {
    return "nash911@nashcountync.gov,9300";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (body.startsWith("/ ")) body = body.substring(2).trim();
    if (!body.startsWith("NASH911:")) return false;
    body = body + " ";
    return parseFields(body.split("\\* "), data);
  }
  
  @Override
  protected boolean checkPlace(String field) {
    return !field.contains(",");
  }
  
  private static final Pattern INFO_LINE_PTN = Pattern.compile("^Line\\d+=");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = INFO_LINE_PTN.matcher(field);
      if (match.find()) {
        field = field.substring(match.end()).trim();
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
