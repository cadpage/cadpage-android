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
  private static final Pattern LINE_BRK_PTN = Pattern.compile(" *\n *");
  
  public TXLaPorteParser() {
    this("HARRIS COUNTY", "TX");
  }
  
  protected TXLaPorteParser(String defCity, String defState) {
    super(CITY_CODES, defCity, defState,
          "( KEMA_FMT KEMA_ADDR/aS9CI | " +
          "FYI ID? SRC? ( CALL_ADDR CITY | CALL! ( ADDR/Z CITY! | ADDR/Z UNIT UNIT+? CITY? | PLACE ADDR/Z CITY! | PLACE ADDR/Z UNIT UNIT+? CITY? | ADDR! ) ) UNIT+? ( ID PRI? | ) INFO+? DATETIME UNIT? INFO+ | " +
          "CANCEL ADDR! CITY? ) INFO+");
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
    
    // Kema alerts probably do not belong in this parser, but since Active911
    // handles them in the same parser, we will do likewise.
    if (body.startsWith("CANCEL ")) {
      data.strCall = "CANCEL";
      body = body.substring(7).trim();
      int pt = body.indexOf(';');
      if (pt >= 0) {
        data.strSupp = body.substring(pt+1).trim();
        body = body.substring(0,pt).trim();
      }
      parseAddress(body, data);
      return true;
    }
    
    if (body.startsWith("FYI:")) {
      body = "CAD:KEMA_FMT;" + body.substring(4).trim();
    }
      
    // Regular parsing takes up here
    else {
      
      // Strip off option number prefix
      Matcher match = PREFIX.matcher(body);
      if (match.find()) body = body.substring(match.end()).trim();
      body = LINE_BRK_PTN.matcher(body).replaceAll(" ");
    }
    
    // Both cases invoke the superclass parseMsg method
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
    if (name.equals("KEMA_FMT")) return new SkipField("KEMA_FMT", true);
    if (name.equals("KEMA_ADDR")) return new KemaAddressField();
    if (name.equals("CANCEL")) return new CallField("CANCEL", true);
    if (name.equals("ID")) return new IdField("\\d{10}", true);
    if (name.equals("PRI")) return new PriorityField("\\d");
    if (name.equals("SRC")) return new MySourceField();
    if (name.equals("CALL_ADDR")) return new MyCallAddressField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("CODE")) return new CodeField("[A-Z]{1,2}[A-Z0-9]{1,2}", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Pattern KEMA_WATERFRONT_PTN = Pattern.compile("(.*?) +(\\d+) KEMAH WATERFRONT\\b *(.*)");
  private static final Pattern KEMA_ADDR_PTN = Pattern.compile("(.*?) +((?:\\d+ (?:yoa?|yr|y/o) |[A-Z]?[a-z]).*)");
  private class KemaAddressField extends AddressField {
    @Override 
    public void parse(String field, Data data) {
      Matcher match = KEMA_WATERFRONT_PTN.matcher(field);
      if (match.matches()) {
        data.strCall = match.group(1);
        data.strAddress = match.group(2) + " KEMAH WATER FRONT";
        data.strSupp = match.group(3);
        return;
      }
      int flags = FLAG_START_FLD_REQ | FLAG_NO_IMPLIED_APT | FLAG_NO_CITY;
      match = KEMA_ADDR_PTN.matcher(field);
      if (match.matches()) {
        field = match.group(1);
        data.strSupp = match.group(2);
        flags |= FLAG_ANCHOR_END;
      }
      parseAddress(StartType.START_CALL, flags, field, data);
      if (data.strSupp.length() == 0) data.strSupp = getLeft();
    }
    
    @Override
    public String getFieldNames() {
      return "CALL ADDR INFO";
    }
  }
  
  private class MySourceField extends SourceField {
    public MySourceField() {
      super("[A-Z]{4}", true);
    }
    
    @Override
    public void parse(String field, Data data) {
      data.strSource = append(data.strSource, " ", field);
    }
  }
  
  private class MyCallAddressField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = ADDR_WATERFRONT_PTN.matcher(field);
      if (match.matches()) {
        data.strAddress = match.group(1) + " KEMAH WATER FRONT";
        return;
      }
      Result res = parseAddress(StartType.START_ADDR, FLAG_CHECK_STATUS | FLAG_ANCHOR_END, field);
      if (res.getStatus() > STATUS_NOTHING) {
        res.getData(data);
      } else {
        data.strCall = field;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CALL ADDR APT";
    }
  }
  
  private static final Pattern ADDR_WATERFRONT_PTN = Pattern.compile("(\\d+) KEMAH WATERFRONT");
  private class MyAddressField extends AddressField {
    @Override public void parse(String field, Data data) {
      Matcher match = ADDR_WATERFRONT_PTN.matcher(field);
      if (match.matches()) {
        data.strAddress = match.group(1) + " KEMAH WATER FRONT";
        return;
      }
      super.parse(field, data);
    }
  }
  
  private static final String UNIT_PTN1 = "(?:[A-Z]+\\d+|[A-Z]{2,4}|\\d{2,4})";
  private static final String UNIT_PTN = UNIT_PTN1 + "(?:," + UNIT_PTN1 + ")*";
  private class MyUnitField extends UnitField {
    
    public MyUnitField() {
      super(UNIT_PTN, true);
    }
    
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, ",", field);
    }
  }
  
  @Override
  public String adjustMapAddress(String address) {
    address = PVT_DR_PTN.matcher(address).replaceAll("");
    address = DASH_ALPH_PTN.matcher(address).replaceAll("");
    address = HALF_PTN.matcher(address).replaceAll("1/2");
    address = IH45_PTN.matcher(address).replaceAll("GULF FWY");
    return address.trim();
  }
  private static final Pattern PVT_DR_PTN = Pattern.compile("\\(PVT.*?\\)(?: *(?:DR|RD)\\b)?", Pattern.CASE_INSENSITIVE);
  private static final Pattern DASH_ALPH_PTN = Pattern.compile("-(?:SH|ST|LA).*$");
  private static final Pattern HALF_PTN = Pattern.compile("\\bHALF\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern IH45_PTN = Pattern.compile("\\bIH *45(?: *FWY)?", Pattern.CASE_INSENSITIVE);
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AL", "ALVIN",
      "CLEMC", "CLEAR LAKE",
      "CS", "CLEAR LAKE SHORES",
      "DP", "DEER PARK",
      "EL", "EL LAGO",
      "FB", "FOREST BEND",
      "FW", "FRIENDSWOOD",
      "GALV", "GALVESTON",
      "HC", "",
      "HO", "NASSAU BAY",
      "KH", "KEMAH",
      "LC", "LEAGUE CITY",
      "LP", "LA PORTE",
      "MP", "MORGANS POINT",
      "NB", "NASSAU BAY",
      "PA", "PASADENA",
      "PL", "PEARLAND",
      "SA", "SHOREACRES",
      "SB", "SEABROOK",
      "SE", "SOUTHEAST",
      "SO", "",           // Harris County Sherrifs office
      "TL", "SEABROOK",   // ???
      "WB", "WEBSTER",
      
      "BAYTOWN",    "BAYTOWN"
  });
}
