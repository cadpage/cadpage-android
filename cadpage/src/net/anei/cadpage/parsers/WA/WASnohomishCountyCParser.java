package net.anei.cadpage.parsers.WA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.HtmlProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class WASnohomishCountyCParser extends HtmlProgramParser {
  public WASnohomishCountyCParser() {
    super("SNOHOMISH COUNTY", "WA",
          "UNIT PRI RESPOND_TO:ADDRCITY ROOM:APT INFO INFO/N INFO/N FOR:FOR_INFO INFO/N NAME:NAME");
  }

  @Override
  public String getProgram() {
    return super.getProgram()+" ID";
  }
  
  private static final Pattern SUBJECT_PATTERN
    = Pattern.compile("Trip Notification TRIP-(\\d{5})");
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    Matcher m = SUBJECT_PATTERN.matcher(subject);
    if (!m.matches())
      return false;
    data.strCallId = m.group(1);
    return super.parseMsg(body, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("UNIT")) return new UnitField("([A-Z0-9]+) YOU HAVE A CALL.*", true);
    if (name.equals("PRI")) return new PriorityField("Priority (\\d+).*", true);
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("FOR_INFO")) return new ForInfoField();
    if (name.equals("NAME")) return new MyNameField();
    return super.getField(name);
  }
  
  private static final Pattern MY_ADDRESS_CITY_PATTERN
    = Pattern.compile("(.*?),(.*?),(?: +([A-Z]{2}))? +\\d{5}");
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      int ndx = field.lastIndexOf(" - ");
      if (ndx > -1) {
        data.strPlace = field.substring(0, ndx).trim();
        field = field.substring(ndx+3).trim();
      }
      Matcher m = MY_ADDRESS_CITY_PATTERN.matcher(field);
      if (m.matches()) {
        parseAddress(m.group(1).trim(), data);
        data.strCity = m.group(2).trim();
        data.strState = getOptGroup(m.group(3));
      }
      else
        super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      // Overriding getProgram() doesn't set call id so do it here.
      return super.getFieldNames()+" ID PLACE ST";
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("Unknown") || field.equals(""))
        return;
      super.parse(field, data);
    }
  }
  
  private class ForInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(field, "\n", data.strSupp);
    }
  }
  
  private class MyNameField extends NameField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("Unknown"))
        return;
      super.parse(field, data);
    }
  }
}
