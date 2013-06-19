package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
/**
 * Bell County, TX
 */
public class TXBellCountyParser extends FieldProgramParser {
  
  public TXBellCountyParser() {
    super(CITY_CODES, "BELL COUNTY", "TX",
        "LOC:ADDR/S! TYPE_CODE:CALL! SubType:CALL CALLER_NAME:NAME! CLRNUM:PHONE! TIME:TIME! Comments:INFO");
  }
  
  public String getFilter() {
    return "930010";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  private static final Pattern PLACE_MARKER = Pattern.compile(": ?[@:]");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("CHAPPARAL", "CHAPARRAL");
      if (field.startsWith("@")) {
        data.strAddress = field;
      } else {
        Matcher match = PLACE_MARKER.matcher(field);
        if (match.find()) {
          data.strPlace = field.substring(match.end()).trim();
          field = field.substring(0,match.start()).trim();
        }
        super.parse(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    if (addr.startsWith("@")) {
      int pt = addr.indexOf(':');
      if (pt < 0) pt = addr.length();
      addr = "I 35 MM " + addr.substring(1,pt);
    }
    return addr;
  }
  
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BELL", "",         // Bell County
      "TROY", "TROY"
  });
  
}
