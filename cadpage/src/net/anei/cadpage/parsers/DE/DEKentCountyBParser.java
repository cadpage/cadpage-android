package net.anei.cadpage.parsers.DE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Kent County, DE
 */
public class DEKentCountyBParser extends DEKentCountyBaseParser {
  
  private static final Pattern LEAD_JUNK_PTN = Pattern.compile("[ -]+"); 
  private static final Pattern X_ALT_KEYWORD_PTN = Pattern.compile("\\b(?:Cross STS|Cross Sts):");
  private static final Pattern DELIM = Pattern.compile(" -- | : | - (?=Xst's:|Caller:)| (?=Lat:|Long:)");
  
  public DEKentCountyBParser() {
    super("CALL PLACE? ADDRCITY! PLACE Xst's:X Caller:NAME? Lat:GPS1 Long:GPS2");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    String[]  subFlds = subject.split("\\|");
    if (subFlds.length != 2) return false;
    if (!subFlds[0].equals("Chief Alert") && !subFlds[0].equals("Chief ALT")) return false;
    Matcher match = LEAD_JUNK_PTN.matcher(body);
    if (match.lookingAt()) body = body.substring(match.end()); 
    data.strSource = subFlds[1].trim();
    
    // remove any line breaks
    body = body.replace("\n", "");
    
    // They have a variety of cross street keywords that we will map to the
    // most common Xst's:
    body = X_ALT_KEYWORD_PTN.matcher(body).replaceFirst("Xst's:");
    
    if (!super.parseFields(DELIM.split(body), data)) return false;
    if (data.strName.equals("N/A")) data.strName = "";
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
    if (name.equals("X")) return new MyCrossField();
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
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      // There is (almost) always a comma delimited city/state field
      int pt = field.lastIndexOf(',');
      if (pt >= 0) {
        String city = field.substring(pt+1).trim();
        field = field.substring(0,pt);
        
        // SOmetimes the trailing field is a state zip field, in which case
        // the city will be found in the address line
        Matcher match = ADDR_ST_ZIP_PTN.matcher(city);
        if (match.matches()) {
          String state = match.group(1);
          Result res = parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, field);
          if (res.getCity().length() == 0) return false;
          res.getData(data);
          data.strState = state;
        }
        
        // Otherwise, the trailing item should be real city and we have to infer the state
        else {
          if (!isCity(city)) return false;
          data.strCity = city;
          field = field.replaceAll("  +", " ");
          parseAddress(field, data);
        }
      }
      
      // OK, sometimes there is no comma, in which case we expect the smart
      // address parser to find it at the end of the field
      else {
        Result res = parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, field);
        if (res.getCity().length() == 0) return false;
        res.getData(data);
      }
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " ST";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("No Cross Streets Found")) return;
      field = field.replace(" Cross St2: ", " / ");
      super.parse(field, data);
    }
  }
}
