package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * San Bernardino County, CA
 */
public class CASanBernardinoCountyBParser extends FieldProgramParser {
  
  public CASanBernardinoCountyBParser() {
    super(CITY_CODES, "SAN BERNARDINO COUNTY", "CA",
          "Incident_Number:ID! Location:ADDR/S6! Common_Name:PLACE! Call_Type:CALL! Call_Time:DATETIME! Narrative:INFO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@csb.gov";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS | MAP_FLG_SUPPR_LA;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Incident")) return false;
    body = body.replace("Call Type:", " Call Type:");
    return super.parseMsg(body,  data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{4}-\\d{8}", true);
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d\\d \\d\\d:\\d\\d", true);
    return super.getField(name);
  }
  
  private static final Pattern ADDR_GPS_PTN = Pattern.compile("(.*) ([-+]?\\d+\\.\\d{6,} +[-+]?\\d+\\.\\d{6,}|-361 -361)\\b *(.*)");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      String info = null;
      Matcher match = ADDR_GPS_PTN.matcher(field);
      if (match.matches()) {
        field = match.group(1).trim();
        setGPSLoc(match.group(2), data);
        info = match.group(3);
      }
      super.parse(field, data);
      if (info != null) {
        if (info.startsWith("APT")) {
          data.strApt = append(data.strApt, "-", info.substring(3).trim());
        } else {
          data.strSupp = info;
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY GPS";
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.lastIndexOf(" - ");
      if (pt >= 0) field = field.substring(0,pt).trim();
      super.parse(field, data);
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ARB", "ARROW BEAR",
      "BBC", "BIG BEAR CITY",
      "BLO", "BLOOMINGTON",
      "BLU", "BLUE JAY",
      "CED", "CEDAR GLEN",
      "COL", "COLTON",
      "CPP", "CEDAR PINES PARK",
      "CRL", "CRESTLINE",
      "DEV", "DEVORE",
      "FON", "FONTANA",
      "GRT", "GRAND TERRACE",
      "GVL", "GRASS VALLEY",
      "HIG", "HIGHLAND",
      "LOM", "LOMA LINDA",
      "LYC", "LYTLE CREEK",
      "MEN", "MENTONE",
      "MUS", "MUSCOY",
      "ONT", "ONTARIO",
      "PAT", "PATTON",
      "RCC", "RANCHO CUCAMONGA",
      "RED", "REDLANDS",
      "RIA", "RIALTO",
      "RIM", "RIM FORREST",
      "RSP", "RUNNING SPRINGS",
      "SBC", "SAN BERNARDINO COUNTY",
      "SBO", "SAN BERNARDINO",
      "SIL", "SILVERWOOD LK",
      "SKY", "SKY FORREST",
      "SMI", "SAN MANUEL",
      "TPK", "TWIN PEAKS",
      "VOE", "VALLEY OF ENCHANTMENT",
      "YUC", "YUCAIPA"

  });
}
