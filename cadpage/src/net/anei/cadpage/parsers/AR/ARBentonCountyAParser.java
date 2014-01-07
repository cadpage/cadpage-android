package net.anei.cadpage.parsers.AR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class ARBentonCountyAParser extends FieldProgramParser {
  
  private static final String[] CITY_LIST = new String[] {
    "AVOCA",
    "BELLA VISTA",
    "BENTON COUNTY",
    "BENTONVILLE",
    "BETHEL HEIGHTS",
    "CAVE SPRINGS",
    "CENTERTON",
    "DECATUR",
    "ELM SPRINGS",
    "GARFIELD",
    "GATEWAY",
    "GENTRY",
    "GRAVETTE",
    "HIGHFILL",
    "HINDSVILLE",
    "HIWASSE",
    "LITTLE FLOCK",
    "LOWELL",
    "PEA RIDGE",
    "ROGERS",
    "SILOAM SPRINGS",
    "SPRINGDALE",
    "SPRINGTOWN",
    "SULPHUR SPRINGS",
    "WAR EAGLE",
    
    "DELAWARE_CO",
    "WASHINGTON_CO",
    "DELAWARE COUNTY",
    "WASHINGTON COUNTY"
  };
  
  public ARBentonCountyAParser() {
    super(CITY_LIST, "BENTON COUNTY", "AR",
           "ADDR/S ( NAME PHONE/Z ID | NAME ID | ID ) TIME CALL! INFO");
  }
  
  @Override
  public String getFilter() {
    return "OECOperations@bentoncountyar.gov";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Reject any message that does not start with "OECOperations"
    if(!body.startsWith("OECOperations:")) return false;
    
    // Remove the "OECOperations:" 
    int colon = body.indexOf(':');
    if(colon >= 0) {
      body = body.substring(colon+1).trim();    
    }
    
    // Check to see if the subject contains field data and if so, combine with message body
    if(subject.length() > 0 && !subject.equals("Text Message")) {
      body = subject + ":" + body;
    }
    
    // Parse the fields
    String[] fields = body.split(";");
    if (parseFields(fields, 4, data)) return true;
    
    // If parsing fails, return general alert
    return data.parseGeneralAlert(this,body);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      super.parse(field, data);
      
      if (data.strCity.endsWith("_CO")) {
        data.strCity = data.strCity.substring(0,data.strCity.length()-3).trim() + " COUNTY";
      }
      if (data.strCity.equalsIgnoreCase("DELAWARE COUNTY")) data.strState = "OK";
    }
  }
  
  private static final Pattern PTN_TIME = Pattern.compile("\\d{2}:\\d{2}:\\d{2}");
  private class MyTimeField extends TimeField {
    
    @Override 
    public void parse(String field, Data data) {
      Matcher m = PTN_TIME.matcher(field);
      if(m.matches()) {
        data.strTime = field;
      }
      else {
        data.strTime = "";
      }
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if(name.equals("ID")) return new IdField("\\d{10}", true);
    if (name.equals("TIME")) return new MyTimeField();
    return super.getField(name);
  }
}
