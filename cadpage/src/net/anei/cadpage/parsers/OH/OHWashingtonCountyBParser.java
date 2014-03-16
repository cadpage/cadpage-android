package net.anei.cadpage.parsers.OH;

/**
 * Washington County, OH (B)
 */

import net.anei.cadpage.parsers.FieldProgramParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

public class OHWashingtonCountyBParser extends FieldProgramParser {

  public OHWashingtonCountyBParser () {
    super("WASHINGTON COUNTY", "OH",
          "DATETIME CALL ADDR INFO! EMPTY X");
  }
  
  @Override
  public String getFilter() {
    return "belprepd@gmail.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CAD Page")) return false;
    return parseFields(body.split("\n"), 4, data);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("CALL")) return new CallField("Report of -- +(.*)", true);
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new InfoField("Call Description is=> *(.*)", true);
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d\\d?/\\d\\d?/\\d{4}) @ (\\d\\d:\\d\\d:\\d\\d)");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      data.strTime = match.group(2);
    }
  }
  
  private static final Pattern ADDRESS_PTN = Pattern.compile("At (.*?),(.*?)\\((.*)\\)");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ADDRESS_PTN.matcher(field);
      if (!match.matches()) abort();
      parseAddress(match.group(1).trim().replace('@', '&'), data);
      data.strCity = match.group(2).trim();
      data.strPlace = match.group(3).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY PLACE";
    }
  }
  
  private static final Pattern CROSS_PTN = Pattern.compile("Cross Streets are - (.*?) and\\b(.*)");
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CROSS_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCross = append(match.group(1).trim(), " / ", match.group(2).trim());
    }
  }
}