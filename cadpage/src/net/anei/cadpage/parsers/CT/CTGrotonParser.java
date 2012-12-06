package net.anei.cadpage.parsers.CT;


import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Groton, CT
 */

public class CTGrotonParser extends FieldProgramParser {
  
  public CTGrotonParser() {
    super(CITY_CODES, "GROTON", "CT",
          "CALL PLACE ADDRCITY SRCX! TIME INFO+");
  }

  @Override
  public String getFilter() {
    return "Mobiletec@town.groton.ct.us";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CAD PAGE")) return false;
    return parseFields(body.split("\\|"), 4, data);
  }
  
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      super.parse(field, data);
    }
  }
  
  private static final Pattern SRC_CROSS_PTN = Pattern.compile("STA ([A-Z]+) XS(?: (.*))?");
  private class SourceCrossField extends Field {
    @Override
    public void parse(String field, Data data) {
      field = field.replaceAll("  +", " ");
      Matcher match = SRC_CROSS_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strSource = match.group(1);
      String cross = match.group(2);
      if (cross != null) {
        if (data.strAddress.length() == 0) {
          parseAddress(cross, data);
        } else {
          data.strCross = cross;
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "SRC X";
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("NARR")) field = field.substring(4).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("SRCX")) return new SourceCrossField();
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d");
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "GRTN TOWN",  "GROTON",
      "MYSTIC",     "MYSTIC",
      "STON",       "STONINGTON"
  });
}
