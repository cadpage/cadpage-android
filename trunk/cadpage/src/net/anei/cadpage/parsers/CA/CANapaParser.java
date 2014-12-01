package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class CANapaParser extends FieldProgramParser {

  public CANapaParser() {
    super(CITY_CODES, "NAPA", "CA", "Location:ADDR/S! TYPE_CODE:CALL! CALLER_NAME:NAME! CALLER_ADDR:SKIP! TIME:TIME!");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    return super.parseMsg(body, data);
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("TIME")) return new TimeField("\\d{2}:\\d{2}:\\d{2}");
    return super.getField(name);
  }

  private static Pattern ADDR_APT_PLACE_APT_PLACE = Pattern.compile("(.*?)(?:,(.*?))?(?:: (?:@(.*?))?(?:#(.*?))?(?:@(.*?))?)?"); // we dont know if @ or # comes first
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Matcher mat = ADDR_APT_PLACE_APT_PLACE.matcher(field);
      if (!mat.matches()) abort();
      super.parse(mat.group(1), data);
      data.strApt = append(getOptGroup(mat.group(2)), ", ", getOptGroup(mat.group(4)));
      data.strPlace = append(getOptGroup(mat.group(3)), ", ", getOptGroup(mat.group(5)));
    }

    @Override
    public String getFieldNames() {
      return "ADDR CITY APT PLACE";
    }
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[] {
    "AMC", "AMERICAN CANYON",
    "CNTY CST", "CALISTOGA COUNTY",
    "CNTY NAPA", "NAPA COUNTY",
    "CST", "CALISTOGA",
    "DRP", "DEER PARK",
    "NAPA", "NAPA",
    "STH", "ST HELENA",
    "YNT", "YOUNTVILLE"
  });
  
}
