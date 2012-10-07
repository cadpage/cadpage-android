package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class DESussexCountyAParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "DE";
  private static final String DEF_CITY = "SUSSEX COUNTY";
  
  private static final String[] CITY_LIST = new String[] {
    "BETHANY BEACH", "BETHEL", "BLADES", "BRIDGEVILLE", "DAGSBORO", "DELMAR",
    "DEWEY BEACH", "ELENDALE", "FENWICK ISLAND", "FRANKFORD", "GEORGETOWN",
    "GREENWOOD", "HENLOPEN ACRES", "LAUREL", "LEWES", "MILFORD", "MILLSBORO",
    "MILLVILLE", "MILTON", "OCEAN VIEW", "REHOBOTH BEACH", "SEAFORD", "SELBYVILLE",
    "SLAUGHTER BEACH", "SOUTH BETHANY"
  };
                                                       
  
  public DESussexCountyAParser() {
    super(CITY_LIST, DEF_CITY, DEF_STATE);
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    String[] subjects = subject.split("\\|");
    if (subjects.length > 2) return false;
    if (subjects.length == 2) {
      if (!subjects[0].equals("Chief ALT")) return false;
      subject = subjects[1];
    }
    data.strSource = subject;
    
    if (!body.startsWith("-- ")) return false;
    body = body.substring(3).trim();

    // First divide up the call
    String strBody[] = body.split(" *-- *");
    if (strBody.length < 2) return false;

    // field 0 - the call description
    data.strCall = strBody[0].trim();

    // See how many fields we have
    int fldCnt = strBody.length;

    // If more than 2 and the last fields starts with "INC ", ignore it
    if (fldCnt > 2 && strBody[fldCnt-1].trim().startsWith("INC ")) fldCnt--;

    // If we are down to 2 fields, the last one is the address line and
    // nothing needs to be worried about
    Result result;
    if (fldCnt == 2) {
      result = parseAddress(strBody[1]);
    }

    // Otherwise we have big problems, one of lines 3 and 4 is the address
    // line and one is a place name.  But we don't know which is which.
    else {
      Result res2 = parseAddress(strBody[1]);
      Result res3 = parseAddress(strBody[2]);
      if (res2.getStatus() >= res3.getStatus()) {
        result = res2;
        data.strPlace = strBody[2];
      } else {
        result = res3;
        data.strPlace = strBody[1];
      }
    }

    if (result.getStatus() == 0) return false;
    result.getData(data);
      
      // Hopefully it found a city, if not we will have to parse one out
      // of what is left
      if (data.strCity.length() == 0) {
        
        // If the last token in what is left is a 5 digit zip code, strip it off
        String sAddress = getLeft();
        Parser p = new Parser(sAddress);
        String last = p.getLastOptional(' ');
        if (last.length() == 5 && NUMERIC.matcher(last).matches()) sAddress = p.get();
        
        // If last character is a comma, get rid of it
        
        // If the new last token is "DE" with or without a trailing comma, strip it off 
        p = new Parser(sAddress);
        last = p.getLastOptional(' ');
        if (last.endsWith(",")) last = last.substring(0, last.length()-1);
        if (last.equalsIgnoreCase("DE")) sAddress = p.get();
      
        // Whatever is left is our city
        data.strCity = sAddress;
      }

    return true;
  }
  
  private Result parseAddress(String address) {
    address = address.trim();
    if (address.startsWith("0 ")) address = address.substring(2).trim();
    return parseAddress(StartType.START_ADDR, address);
  }
}


