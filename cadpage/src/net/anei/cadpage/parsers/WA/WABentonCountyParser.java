package net.anei.cadpage.parsers.WA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class WABentonCountyParser extends FieldProgramParser {

  public WABentonCountyParser() {
    super(CITY_CODES, "BENTON COUNTY", "WA", "Location:ADDR/S46! X-St:X! &:X! DispUnit(s):UNIT");
  }

  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("SECOMM")) return false;
    
    if (body.startsWith(":")) body = "Location" + body;
    else if (!body.startsWith("Location:")) body = "Location:" + body;
    
    if (!super.parseMsg(subject, body, data)) return false;
    if (data.strAddress.length() == 0) {
      parseAddress(data.strCross, data);
      data.strCross = "";
    }
    return true;
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }

  private static Pattern ADDR = Pattern.compile("(.*?)(?: : *@?(.*))?(\\d{2}:\\d{2}:\\d{2})(.*)");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Matcher mat = ADDR.matcher(field);
      if (!mat.matches()) abort();
      super.parse(mat.group(1).trim(), data);
      data.strApt = getLeft();
      data.strPlace = getOptGroup(mat.group(2));
      data.strTime = mat.group(3);
      data.strCall = mat.group(4).trim();
    }

    @Override
    public String getFieldNames() {
      return "ADDR CITY APT PLACE TIME CALL";
    }
  }
  
  private static Properties CITY_CODES = buildCodeTable(new String[] {
      "BNCT BENT", "BENTON CITY",
      "BNCO BENT", "BENTON COUNTY",
      "RICH BENT", "RICHLAND",
      "WRCH BENT", "WEST RICHLAND"
  });

}
