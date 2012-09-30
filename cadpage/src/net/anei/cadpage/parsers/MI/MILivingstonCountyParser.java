package net.anei.cadpage.parsers.MI;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * Livingston County, MI
 * @author ken
 *
 */
public class MILivingstonCountyParser extends DispatchOSSIParser {
  
  public String getFilter() {
    return "CAD@livingstoncounty.livco,93001";
  }
  
  public MILivingstonCountyParser() {
    super(CITY_CODES, "LIVINGSTON COUNTY", "MI",
           "( CANCEL ADDR CITY | SRC ADDR CITY? CALL | FYI? CALL PLACE? ADDR/s! X? X? ) INFO+");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("FYI: ;") || body.startsWith("Update: ;")) body = "CAD:" + body;
    return super.parseMsg(body, data);
  }
  
  private class CancelField extends CallField {
    public CancelField() {
      setPattern("CANCEL");
    }
    
    @Override
    public String getFieldNames() {
      return "CALL";
    }
  }
  
  // Info field may contain a city code
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      String city = CITY_CODES.getProperty(field);
      if (city != null) {
        data.strCity = city;
      } else {
        super.parse(field, data);
      }
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CANCEL")) return new CancelField();
    if (name.equals("SRC")) return new SourceField("[A-Z]{4}", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BR",   "BRIGHTON",
      "BRTN", "BRIGHTON",
      "BY",   "BYRON",
      "BYRN", "BYRON",
      "CO",   "COHOCTAH",
      "COHC", "COHOCTAH",
      "DX",   "DEXTER",
      "DXTR", "DEXTER",
      "FE",   "FENTON",
      "FENT", "FENTON",
      "FO",   "FOWLERVILLE",
      "FOWL", "FOWLERVILLE",
      "GR",   "GREGORY",
      "GREG", "GREGORY",
      "HAM",  "HAMBURG",
      "HAMB", "HAMBURG",
      "HAR",  "HARTLAND",
      "HART", "HARTLAND",
      "HOL",  "HOLLY",
      "HOLL", "HOLLY",
      "HOW",  "HOWELL",
      "HOWL", "HOWELL",
      "LI",   "LINDEN",
      "LIND", "LINDEN",
      "LK",   "LAKELAND",
      "LKLD", "LAKELAND",
      "MI",   "MILFORD",
      "MILF", "MILFORD",
      "PE",   "PERRY",
      "PERY", "PERRY",
      "PI",   "PINCKNEY",
      "PINK", "PINCKNEY",
      "SL",   "SOUTH LYON",
      "SLYN", "SOUTH LYON",
      "ST",   "STOCKBRIDGE",
      "STKB", "STOCKBRIDGE",
      "WE",   "WEBBERVILLE",
      "WEBB", "WEBBERVILLE",
      "WH",   "WHITMORE LAKE",
      "WHIT", "WHITMORE LAKE",
      "ZANN", "ANN ARBOR",
      "ZBYR", "BYRON-OC",
      "ZCHL", "CHELSEA",
      "ZCLS", "CLARKSTON",
      "ZDBG", "DAVISBURG",
      "ZDEX", "DEXTER-OC",
      "ZFEN", "FENTON-OC",
      "ZFMH", "FARMINGTON HILLS",
      "ZFOW", "FOWLERVILLE-OC",
      "ZFRK", "FRANKLIN",
      "ZGRB", "GRAND BLANC",
      "ZGRG", "GREGORY-OC",
      "ZGRL", "GRASS LAKE",
      "ZHLD", "HIGHLAND",
      "ZHOL", "HOLLY-OC",
      "ZHRT", "HARTLAND-OC",
      "ZJKS", "JACKSON",
      "ZLAN", "LANSING",
      "ZLIN", "LINDEN-OC",
      "ZMIL", "MILFORD-OC",
      "ZMSN", "MASON",
      "ZMUN", "MUNITH",
      "ZNHD", "NEW HUDSON",
      "ZNOV", "NOVI",
      "ZNVL", "NORTHVILLE",
      "ZPIN", "PINCKNEY-OC",
      "ZPLL", "PLEASANT LAKE",
      "ZPLY", "PLYMOUTH",
      "ZPRY", "PERRY-OC",
      "ZROK", "ROYAL OAK",
      "ZSFD", "SOUTHFIELD",
      "ZSLM", "SALEM",
      "ZSLY", "SOUTH LYON-OC",
      "ZSTB", "STOCKBRIDGE-OC",
      "ZWIL", "WILLIAMSTON",
      "ZWIX", "WIXOM",
      "ZWLK", "WHITE LAKE",
      "ZWML", "WHITMORE LAKE-OC",
      "ZWVL", "WEBBERVILLE-OC",
      "ZYPS", "YPSILANTI",

  });
}
