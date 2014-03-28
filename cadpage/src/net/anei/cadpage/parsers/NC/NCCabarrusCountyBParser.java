package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NCCabarrusCountyBParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("^(?:\\d{2,4}|CAD):");
  
  public NCCabarrusCountyBParser() {
    super("CABARRUS COUNTY", "NC",
           "FYI? ( DATETIME CALL CH? ADDR! X+? INFO+ |" +
            " DIGIT CALL ( PRI/Z UNIT UNIT+? CH? ADDR! X+? | DIGIT? CH? ADDR! X+? INFO+? PRI UNIT+? ) DATETIME EXTRA+? ID )");
    setupMultiWordStreets("A T ALLEN SCHOOL");
  }
  
  @Override
  public String getFilter() {
    return "93001";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    return parseFields(body.split("\\|"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("FYI")) return new SkipField("FYI:|Update:", true);
    if (name.equals("DIGIT")) return new SkipField("[\\dP]", true);
    if (name.equals("CH")) return new ChannelField("OPS\\d*");
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("PRI")) return new PriorityField("\\d{1,2}", true);
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("EXTRA")) return new MyExtraField();
    if (name.equals("ID")) return new IdField("\\d{7}", true);
    return super.getField(name);
  }
  
  private static Pattern X_PTN = Pattern.compile("\\bRAMP\\b");
  private class MyCrossField extends CrossField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (X_PTN.matcher(field).find()) {
        super.parse(field, data);
        return true;
      } else {
        return super.checkParse(field, data);
      }
    }
  }
  
  private static final Pattern UNIT_PTN = Pattern.compile("\\d[A-Z0-9]{1,3}");
  private class MyUnitField extends UnitField {
    
    public MyUnitField() {
      setPattern(UNIT_PTN, true);
    }
    
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, " ", field);
    }
  }
  
  private static final Pattern PHONE_PTN = Pattern.compile("\\d{10}");
  private static final Pattern SKIP_PTN = Pattern.compile("\\d{3,6}");
  private class MyExtraField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = PHONE_PTN.matcher(field);
      if (match.matches()) {
        data.strPhone = append(data.strPhone, " / ", field);
        return;
      }
      match = SKIP_PTN.matcher(field);
      if (match.matches()) return;
      data.strPlace = append(data.strPlace, " / ", field);
    }
    
    @Override
    public String getFieldNames() {
      return "PHONE PLACE";
    }
  }
}
