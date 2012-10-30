package net.anei.cadpage.parsers.OR;


import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Linn County, OR
 */
public class ORLinnCountyParser extends FieldProgramParser {
  
  public ORLinnCountyParser() {
    super(CITY_LIST, "LINN COUNTY", "OR",
           "CALL CALL!+? ADDR/SXP! ( DATE TIME! | X/Z? MAP! ) UNIT? INFO");
  }
  
  @Override
  public String getFilter() {
    return "linn911@le.linn.or.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("ICOM/400 notification,")) body = body.substring(22).trim();
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
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("DATE")) return new MyDateField();
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("MAP")) return new MapField("(?:\\d{4}[A-Z]?\\d\\d\\*?[A-Z]?\\d\\d|)", true);
    if (name.equals("UNIT")) return new UnitField("[A-Z0-9 ]+");
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
