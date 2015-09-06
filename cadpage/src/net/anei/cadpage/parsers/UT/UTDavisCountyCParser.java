package net.anei.cadpage.parsers.UT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class UTDavisCountyCParser extends FieldProgramParser {
  
  public UTDavisCountyCParser() {
    super(CITIES, "DAVIS COUNTY", "UT",
        "ADDR X? INFO+");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(body.split(";"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }

  private static final Pattern PHONE_PATTERN
    = Pattern.compile("(?:\\.(\\d{3}[\\- ]\\d{3}[\\- ]\\d{4})|(\\d{3}[\\- ]\\d{4}) +/)(.*)");
  private static final Pattern TIMESTAMPED_PATTERN
    = Pattern.compile("(.*)(\\d\\d:\\d\\d:\\d\\d) (\\d\\d/\\d\\d/\\d{4}) -(.*)");
  private static final Pattern PROQA_PATTERN
    = Pattern.compile("(.*)\\(P.*");
  private class UTDavisInfoField extends InfoField {
    protected void parseInfo(String field, Data data) {
      Matcher m = PHONE_PATTERN.matcher(field);
      if (m.matches()) {
        data.strPhone = getOptGroup(m.group(1))+getOptGroup(m.group(2));
        field = m.group(3).trim();
      }
      m = TIMESTAMPED_PATTERN.matcher(field);
      if (m.matches()) {
        data.strSupp = append(data.strSupp, "/", m.group(1).trim());
        data.strTime = m.group(2);
        data.strDate = m.group(3);
        String trailer = m.group(4).trim();
        m = PROQA_PATTERN.matcher(trailer);
        if (m.matches()) {
          data.strName = m.group(1).trim();
          field = "";
        }
        else
          field = trailer;
      }
      data.strSupp = append(data.strSupp, "/", field);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames()+" CALL ADDR CITY X PLACE PHONE TIME DATE NAME";
    }
  }
  
  private class MyAddressField extends UTDavisInfoField {
    @Override
    public void parse(String field, Data data) {
      parseAddress(StartType.START_CALL, field, data);
      parseInfo(getLeft(), data);
    }
  }
  
  private static final Pattern UTAH_ADDRESS_PATTERN
    = Pattern.compile("[EWNS] +\\d{3,4} +[EWNS]");
  private class MyInfoField extends UTDavisInfoField {
    @Override
    public void parse(String field, Data data) {
      if(data.strCity.equals("")) {
        Result r = parseAddress(StartType.START_OTHER, FLAG_ONLY_CITY, field);
        if (r.isValid()) {
          int cl;
          r.getData(data);
          int ndx = field.lastIndexOf(data.strCity);
          if (ndx < 0)
            ndx = cl = 0;
          else
            cl = data.strCity.length();
          String p = field.substring(0,ndx).trim();
          field = field.substring(ndx + cl);
          r = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, p);
          if (r.isValid())
            data.strCross = p;
          else {
            Matcher m = UTAH_ADDRESS_PATTERN.matcher(p);
            if (m.find())
              data.strCross = p;
            else
              data.strPlace = p;
          }
        }
      }
      parseInfo(field.trim(), data);
    }
  }
  
  private static final String[] CITIES = {
      "BOUNTIFUL",
      "CENTERVILLE",
      "CLEARFIELD",
      "CLINTON",
      "FARMINGTON",
      "FRUIT HEIGHTS",
      "KAYSVILLE",
      "LAYTON",
      "NORTH SALT LAKE",
      "SOUTH WEBER",
      "SUNSET",
      "SYRACUSE",
      "WEST BOUNTIFUL",
      "WEST POINT",
      "WOODS CROSS",  
  };
}
