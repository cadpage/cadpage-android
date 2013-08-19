package net.anei.cadpage.parsers.OR;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Linn County, OR
 */
public class ORLinnCountyParser extends FieldProgramParser {
  
  private static final String[] MARKERS = new String[]{
    "ICOM/400 notification,",
    "LINN 911 (!) " 
  };
  
  public ORLinnCountyParser() {
    super(CITY_LIST, "LINN COUNTY", "OR",
           "CALL CALL!+? ADDR/SXP! ( DATE TIME! | X/Z? MAP! ) UNIT? INFO EMPTY? UNIT");
  }
  
  @Override
  public String getFilter() {
    return "linn911@le.linn.or.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    for (String marker : MARKERS) {
      if (body.startsWith(marker)) {
        body = body.substring(marker.length()).trim();
        break;
      }
    }
    String[] flds = body.split("/");
    if (flds.length < 3) return false;
    if (!parseFields(flds, data)) return false;
    if (data.strAddress.endsWith(" INTERSECTN")) {
      data.strAddress = data.strAddress.substring(0,data.strAddress.length()-11).trim();
    }
    if (data.strCity.equalsIgnoreCase("LINN COUNTY")) data.strCity = "";
    return true;
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, "/", field);
    }
  }
  
  private class MyDateField extends DateField {
    public MyDateField() {
      super("\\d\\d-\\d\\d-\\d\\d", true);
    }
    
    @Override
    public void parse(String field, Data data) {
      field = field.replace("-", "/");
      super.parse(field, data);
    }
  }
  
  private static final Pattern MAP_PTN = Pattern.compile("(\\d{4}[A-Z]?)(\\d\\d\\*?[A-Z]?\\d\\d)");
  private class MyMapField extends MapField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.length() == 0) return true;
      Matcher match = MAP_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strMap = match.group(1);
      data.strUnit = match.group(2);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "MAP UNIT";
    }
  }
  
  private static final Pattern UNIT_PTN = Pattern.compile("[A-Z0-9 ]+");
  private class MyUnitField extends UnitField {
    MyUnitField() {
      setPattern(UNIT_PTN, true);
    }
    
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, " ", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("DATE")) return new MyDateField();
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "LINN COUNTY",
    "ALBANY",
    "BROWNSVILLE",
    "GATES",
    "HALSEY",
    "HARRISBURG",
    "IDANHA",
    "LEBANON",
    "LYONS",
    "MILL CITY",
    "MILLERSBURG",
    "SCIO",
    "SODAVILLE",
    "SWEET HOME",
    "TANGENT",
    "WATERLOO",
    "CASCADIA",
    "CRABTREE",
    "CRAWFORDSVILLE",
    "MARION FORKS",
    "SHEDD",
    "SOUTH LEBANON"
  };
}
