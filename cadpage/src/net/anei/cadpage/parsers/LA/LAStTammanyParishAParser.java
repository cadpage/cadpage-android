package net.anei.cadpage.parsers.LA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * St Tammany Parish, LA
 * NOTES: There is an Apartment field that is not always present.  This means that 
 * the SRC_X field must have check logic in order for the FieldProgramParser to know
 * whether the apartment field exits or not.
 */
public class LAStTammanyParishAParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("\\|");
  
  public LAStTammanyParishAParser() {
    super("ST TAMMANY PARISH", "LA",
        "CALL! PLACE ADDRCITY APT? SRC_X TIME! INFO");
  }
  
  @Override
  public String getFilter() {
    return "@dapage.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    String[] fields = DELIM.split(body);
    
    // Check to see subject and first field match, this is just so we 
    // don't have a greedy parser
    if(!subject.equals(fields[0])) return false;
    
    if(!super.parseFields(fields, data)) return false;
    
    if (data.strAddress.length() == 0) {
      data.strAddress = "";
      parseAddress(data.strCross, data);
      data.strCross = "";
    }
    
    // Replace certain small towns or subdivisions with Google parameter
    String cityAlt = CITY_TABLE.getProperty(data.strCity);
    if(cityAlt != null && cityAlt.length() > 0) {
      data.strPlace = data.strCity;
      data.strCity = cityAlt;
    }
    
    return true;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("SRC_X")) return new MySourceCrossField();
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d", true);
    return super.getField(name);
  }
  
  /***
   * MySourceCrossField - Extracts from the field that contains the source the 
   * cross streee and source.  It also checks for an optional GRID field.  Grid is
   * then stored in MAP.
   */
  private static final Pattern SOURCE_X_PTN = Pattern.compile("(STA [^ ]+) ?(?:GRID (\\d+))? XS");
  private class MySourceCrossField extends SourceField {
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher sourceMatch = SOURCE_X_PTN.matcher(field);
      if(sourceMatch.find()) {
        parse(field, data);
        return true;
      }
      else return false;
    }
    
    @Override 
    public void parse(String field, Data data) {
      Matcher sourceMatch = SOURCE_X_PTN.matcher(field);
      if(sourceMatch.lookingAt()) {
        data.strSource = sourceMatch.group(1).trim();
        data.strMap = getOptGroup(sourceMatch.group(2));
        data.strCross = field.substring(sourceMatch.end()).trim();
      }
    }
    
    @Override 
    public String getFieldNames() {
      return super.getFieldNames() + " X MAP";
    }
    
    @Override 
    public boolean canFail() {
      return true;
    }
    
  }

  // Lookup table for Google city designations
  private static final Properties CITY_TABLE = buildCodeTable(new String[]{
    "ST JOE", "6"
  });
}
