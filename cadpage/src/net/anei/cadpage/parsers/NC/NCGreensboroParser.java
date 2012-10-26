package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class NCGreensboroParser extends DispatchOSSIParser {
  
  private static final Pattern MARKER = Pattern.compile("^\\d{1,4}:CAD@greensboro-nc.gov:");
  
  public NCGreensboroParser() {
    super("GREENSBORO", "NC",
           "FYI? ID CALL ADDR EXTRA? X+? CODE? PLACE");
  }
  
  @Override
  public String getFilter() {
    return "93001";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    return super.parseMsg(body, data);
  }
  
  // FYI field should be skipped if present
  private class FYIField extends SkipField {
    
    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      return field.equals("FYI:");
    }
  }
  
  // Extra information field
  private class ExtraField extends SkipField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.startsWith("DIST:")) {
        data.strSupp = field;
        return true;
      }
      if (field.startsWith("APT ")) {
        data.strApt = field.substring(4).trim();
        return true;
      }
      return false;
    }
    
    @Override
    public String getFieldNames() {
      return "INFO APT";
    }
  }
  
  // Code field must  match specified pattern
  private class MyCodeField extends CodeField {
    MyCodeField() {
      setPattern(Pattern.compile("\\d\\d[A-Z]\\d\\d[A-Za-z]?"));
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("FYI")) return new FYIField();
    if (name.equals("EXTRA")) return new ExtraField();
    if (name.equals("CODE")) return new MyCodeField();
    return super.getField(name);
  }
}
