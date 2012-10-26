package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NCCabarrusCountyBParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("^\\d{2,4}:");
  
  public NCCabarrusCountyBParser() {
    super("CABARRUS COUNTY", "NC",
           "( DATETIME CALL CH? ADDR! X+? |" +
            " FYI? DIGIT CALL ( PRI UNIT+? CH? ADDR! X+? | CH? ADDR! X+? INFO? PRI UNIT+? ) DATETIME EXTRA+? ID )");
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
  
  private class FYIField extends SkipField {
    public FYIField() {
      setPattern(Pattern.compile("FYI:|Update:"), true);
    }
  }
  
  private class DigitField extends SkipField {
    public DigitField() {
      setPattern(Pattern.compile("[\\dP]"), true);
    }
  }
  
  private class MyChannelField extends ChannelField {
    public MyChannelField() {
      setPattern(Pattern.compile("OPS\\d+"));
    }
  }
  
  private class MyPriorityField extends PriorityField {
    public MyPriorityField() {
      setPattern(Pattern.compile("\\d"), true);
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
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d");
  private class MyDateTimeField extends DateTimeField {
    public MyDateTimeField() {
      setPattern(DATE_TIME_PTN, true);
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
  }
  
  private class MyIdField extends IdField {
    public MyIdField() {
      setPattern(Pattern.compile("\\d{7}"));
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("FYI")) return new FYIField();
    if (name.equals("DIGIT")) return new DigitField();
    if (name.equals("CH")) return new MyChannelField();
    if (name.equals("PRI")) return new MyPriorityField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("EXTRA")) return new MyExtraField();
    if (name.equals("ID")) return new MyIdField();
    return super.getField(name);
  }
}
