package net.anei.cadpage.parsers.IA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class IAJasperCountyParser extends FieldProgramParser {
  
  public IAJasperCountyParser() {
    super(CITY_LIST, "JASPER COUNTY", "IA",
          "Reported:DATETIME! ID_CALL! Loc:ADDR/S! X? MAP? UNIT! END");
  }
  
  @Override
  public String getFilter() {
    return "jasper911@iowatelecom.net";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch Info")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d?/\\d\\d/\\d{4} \\d\\d?:\\d\\d:\\d\\d", true);
    if (name.equals("ID_CALL")) return new MyIdCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new CrossField(".*/.*", true);
    if (name.equals("MAP")) return new MapField("R\\d{3}\\b.*", true);
    return super.getField(name);
  }
  
  private static Pattern ID_CALL_PTN = Pattern.compile("(\\d\\d-\\d{6}) +(.*)");
  private class MyIdCallField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ID_CALL_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCallId = match.group(1);
      data.strCall = match.group(2);
    }

    @Override
    public String getFieldNames() {
      return "ID CALL";
    }
  }
  
  private static final Pattern ST_ZIP_PTN = Pattern.compile("([A-Z]{2}) +(\\d{5})");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.lastIndexOf(',');
      String city = null;
      if (pt >= 0) {
        String tmp = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
        Matcher match = ST_ZIP_PTN.matcher(tmp);
        if (match.matches()) {
          String state = match.group(1);
          city = match.group(2);
          if (!state.equals("IA")) data.strState = state;
        }
      }
      super.parse(field, data);
      if (city != null && data.strCity.length() == 0) data.strCity = city;
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " ST";
    }
  }


  private static final String[] CITY_LIST =new String[]{
    // Cities
    "BAXTER",
    "COLFAX",
    "KELLOGG",
    "LAMBS GROVE",
    "LYNNVILLE",
    "MINGO",
    "MITCHELLVILLE",
    "MONROE",
    "NEWTON",
    "OAKLAND ACRES",
    "PRAIRIE CITY",
    "REASNOR",
    "SULLY",
    "VALERIA",

    // Unincorporated communities
    "IRA",
    "KILLDUFF",
    "RUSHVILLE"
  };
}
