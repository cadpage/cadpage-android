package net.anei.cadpage.parsers.IL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class ILStClairCountyParser extends FieldProgramParser {
  
  private static final String MSG_PREFIX = "Fire Run";
  private static final Pattern PTN_GARBAGE = Pattern.compile("^(\\p{ASCII}+)");
  private static final Pattern PTN_GARBAGE_PRE = Pattern.compile("(\\p{ASCII}+)$");
  private static final Pattern PTN_CROSS_STREET = Pattern.compile("\\(/?(.*)\\) ");
  
  public ILStClairCountyParser() {
    super(CITY_LIST, "ST CLAIR COUNTY", "IL",
           "Response_Type:CALL! Location:ADDRCITY/S! Cross:X? Creation_Time:DATETIME! Agency:SRC");
  }
   
  @Override
  public String getFilter() {
    return "freeburgfire@yahoo.com,@stclaircountyil.gov,sjr5536@aol.com,svfd4801@yahoo.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // One of the messages has extra characters at the end.
    // Many of the others have extra characters at the beginning.  
    // Need to check both in case we need the message header.
    Matcher garbage = PTN_GARBAGE.matcher(body);
    if(garbage.find()) {
      body = garbage.group(1);
    }
    else {
      Matcher preGarbage = PTN_GARBAGE_PRE.matcher(body);
      if(preGarbage.find()) {
        body = preGarbage.group(1);
      }
    }
    
    // Remove message header for now.
    if(body.startsWith(MSG_PREFIX)) {
      body = body.substring(MSG_PREFIX.length()).trim();
    }
    
    // Put delimiter in front of Location label
    body = body.replace(" Location:", "\nLocation:");
    
    // Add label for Cross street
    Matcher crossMatch = PTN_CROSS_STREET.matcher(body);
    if(crossMatch.find()) {
      body = body.substring(0, crossMatch.start()) + "\nCross:" + crossMatch.group(1) + body.substring(crossMatch.end());
    }
    
    String[] fields = body.split("[\n\t]");
    if (!parseFields(fields, data)) return false;
    
    if (data.strAddress.startsWith("@") && data.strCross.length() > 0) {
      data.strPlace = data.strAddress.substring(1).trim();
      data.strAddress = "";
      parseAddress(data.strCross, data);
      data.strCross = "";
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("ADDR", "PLACE ADDR");
  }
  
  
  private static final Pattern PTN_FULL_ADDR = Pattern.compile("(.*, .*), *\\d{5}(?: +#(.*))?");
  private class MyAddressField extends AddressCityField {
    
    @Override 
    public void parse(String field, Data data) {
      String apt = "";
      Matcher m = PTN_FULL_ADDR.matcher(field);   // This will match address, city, and zip
      if (m.matches()) {
        field = m.group(1).trim();                       // Remove the zipcode
        apt = getOptGroup(m.group(2));
      }
      super.parse(field, data);
      data.strApt = append(data.strApt, "-", apt);
    }
   
  }
  
  private static final String DATETIME = "\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}:\\d{2}";
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressField();
    if (name.equals("DATETIME")) return new DateTimeField(DATETIME, true);
    return super.getField(name);
    
  }
  
  private static final String[] CITY_LIST = {
    "BELLEVILLE",
    "CAHOKIA",
    "CANTEEN",
    "CASEYVILLE",
    "CENTREVILLE",
    "DUPO",
    "EAST ST. LOUIS",
    "ENGLEMANN",
    "FREEBURG",
    "LEBANON",
    "LENZBURG",
    "MARISSA",
    "MASCOUTAH",
    "MILLSTADT",
    "NEW ATHENS",
    "O'FALLON",
    "PRAIRIE DU LONG",
    "SHILOH VALLEY", 
    "SMITHTON", 
    "SAINT CLAIRE", 
    "STITES", 
    "STOOKEY", 
    "SUGAR LOAF", 
    "SWANSEA"
  };
}
