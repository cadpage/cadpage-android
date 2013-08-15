package net.anei.cadpage.parsers.CA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Placer County, CA
 */
public class CAPlacerCountyParser extends FieldProgramParser {
  
  public CAPlacerCountyParser() {
    super("PLACER COUNTY", "CA",
           "UNIT CALL ADDR PLACE ID! INFO");
  }
  
  @Override
  public String getFilter() {
    return "NEUCAD@FIRE.CA.GOV";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CAD Page")) return false;
    if (!body.startsWith(":")) return false;
    body = body.substring(1).trim();
    
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    return parseFields(body.split(":"), data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('@');
      if (pt >= 0) {
        data.strPlace = field.substring(0,pt).trim();
        field = field.substring(pt+1).trim();
      }
      if (field.endsWith(")")) {
        pt = field.indexOf('(');
        if (pt >= 0) {
          String place = field.substring(pt+1, field.length()-1).trim();
          data.strPlace = append(data.strPlace, " - ", place);
          field = field.substring(0,pt).trim();
        }
      }
      pt = field.lastIndexOf(',');
      if (pt < 0)  abort();
      data.strSource = field.substring(pt+1).trim();
      field = field.substring(0,pt).trim();
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT SRC PLACE";
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("BTWN " )) {
        data.strCross = field.substring(5).trim();
      } else {
        data.strPlace = append(data.strPlace, " - ", field);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE X";
    }
  }
  
  private static final Pattern INFO_CODE_PTN = Pattern.compile("Dispatch +([A-Z0-9]+)");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (!field.startsWith("Remarks")) abort();
      field = field.substring(7).trim();
      Matcher  match = INFO_CODE_PTN.matcher(field);
      if (match.matches()) {
        data.strCode = match.group(1);
      } else {
        data.strSupp = field;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CODE INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("UNIT")) return new UnitField("R/A +(.*)");
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("ID")) return new IdField("Inc# +(\\d+)", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
