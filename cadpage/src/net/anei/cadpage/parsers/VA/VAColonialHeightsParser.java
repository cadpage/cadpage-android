package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Colonial Heights, VA
 */

public class VAColonialHeightsParser extends FieldProgramParser {
    
  private static Pattern MARKER = Pattern.compile("^(\\d\\d-\\d{6}) +");
  
  public VAColonialHeightsParser() {
    super(CITY_LIST, "COLONIAL HEIGHTS", "VA",
           "CALL! Reported:DATETIME! ADDR X? PLACE_CITY? UNIT! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "comm-page@colonialheightsva.gov";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("from CHECC")) return false;
    
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCallId = match.group(1);
    body = body.substring(match.end());
    
    return parseFields(body.split("\n"), 4, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private class MyCrossField extends CrossField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.contains("/")) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("/")) field = field.substring(1).trim();
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private class MyPlaceCityField extends Field {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Result res = parseAddress(StartType.START_PLACE, FLAG_ONLY_CITY | FLAG_CHECK_STATUS | FLAG_ANCHOR_END, field);
      if (!res.isValid()) return false;
      res.getData(data);
      return true;
    }

    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }

    @Override
    public String getFieldNames() {
      return "PLACE CITY";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} +\\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("PLACE_CITY")) return new MyPlaceCityField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "CHESTERFIELD",
    "COLONIAL HEIGHTS"
  };
}
