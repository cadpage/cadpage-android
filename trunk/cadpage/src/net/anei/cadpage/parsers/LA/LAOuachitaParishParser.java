package net.anei.cadpage.parsers.LA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Ouachita, LA
 */
public class LAOuachitaParishParser extends FieldProgramParser {
  public LAOuachitaParishParser() {
    super(CITY_LIST, "OUACHITA PARISH", "LA",
        "CALL ADDR/S3XPX INFO+");
  }

  @Override
  public String getProgram() {
    return super.getProgram().replace("PLACE", "PLACE X");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    boolean res = parseFields(body.split("  "), data);
    parsePlace(data);
    return res;
  }

  private static final Pattern PLACE_PATTERN = Pattern.compile("(.*[a-z0-9])([A-Z].*)");
  private void parsePlace(Data data) {
    Matcher m = PLACE_PATTERN.matcher(data.strPlace);
    if (m.matches()) {
      data.strPlace = m.group(1);
      data.strCross = m.group(2);
    }
    else {
      data.strCross = data.strPlace;
      data.strPlace = "";
    }
  }

  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Pattern CALL_PATTERN
    = Pattern.compile("(.*?)((?: +E(?:\\d{3}|(?:C|T)\\d)\\b)*)");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      Matcher m = CALL_PATTERN.matcher(field);
      if (m.matches()) {
        data.strCall = m.group(1);
        data.strUnit = m.group(2).trim();
      }
      else
        data.strCall = field.trim();
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames()+" UNIT";
    }
  }
  
  private static final Pattern INFO_JUNK_PTN = Pattern.compile("E911 Info - Class of Service: [^ ]* Special Response Info:.*|QUERY CALLER FOR PHONE # Uncertainty:.*|Confidence:.*");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (INFO_JUNK_PTN.matcher(field).matches()) return;
      super.parse(field, data);
    }
  }
  
  private static final String[] CITY_LIST = {
    "BROWNSVILLE-BAWCDOMVILLE",
    "CALHOUN",
    "CLAIBORNE",
    "EROS",
    "MONROE",
    "RICHWOOD",
    "STERLINGTON",
    "SWARTZ",
    "WEST MONROE"
  };
}
