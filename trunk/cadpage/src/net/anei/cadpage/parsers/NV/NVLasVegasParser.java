package net.anei.cadpage.parsers.NV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NVLasVegasParser extends FieldProgramParser {
  
  public NVLasVegasParser() {
    super("LAS VEGAS", "NV",
           "I:ID! U:UNIT! P:PRI! G:MAP! PH:MAP! L:ADDR! B:PLACE! AL:INFO! PC:CODE! CODE N:SKIP TIME+");
  }
  
  @Override
  public String getFilter() {
    return "sms@pageway.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("SMS")) return false;
    body = body.replace(" U:", ", U:").replace(" L:", ", L:").replace(" PC:", ", PC:").replace(" N:", ", N:");
    return parseFields(body.split(","), 9, data);
  }
  
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      data.strMap = append(data.strMap, "-", field);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strApt = p.getLastOptional('#');
      field = p.get();
      if (field.endsWith("-CC")) {
        data.strCity = "CLARK COUNTY";
        field = field.substring(0,field.length()-3).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY APT";
    }
  }
  
  private static final Pattern TIME_PTN = Pattern.compile("^(\\d\\d:\\d\\d:\\d\\d)\\b");
  private class MyTimeField extends TimeField {
    @Override
    public void parse(String field, Data data) {
      if (data.strTime.length() > 0) return;
      Matcher match = TIME_PTN.matcher(field);
      if (match.find()) data.strTime = match.group(1);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("TIME")) return new MyTimeField();
    return super.getField(name);
  }
}
