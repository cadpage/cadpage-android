package net.anei.cadpage.parsers.NJ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Salem County, NJ (Deepwater)
 */
public class NJSalemCountyBParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile(" -- | - (?=Cross STS:)");
  
  public NJSalemCountyBParser() {
    super(CITY_LIST, "SALEM COUNTY", "NJ",
           "CALL! ADDR/S! Cross_STS:X? Caller:NAME");
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net,msg@cfmsg.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Drop calls from New Castle County, DE (B)
    if (body.contains(" EMD:")) return false;
   
    if (!subject.startsWith("Chief ALT|")) return false;
    data.strSource = subject.substring(10).trim();
    
    if (!body.startsWith("-- ")) return false;
    body = body.substring(3).trim();
    return parseFields(DELIM.split(body), data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }

  private static final Pattern STATE_PTN = Pattern.compile(" +([A-Z]{2})$");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      super.parse(field, data);
      Matcher match = STATE_PTN.matcher(data.strCity);
      if (match.find()) {
        data.strState = match.group(1);
        if (data.strState.equals("NJ")) data.strState = "";
        data.strCity = data.strCity.substring(0, match.start()).trim();
      }
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " ST";
    }
  }
  
  private static final Pattern PHONE_PTN = Pattern.compile(" +(\\d{7,})$");
  private class MyNameField extends NameField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = PHONE_PTN.matcher(field);
      if (match.find()) {
        data.strPhone = match.group(1);
        field = field.substring(0,match.start());
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "NAME PHONE";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("NAME")) return new MyNameField();
    return super.getField(name);
  }
  
  private static String[] CITY_LIST = new String[]{
    "NEW CASTLE DE",
    "DELMAR MD",
    "PARSONSBURG MD",
    "CARNEYS POINT TOWNSHIP NJ",
    "PENNSVILLE TOWNSHIP NJ"
  };
}


