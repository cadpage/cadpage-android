package net.anei.cadpage.parsers.DE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Kent County, DE
 */
public class DEKentCountyBParser extends DEKentCountyBaseParser {
  
  private static final Pattern DELIM = Pattern.compile(" -- | : | (?=Lat:|Long:)");
  
  public DEKentCountyBParser() {
    super("CALL ADDRCITY! PLACE ( Xst's:X | Cross_STS:X ) Lat:GPS1 Long:GPS2");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    String[]  subFlds = subject.split("\\|");
    if (subFlds.length != 2) return false;
    if (!subFlds[0].equals("Chief Alert") && !subFlds[0].equals("Chief ALT")) return false;
    body = stripFieldStart(body, "- ");
    data.strSource = subFlds[1].trim();
    
    if (!super.parseFields(DELIM.split(body), data)) return false;
    if (data.strCross.equals("No Cross Streets Found")) data.strCross = "";
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    return super.getField(name);
  }
  
  // Call field concatenates with dashes
  // And extract possible leading code
  private static final Pattern CODE_PTN = Pattern.compile("^(\\d{1,2}[A-Z]\\d{1,2}) - ");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CODE_PTN.matcher(field);
      if (match.find()) {
        data.strCode = match.group(1);
        field = field.substring(match.end()).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  // Address field may have comma delimited city name
  private static final Pattern ADDR_ST_ZIP_PTN = Pattern.compile("([A-Z]{2}) \\d{5}");
  private class MyAddressCityField extends AddressCityField {
    
    @Override
    public void parse(String field, Data data) {
      
      // There is always a comma delimited city/state field
      int pt = field.lastIndexOf(',');
      if (pt < 0) abort();
      String city = field.substring(pt+1).trim();
      field = field.substring(0,pt);
      
      // SOmetimes the trailing field is a state zip field, in which case
      // the city will be found in the address line
      Matcher match = ADDR_ST_ZIP_PTN.matcher(city);
      if (match.matches()) {
        data.strState = match.group(1);
        parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, field, data);
        if (data.strCity.length() == 0) abort();
        setState(data);
      }
      
      // Otherwise, the trailing item is a real city and we have to infer the state
      else {
        data.strCity = city;
        field = field.replaceAll("  +", " ");
        parseAddress(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " ST";
    }
  }
}
