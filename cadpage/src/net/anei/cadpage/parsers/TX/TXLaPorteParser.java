package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * Nassau Bay (Harris County, TX)  
 */

public class TXLaPorteParser extends DispatchOSSIParser {
  
  private static final Pattern PREFIX = Pattern.compile("^\\d*:");
  
  public TXLaPorteParser() {
    this("LA PORTE", "TX");
  }
  
  protected TXLaPorteParser(String defCity, String defState) {
    super(CITY_CODES, defCity, defState,
          "( FYI SRC? CALL! ADDR! UNIT? CITY? CODE? DATETIME! | CANCEL ADDR! CITY? ) INFO+");
  }
  
  @Override
  public String getAliasCode() {
    return "TXNassauBay";
  }
  
  @Override
  public String getFilter() {
    return "cad@ossicadpaging";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // Strip off option number prefix
    Matcher match = PREFIX.matcher(body);
    if (match.find()) {
      body = body.substring(match.end()).trim();
    }
    return super.parseMsg(body, data);
  }
  
  private static final Pattern LEAD_TRASH_PTN = Pattern.compile("^(?:Event spawned from |\\(S\\) *\\(N\\)) *");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = LEAD_TRASH_PTN.matcher(field);
      if (match.find()) field = field.substring(match.end());
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CANCEL")) return new CallField("CANCEL", true);
    if (name.equals("SRC")) return new SourceField("[A-Z]{4}", true);
    if (name.equals("UNIT")) return new UnitField("(?:[A-Z]+\\d+|[A-Z]{2}FD|\\d{2,4})(?:,.*)?|SENS", true);
    if (name.equals("CODE")) return new CodeField("[A-Z]{1,2}[A-Z0-9]{1,2}", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String address) {
    address = PVT_DR_PTN.matcher(address).replaceAll("");
    address = DASH_ALPH_PTN.matcher(address).replaceAll("");
    address = HALF_PTN.matcher(address).replaceAll("1/2");
    return address.trim();
  }
  private static final Pattern PVT_DR_PTN = Pattern.compile("\\(PVT.*?\\)(?: *(?:DR|RD)\\b)?", Pattern.CASE_INSENSITIVE);
  private static final Pattern DASH_ALPH_PTN = Pattern.compile("-(?:SH|ST|LA).*$");
  private static final Pattern HALF_PTN = Pattern.compile("\\bHALF\\b", Pattern.CASE_INSENSITIVE);
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CLEMC", "CLEAR LAKE",
      "CS", "CLEAR LAKE SHORES",
      "DP", "DEER PARK",
      "EL", "EL LAGO",
      "FB", "FOREST BEND",
      "FW", "FRIENDSWOOD",
      "GALV", "GALVESTON",
      "HC", "",
      "HO", "NASSAU BAY",
      "LC", "LEAGUE CITY",
      "LP", "LA PORTE",
      "MP", "MORGANS POINT",
      "NB", "NASSAU BAY",
      "PA", "PASADENA",
      "SB", "SEABROOK",
      "SO", "",           // Harris County Sherrifs office
      "WB", "WEBSTER"
  });
}
