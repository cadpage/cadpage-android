package net.anei.cadpage.parsers.PA;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class PABlairCountyParser extends FieldProgramParser {
  
  public PABlairCountyParser() {
    super("BLAIR COUNTY", "PA",
           "UNIT ADDRCITY/SXa X/Z+? DATETIME! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "Blair Alerts";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 0) return false;
    data.strCall = subject;
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  public String getProgram() {
    return "CALL " + super.getProgram();
  }
  
  private static final Pattern ADDR_AT_SIGN_PTN = Pattern.compile(" *@ *");
  private static final Pattern CITY_BORO_PTN =  Pattern.compile(" +(?:BORO|[A-Z]+ +COUNTY)$", Pattern.CASE_INSENSITIVE);
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      super.parse(field, data);
      data.strAddress = ADDR_AT_SIGN_PTN.matcher(data.strAddress).replaceAll(" & ").trim();
      Matcher match = CITY_BORO_PTN.matcher(data.strCity);
      if (match.find()) data.strCity = data.strCity.substring(0,match.start());
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("No Cross Streets Found")) return;
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("DATETIME")) return new DateTimeField(new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa"), true);
    return super.getField(name);
  }
}
