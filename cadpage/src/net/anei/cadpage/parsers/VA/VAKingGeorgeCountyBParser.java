package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class VAKingGeorgeCountyBParser extends FieldProgramParser {
  
  public  VAKingGeorgeCountyBParser() {
    super("KING GEORGE COUNTY", "VA", 
          "CODE ADDR CITY ST_ZIP X! INFO/CS+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@co.kinggeorge.state.va.us,14100";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 0) return false;
    data.strCall = subject;
    return super.parseFields(body.split(","), data);
  }
  
  @Override
  public String getProgram() {
    return "CALL " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ST_ZIP"))  return new MyStateZipField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private static final Pattern ST_ZIP_PTN = Pattern.compile("([A-Z]{2})(?: *\\d{5})?");
  private class MyStateZipField extends Field {

    @Override
    public void parse(String field, Data data) {
      Matcher match = ST_ZIP_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strState = match.group(1);
    }

    @Override
    public String getFieldNames() {
      return "ST";
    }
    
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (!field.startsWith("X=")) abort();
      field = field.substring(2).trim();
      field = stripFieldStart(field, "/");
      field = stripFieldEnd(field, "/");
      super.parse(field, data);
    }
  }

}
