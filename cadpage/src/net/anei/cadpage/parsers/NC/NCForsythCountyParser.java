package net.anei.cadpage.parsers.NC;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NCForsythCountyParser extends FieldProgramParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "FC", "FORSYTH COUNTY",
      "BE", "BETHANIA",
      "CL", "CLEMMONS",
      "HP", "HIGH POINT",
      "KE", "KERNERSVILLE",
      "LE", "LEWISVILLE",
      "RH", "RURAL HALL",
      "TO", "TOBACCOVILLE",
      "WA", "WALKERTOWN",
      "WS", "WINSTON-SALEM"
  });
  
  private static final Pattern MA_PATTERN = Pattern.compile("@(.+):"); 
  
  public NCForsythCountyParser() {
    super(CITY_CODES, "FORSYTH COUNTY", "NC",
           "Location:ADDR/S Nature:CALL! P:PRI DISTRICT:UNIT X_Str:X CALLER_NAME:NAME");
  }
  
  @Override
  public String getFilter() {
    return "forsythcountyfir@bellsouth.net,lfdalltext@lewisvillefire.com,gfdpaging@griffithfire.com,pgfr32@triad.rr.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace(": @", " @").replace('_', ' ');
    if (!super.parseMsg(body, data)) return false;
    
    if (data.strCity.equals(data.defCity)) data.strCity = "";
    if (data.strCross.equals("/")) data.strCross = "";
    
    // Intersections seem to be saved as cross streets, at least some of the time
    if (data.strAddress.length() == 0) {
      if (data.strCross.length() == 0) return false;
      String sAddress = data.strCross;
      data.strCross = "";
      parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, sAddress, data);
    }
    return true;
  }
  
  private static final Pattern FC_PTN = Pattern.compile("\\bFC\\b");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String fld, Data data) {
      Matcher match = MA_PATTERN.matcher(fld);
      if (match.find()) {
        data.strCity = match.group(1);
        fld = fld.substring(match.end()).trim();
      }
      int pt = fld.indexOf('@');
      if (pt >= 0) {
        data.strPlace = fld.substring(pt+1).trim();
        fld = fld.substring(0,pt).trim();
      }
      
      pt = fld.indexOf(",RM ");
      if (pt >= 0) {
        data.strApt = fld.substring(pt+4).trim();
        fld = fld.substring(0,pt).trim();
      }
      
      super.parse(fld, data);
      
      // The use FC (Forsythe County) to indicate county roads,
      // which neither the smart parser nor Google understand.
      // so change them to CO. (we can't do this prior to the smart parse
      // call because 'FC' is a legitimate city code.
      data.strAddress = FC_PTN.matcher(data.strAddress).replaceAll("CO");
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  private class MyPriorityField extends PriorityField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt >= 0) field = field.substring(0,pt);
      super.parse(field, data);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("PRI")) return new MyPriorityField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return RA_PTN.matcher(addr).replaceAll("");
  }
  private static final Pattern RA_PTN = Pattern.compile("\\bRA\\b", Pattern.CASE_INSENSITIVE);
}
