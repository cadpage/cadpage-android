package net.anei.cadpage.parsers.KS;

import java.util.regex.*;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Reno County, KS
 */
public class KSRenoCountyParser extends FieldProgramParser {
  public KSRenoCountyParser() {
    super("RENO COUNTY", "KS",
        "ADDR ( City:VENUE Type:CALL Narr:INFO Incident#:ID Latitude:GPS "
+               " | "
+               "Venue:VENUE Type:CALL Narr:INFO Incident#:ID )");
  }
  
  @Override
  public String getFilter() {
    return "NWSPage@renolec.com";
  }  
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }

  @Override
  public boolean parseMsg(String msg, Data data) {
    msg = msg.replace("\n", "").replace("[Longitude]", ", ");
    msg = msg.replaceAll("(?i)\\[([A-Z#]+)\\]", "$1:");
    return super.parseMsg(msg, data);  
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("VENUE")) return new VenueField();
    return super.getField(name);
  }
  
  private static final Pattern MY_ADDRESS_PATTERN
    = Pattern.compile("(?i)^([^/]+?) +\\/ +([A-Z0-9]+)$");
  private static final Pattern KS61_PTN 
    = Pattern.compile("\\bK(\\d+)\\b", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String aptField = "";
      Matcher m = MY_ADDRESS_PATTERN.matcher(field);
      if (m.matches()) {
        field = m.group(1);
        aptField = m.group(2);
      }
      // google doesn't understand K61 as being KS 61
      field = KS61_PTN.matcher(field).replaceAll("KS $1");
      super.parse(field, data);
      data.strApt = append(data.strApt, " ", aptField);
    }
  }
  
  private class VenueField extends CityField {
    @Override
    public void parse (String field, Data data) {
      if (field.equals("COUNTY")) return;
      super.parse(field, data);
    }
  }
}
