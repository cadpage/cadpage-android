package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class OHStarkCountyCencommParser extends FieldProgramParser {
  
  public OHStarkCountyCencommParser() {
    super("STARK COUNTY", "OH",
           "SRCID DISPATCHED CALL ADDR!");
  }
  
  @Override
  public String getFilter() {
    return "cencom@neohio.twcbc.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    return parseFields(body.split("\n"), 4, data);
  }
  
  private static final Pattern SRC_ID_PTN = Pattern.compile("([A-Z0-9]+):(\\d{4}:\\d+)");
  private class SourceIdField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = SRC_ID_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strSource = match.group(1);
      data.strCallId = match.group(2);
    }
    
    @Override
    public String getFieldNames() {
      return "SRC ID";
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(';');
      if (pt >= 0) {
        data.strCity = field.substring(pt+1).trim();
        field = field.substring(0,pt);
      }
      field = field.replaceAll(" *, *", " ");
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("SRCID")) return new SourceIdField();
    if (name.equals("DISPATCHED")) return new SkipField("DISPATCHED", true);
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
}
