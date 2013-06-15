package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;




public class NYGeneseeCountyParser extends FieldProgramParser {
  
  private static final Pattern UNIT_PREFIX_PTN = Pattern.compile("^(?:Unit: *([A-Z0-9]+) +)?Status: *(?:Dispatched|At Scene) *(?:\\*\\* +)?");
  
  private boolean skipApt;
  
  public NYGeneseeCountyParser() {
    super(CITY_LIST, "GENESEE COUNTY", "NY",
           "CALL PLACE ADDR APT? CALL2! X DATETIME ID INFO+");
  }
  
  @Override
  public String getFilter() {
    return "911center@co.genesee.ny.us,777,888";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    do {
      
      if (body.startsWith("GENESEE COUNTY DISPATCH ")) {
        body = body.substring(24).trim();
        break;
      }
      
      if (subject.equals("Dispatch")) break;
        
      return false;
    } while (false);
    
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    Matcher match = UNIT_PREFIX_PTN.matcher(body);
    if (match.find()) {
      data.strUnit = match.group(1);
      body = body.substring(match.end());
    } else if (body.startsWith("** ")) {
      body = body.substring(3).trim();
    }
    
    String saveBody = body;
    return parseFields(body.split("\\*\\*"), 4, data) ||
            data.parseGeneralAlert(this, saveBody);
  }
  
  @Override
  public String getProgram() {
    return "UNIT " + super.getProgram();
  }

  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      
      // remove leading asterisk
      if (field.startsWith("*")) field = field.substring(1).trim();
      
      // If field contains comma, parse as address and cross / city
      String sApt = "";
      skipApt = false;
      int pt = field.indexOf(',');
      if (pt < 0) abort();
      String sAddr = field.substring(0,pt).trim();
      String sCity = field.substring(pt+1).trim();
      int pt2 = sCity.indexOf('-');
      if (pt2 >= 0) {
        skipApt = true;
        sApt = sCity.substring(pt2+1).trim();
        if (sApt.startsWith("APT ")) sApt = sApt.substring(4);
        sCity = sCity.substring(0,pt2).trim();
      }
      parseAddress(sAddr, data);
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_ONLY_CITY | FLAG_ANCHOR_END, sCity, data);
      if (data.strCity.equals("TONAWANDA IR")) data.strCity = "TONAWANDA INDIAN RESERVATION";
      data.strAddress = append(data.strAddress, " & ", data.strCross);
      data.strCross = "";
      data.strApt = append(data.strApt, "-", sApt);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY APT";
    }
  }
  
  private class MyAptField extends AptField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      // Older formats included apt in address field
      // if this is one of those, skip this field
      if (skipApt) return false;
      parse(field, data);
      return true;
    }
  }
  
  private class MyCall2Field extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("No Cross Streets Found")) return;
      super.parse(field, data);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("CALL")) return new CallField("[^:]*", true);
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("CALL2")) return new MyCall2Field();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ALABAMA",
    "ALEXANDER",
    "ATTICA",
    "BATAVIA",
    "BERGEN",
    "BERGEN",
    "BETHANY",
    "BYRON",
    "CORFU",
    "DARIEN",
    "ELBA",
    "LE ROY",
    "OAKFIELD",
    "PAVILION",
    "PEMBROKE",
    "STAFFORD",
    
    "TONAWANDA IR",

    // Erie County
    "ALDEN",
    "AKRON",
    
    // Wyoming County
    "ATTICA",
    "BENNINGTON",
    "WARSAW",
    
    // Erie County,
    "CLARENCE",
    "NEWSTEAD",
    
    // Orleans County
    "BARRE",
    "CLARENDON",
    "SHELBY",
    
    // Livingston County
    "CALEDONIA",
    "YORK",
    
    // Monroe County
    "RIGA"
  };
}
