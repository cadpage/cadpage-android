package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA56Parser extends FieldProgramParser {

  public DispatchA56Parser(String defCity, String defState) {
    super(defCity, defState, 
          "DATETIME CODECALL LOCATION PLACE? UNIT! INFO+");
  }
  
  private static Pattern DISP_DATETIME_BODY = Pattern.compile("DISPATCH:.*? - (\\d{2}/\\d{2} \\d{2}:\\d{2}) - (.+)", Pattern.DOTALL);
  private static final Pattern DELIM = Pattern.compile("\n\n|//");
  
  @Override
  public boolean parseMsg(String body, Data data) {

    //split first field into smaller ones
    Matcher mat = DISP_DATETIME_BODY.matcher(body);
    if (!mat.matches()) return false;
    body = mat.group(1) + "\n\n" + mat.group(2);
    
    return parseFields(DELIM.split(body), data);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("(\\d{2}/\\d{2} \\d{2}:\\d{2})", true);
    if (name.equals("CODECALL")) return new MyCodeCallField();
    if (name.equals("LOCATION")) return new MyLocField(); //ADDR APT? CITY
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("UNIT")) return new UnitField(".+:.+", true);
    return super.getField(name);
  }
  
  private static final Pattern EXTRA_COMMA_PTN = Pattern.compile(" *, *");
  private class MyLocField extends AddressField {
    @Override public void parse(String field, Data data) {
      Parser p = new Parser(field);
      //last field is always city
      data.strCity = p.getLastOptional(',');
      //second to last is sometimes APT
      data.strApt = p.getLastOptional("Apt/Unit #");
      //parse the rest normally
      field = EXTRA_COMMA_PTN.matcher(p.get()).replaceAll(" ").trim();
      super.parse(field, data);
    }

    @Override public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
  
  private static Pattern CODE_CALL = Pattern.compile("(\\d+)\\s+(.+)");
  private class MyCodeCallField extends Field {
    @Override public void parse(String field, Data data) {
      //numeric CODE precedes CALL
      Matcher mat = CODE_CALL.matcher(field);
      if (mat.matches()) {
        data.strCode = mat.group(1);
        data.strCall = mat.group(2);
      } else data.strCall = field;
    }

    @Override public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override public void parse(String field, Data data) {
      field = stripFieldStart(field, "ALIAS=");
      super.parse(field, data);
    }
  }

}
