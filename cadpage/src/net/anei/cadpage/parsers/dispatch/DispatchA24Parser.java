package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/**
 * Mercer County, NJ
 */
public class DispatchA24Parser extends FieldProgramParser {
  
  private static final Pattern UNIT_PTN = Pattern.compile("\\bUNIT: *([- A-Z0-9]+?) *[;\\n ] *", Pattern.CASE_INSENSITIVE);
  
  
  public DispatchA24Parser(String defCity, String defState) {
    super(defCity, defState,
           "UNIT:UNIT? ( CALL:CALL! ( PLACE:PLACE! ADDR:ADDR! BLDG:APT APT:APT CITY:CITY! XSTREETS:X ID:ID% DATE:DATE% TIME:TIME% UNIT:UNIT | ID:ID? ) INFO:INFO " +
                      "| ID:ID! INFO/RN+ )");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {

    body = stripFieldEnd(body, "(#1");
    String[] flds = body.split("\n");
    if (flds.length < 3) flds = body.split(";");
    if (flds.length >= 3) {
      if (super.parseFields(flds, data)) return true;
    } else {
      if (super.parseMsg(body, data)) return true;
    }
    
    Matcher match = UNIT_PTN.matcher(body);
    if (!match.find()) return false;
    if (match.start() == 0) body = body.substring(match.end()).trim();
    
    data.parseGeneralAlert(this, body);
    data.strUnit = match.group(1);
    return true;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new MyTimeField();
    return super.getField(name);
  }
  
  private class MyTimeField extends TimeField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('(');
      if (pt >= 0) field = field.substring(0,pt).trim();
      super.parse(field, data);
    }
  }
}
