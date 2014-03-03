package net.anei.cadpage.parsers.CA;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class CASantaClaraCountyBParser extends FieldProgramParser {

  public CASantaClaraCountyBParser() {
    super(CITY_CODES, "SANTA CLARA COUNTY", "CA", "CALL! ADDRCITY! APT X! Map:MAP! ID UNIT! INFO+");
  }

  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CAD Page")) return false;

    return parseFields(body.split(";"), data);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) { return new MyAddressField(); }
    if (name.equals("INFO")) { return new MyInfoField(); }
    if (name.equals(("ID"))) { return new IdField("Inc# *(\\d*)", true); }
    return super.getField(name);
  }

  private class MyAddressField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("_", " ");
      int pi = field.indexOf("@");
      if (pi >= 0) {
        String p1 = field.substring(0, pi);
        String p2 = field.substring(pi + 1, field.length());
        p1 = p1.trim();
        p2 = p2.trim();
        data.strPlace = p1;
        super.parse(p2, data);
      } else {
        if (field.equals("NO TEXT")) return;
        super.parse(field, data);
      }
    }

    @Override
    public String getFieldNames() {
      return "PLACE " + super.getFieldNames();
    }
  }

  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field.replace(";", "/");
      int pi = field.indexOf("<a href=");
      if (pi >= 0) {
        setGPSLoc(field.substring(pi), data);
        field = field.substring(0, pi).trim();
      } 
      if (field.equals("NO TEXT")) return;
      super.parse(field, data);
    }

    @Override
    public String getFieldNames() {
      return "INFO GPS";
    }
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[] {
      "REDWOOD XSC",   "LOS GATOS",
      "SCOTTS_VALLEY", "LOS GATOS",
      "BURRELL",       "LOS GATOS" });

}
