package net.anei.cadpage.parsers.IL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class ILMacoupinCountyParser extends FieldProgramParser {
  public ILMacoupinCountyParser() {
    super("MACOUPIN COUNTY", "IL",
      "( ADDRCITY PLACE? SRC INFO! CC_Text:CALL Problem:INFO | DISPATCH:EVERYTHING! )");
  }
  
  static private final Pattern PAMA_PATTERN  = Pattern.compile("(.*)-.*SECTOR");
  
  @Override
  public String adjustMapAddress(String a) {
    Matcher m = PAMA_PATTERN.matcher(a);
    if (m.matches()) a = m.group(1).trim();
    return a;
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (! parseFields(body.split("\n+"), data)) return false;
    if (data.strCall.length() == 0) {
      data.strCall = data.strSupp;
      data.strSupp = "";
      if (data.strCall.length() == 0) data.strCall = "ALERT";
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " CALL"; 
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("SRC")) return new SourceField("[A-Z]{3}:.+", true);
    if (name.equals("EVERYTHING")) return new EverythingField();
    return super.getField(name);
  }
  
  static private final Pattern ADDRESS_PATTERN
    = Pattern.compile("(\\d+(?: +BLK)?),(.*)");
  private String fixAddress(String a) {
    Matcher m=ADDRESS_PATTERN.matcher(a);
    if (m.matches()) a=append(m.group(1), " ", m.group(2).trim());
    return a;
  }
  
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      super.parse(fixAddress(field), data);
    }
  }
  
  static private final Pattern EVERYTHING_PATTERN
    = Pattern.compile("([A-Z]{3}:.*?)- +(\\d{4})(.*)/(.*)");
  private class EverythingField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      Matcher m = EVERYTHING_PATTERN.matcher(field);
      if (!m.matches()) abort();
      data.strSource = m.group(1).trim();
      data.strCode = m.group(2);
      data.strCall = m.group(3).trim();
      super.parse(fixAddress(m.group(4).trim()), data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames()+" SRC CODE CALL INFO";
    }
  }
}
