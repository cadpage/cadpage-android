package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.FieldProgramParser;
import java.util.regex.Pattern;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class OHWashingtonCountyAParser extends FieldProgramParser {

  /**
   * Washington County, OH
   */

  private static final Pattern SUBJECT_PATTERN = Pattern.compile("CAD +Page");

  public OHWashingtonCountyAParser () {
    super("WASHINGTON COUNTY", "OH",
        "( CALL EMPTY ADDR EMPTY ( EMPTY EMPTY EMPTY | ) DATE TIME EMPTY SRC! | ADDR DATETIME CALL ) INFO+");
  }
  
  @Override
  public String getFilter() {
    return "notifications@washingtoncountysheriff.or";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!SUBJECT_PATTERN.matcher(subject).matches()) return false;
    return parseFields(body.split("\n"), data);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("DATE")) return new DateField("\\d\\d?/\\d\\d?/\\d{4}", true);
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d?/\\d\\d?/\\d{4} \\d\\d:\\d\\d:\\d\\d");
    return super.getField(name);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace('@', '&');
      super.parse(field, data);
    }
  }
}