package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Cuyahoga County, OH
 */
public class DispatchA39Parser extends FieldProgramParser {

  private static final String PROGRAM_STR = "( ADDR/S CALLINFO | CALL ADDR/iS5XXa! ) INFO/N+";

  public DispatchA39Parser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState, PROGRAM_STR);
    removeWords("HTS");
  }

  public DispatchA39Parser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState, PROGRAM_STR);
    removeWords("HTS");
  }

  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch Message")) return false;
    return parseFields(body.split("\n"), 2, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALLINFO")) return new BaseCallInfoField();
    if (name.equals("INFO")) return new BaseInfoField();
    return super.getField(name);
  }
  
  private class BaseCallInfoField extends CallField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(',');
      if (pt >= 0) {
        data.strSupp = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CALL INFO";
    }
  }
  
  private static final Pattern INFO_JUNK_PTN = Pattern.compile("(?:-- +)?\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d Disp +\\S+[- ]*|[- ]+");
  private class BaseInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      
      Matcher match = INFO_JUNK_PTN.matcher(field);
      if (match.lookingAt()) field = field.substring(match.end());
      super.parse(field, data);
    }
  }
}
