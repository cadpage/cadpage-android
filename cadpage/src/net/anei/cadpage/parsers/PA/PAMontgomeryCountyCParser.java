package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class PAMontgomeryCountyCParser extends FieldProgramParser {
  
  private static final Pattern DATE_TIME_MARKER = Pattern.compile("^(\\d\\d:\\d\\d:\\d\\d) (\\d\\d-\\d\\d-\\d\\d) +(?:EVENT: *([A-Z]\\d+) +)?");
  private static final Pattern SPECIAL_ALERT_PTN = Pattern.compile("^#([A-Z]\\d+) at (.*?), Note: (.*)");
  private static final Pattern APT_PTN = Pattern.compile(", *([A-Z0-9]+)$");
  private static final Pattern COMMA_DELIM = Pattern.compile(",(?=BOX:|TIME:|NOTES:)");
  
  public PAMontgomeryCountyCParser() {
    super(PAMontgomeryCountyParser.CITY_CODES, "Montgomery County", "PA",
        "ADDR/S TRUCKS:UNITADDR? Place:PLACE? XST:X! MUN:CITY? NAT:CALL! BOX:BOX ADC:ID TIME:TIME NOTES:INFO TRUCKS:UNIT");
   }

  @Override
  public String getFilter() {
    return "@c-msg.net";
  }

  @Override 
  public boolean parseMsg(String body, Data data) {
    
    // Process Date/Time/ID marker
    boolean dateTimeMark = false;
    Matcher match = DATE_TIME_MARKER.matcher(body);
    if (match.find()) {
      dateTimeMark = true;
      data.strTime = match.group(1);
      data.strDate = match.group(2).replace('-', '/');
      data.strCallId = getOptGroup(match.group(3));
      body = body.substring(match.end());
    }
    
    // Process special general alerts
    match = SPECIAL_ALERT_PTN.matcher(body);
    if (match.matches()) {
      setFieldList("ID ADDR CITY APT PLACE CALL");
      data.strCallId = match.group(1);
      String addr = match.group(2).trim();
      data.strCall = match.group(3).trim();
      
      int pt = addr.indexOf(": @");
      if (pt >= 0) {
        data.strPlace = addr.substring(pt+3).trim();
        addr = addr.substring(0,pt).trim();
      }
      
      match = APT_PTN.matcher(addr);
      if (match.find()) {
        data.strApt = match.group(1);
        addr = addr.substring(0,match.start()).trim();
      }
      
      boolean endChel = addr.endsWith(" CHEL");
      if (endChel) addr = addr.substring(0,addr.length()-5).trim();
      parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, addr, data);
      if (endChel && data.strCity.length() == 0) data.strCity = "CHELTENHAM TWP";
      
      return true;
    }
    
    // Process regular alerts
    body = body.replace(": @", " Place:").replace(",MAP/BOX-PLAN:", " BOX:");
    body = COMMA_DELIM.matcher(body).replaceAll(" ");
    if (super.parseMsg(body, data)) {
      if (data.strAddress.length() == 0) {
        if (data.strCross.length() == 0) return false;
        parseAddress(data.strCross, data);
        data.strCross = "";
      }
      return true;
    }
    
    // If parse failed, but we have a good date/time marker
    // process this as a general alert
    if (!dateTimeMark) return false;
    data.strCall = "GENERAL ALERT";
    data.strPlace = body;
    data.strAddress = "";
    return true;
  }
  
  @Override
  public String getProgram() {
    return "TIME DATE ADDR " + super.getProgram();
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.lastIndexOf(',');
      if (pt >= 0) {
        String apt = field.substring(pt+1).trim();
        if (apt.startsWith("APT:")) apt = apt.substring(4).trim();
        data.strApt = apt;
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " APT";
    }
  }

  private class MyUnitAddressField extends MyAddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strUnit = p.get(' ');
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT " + super.getFieldNames();
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("/")) field = field.substring(1).trim();
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("UNITADDR")) return new MyUnitAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    int pt = addr.indexOf(": alias");
    if (pt >= 0) addr = addr.substring(0,pt).trim();
    return addr;
  }
}
