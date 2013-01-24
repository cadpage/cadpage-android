package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NCRandolphCountyParser extends FieldProgramParser {
  
  public NCRandolphCountyParser() {
    super("RANDOLPH COUNTY", "NC",
           "SRC ( UNIT ID PLACE! PLACE+ | CALL ADDR UNIT! SKIP INFO+ )");
  }
  
  @Override
  public int getMapFlags() {
    // Keep EXT markers
    return MAP_FLG_SUPPR_EXT;
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!body.startsWith("Randolph 911 - ")) return false;
    body = body.substring(14).trim();
    return parseFields(body.split("\n"), data);
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(';');
      if (pt >= 0) {
        data.strApt = field.substring(pt+1).trim();
        field = field.substring(0, pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " APT";
    }
  }
  
  private static final Pattern SKIP_INFO_PTN = Pattern.compile("^\\d\\d:\\d\\d:\\d\\d \\d\\d/\\d\\d/\\d{4}");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() >= 19) {
        if (SKIP_INFO_PTN.matcher(field).find()) return;
      } else {
        if ("NN:NN:NN NN/NN/NNNN".startsWith(field.replaceAll("\\d", "N"))) return;
      }
      if (field.length() >= 5) {
        if (field.toUpperCase().startsWith("PROQA")) return;
      } else {
        if ("PROQA".startsWith(field.toUpperCase())) return;
      }
      super.parse(field, data);
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCall.length() == 0) data.strCall = "RUN REPORT";
      data.strPlace = append(data.strPlace, "\n", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("[A-Z]{4}");
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("UNIT")) return new UnitField("[A-Z]+[0-9]+", true);
    if (name.equals("ID")) return new IdField("\\d{9}");
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
}
