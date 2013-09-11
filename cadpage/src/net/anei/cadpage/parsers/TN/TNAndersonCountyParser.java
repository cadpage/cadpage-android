package net.anei.cadpage.parsers.TN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class TNAndersonCountyParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile(" - ?|- ");
  
  public TNAndersonCountyParser() {
    super(CITY_LIST, "ANDERSON COUNTY", "TN",
           "( SRC ADDR_X_CALL ID! | CALL+? ADDR/S! +Street:X? INFO ID )");
  }
  
  @Override
  public String getFilter() {
    return "page@tnacso.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    if (body.startsWith("E911 / ")) body = body.substring(6).trim();
    
    // If page contains times keywords, report as general alert
    if (body.contains(" INSRV:") || body.contains(" INSV:")) return data.parseRunReport(this, body);;
    
    body = body.replace("+street:", "+Street:");
    return parseFields(DELIM.split(body), data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram() + " PLACE";
  }

  private static final Pattern SPECIAL_X_PTN = Pattern.compile("^(MM\\d+) +");
  private class MyAddressCrossCallField extends Field {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      int pt = field.indexOf(", TN ");
      if (pt < 0) return false;
      parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, field.substring(0,pt).trim(), data);
      field = field.substring(pt+5).trim();
      if (field.startsWith("+St:")) {
        field = field.substring(4).trim();
        Matcher match = SPECIAL_X_PTN.matcher(field);
        if (match.find()) {
          data.strCross = match.group(1);
          field  = field.substring(match.end());
        } else {
          parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, field, data);
          field = getLeft();
        }
      }
      if (field.length() == 0) abort();
      data.strCall = field;
      return true;
    }

    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }

    @Override
    public String getFieldNames() {
      return "ADDR APT CITY X CALL";
    }
    
  }
  
  // Call field appends to previous call field with - separator
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }

  // Address field is identified by trailing , TN
  // And needs to replace @ with &
  private class MyAddressField extends AddressField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.endsWith(" TN")) return false;
      field = field.substring(0, field.length()-3).trim();
      if (field.endsWith(",")) field = field.substring(0, field.length()-1).trim();
      String city = null;
      int pt = field.lastIndexOf(',');
      if (pt >= 0) {
        city = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      field = field.replace('@', '&');
      super.parse(field, data);
      if (city != null) data.strCity = city;
      return true;
    }
  }
  
  // The info field has to do all kinds of strange things
  private class MyInfoField extends InfoField {
    
    @Override
    public void parse(String field, Data data) {
      
      // This is really the call description
      // and what we thought was the call description is really the department
      if (field.length() != 0) {
        data.strSource = data.strCall;
        data.strCall = field;
      }
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR_X_CALL")) return new MyAddressCrossCallField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ANDERSONVILLE",
    "BRICEVILLE",
    "CLAXTON",
    "CLINTON",
    "DEVONIA",
    "FORK MOUNTAIN",
    "FRATERVILLE",
    "HEISKELL",
    "LAKE CITY",
    "MARLOW",
    "NORRIS",
    "OAK RIDGE",
    "OLIVER SPRINGS",
    "POWELL",
    "ROSEDALE",
    
    "CLAIRFIELD"  // ???
  };
}
