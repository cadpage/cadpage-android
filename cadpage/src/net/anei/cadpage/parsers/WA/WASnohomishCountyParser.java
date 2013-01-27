package net.anei.cadpage.parsers.WA;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class WASnohomishCountyParser extends FieldProgramParser {
  
  public WASnohomishCountyParser() {
    super("SNOHOMISH COUNTY", "WA",
           "CALL ADDR MAP CH MAP UNIT! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "6245";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!body.startsWith("** DISP **")) return false;
    body = body.substring(10).trim();
    return super.parseFields(body.split("!"), data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.lastIndexOf(',');
      if (pt < 0) abort();
      data.strCity = convertCodes(field.substring(pt+1).trim(), CITY_CODES);
      super.parse(field.substring(0,pt).trim(), data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith(",")) field = field.substring(1).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "GRF", "GRANITE FALLS",
      "LKS", "LAKE STEVENS",
      "ARL", "ARLINGTON",
      "SNO", "SNOHOMISH",
      "STW", "STANWOOD",
      "GBR", "GOLD BAR",
      "MCK", "MILL CREEK",
      "EVE", "EVERETT",
      "MAR", "MARYSVILLE",
      "DAR", "DARRINGTON",
      "SUL", "SULTAN",
      "LYN", "LYNNWOOD",
      "IDX", "INDEX",
      "EDM", "EDMONDS",
      "MON", "MONROE",
      "MUK", "MUKILTEO",
      "BOT", "BOTHELL",
      "MLT", "MOUNTLAKE TERRACE",
      "BRI", "BRIER",
  });
}
