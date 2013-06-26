package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class OHPortageCountyParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("^[A-Z0-9\\.]+: +", Pattern.CASE_INSENSITIVE);
  
  public OHPortageCountyParser() {
    super("PORTAGE", "OH",
          "CALL ZERO? ADDR! SRC? CITY INFO+");
  }
  
  @Override
  public String getFilter() {
    return "911@ci.ravenna.oh.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = MARKER.matcher(body);
    if (match.find()) body = body.substring(match.end());
    return parseFields(body.split(","), data);
  }

  private static final Pattern CALL_CODE_PTN = Pattern.compile("^([A-Z0-9]{1,5})[-_]");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CALL_CODE_PTN.matcher(field);
      if (!match.find()) abort();
      data.strCode = match.group(1);
      field = field.substring(match.end()).trim();
      super.parse(field, data);
    }
    
    @Override 
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private class MySourceField extends SourceField {
    public MySourceField() {
      setPattern(Pattern.compile(".* (?:FIRE|POLICE)", Pattern.CASE_INSENSITIVE), true);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ZERO")) return new SkipField("0?");
    if (name.equals("SRC")) return new MySourceField();
    return super.getField(name);
  }
  
  @Override
  public String postAdjustMapAddress(String addr) {
    return STATE225_PTN.matcher(addr).replaceAll("STATE ROUTE 225");
  }
  private static final Pattern STATE225_PTN = Pattern.compile("\\b(STATE|ST|OH) +225\\b", Pattern.CASE_INSENSITIVE);
}
