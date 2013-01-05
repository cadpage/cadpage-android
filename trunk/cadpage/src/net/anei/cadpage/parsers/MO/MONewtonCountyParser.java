package net.anei.cadpage.parsers.MO;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class MONewtonCountyParser extends FieldProgramParser {
 
  public MONewtonCountyParser() {
    super("NEWTON COUNTY", "MO",
          "ADDR/SXP! CrossStreets:X! ESN:MAP Call_Number:ID");
  }
  
  @Override
  public String getFilter() {
    return "911@NC-CDC.ORG";
  }
  
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equalsIgnoreCase("911 CALL")) return false;
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String addr = p.get(", Apt.");
      String apt = p.get(' ');
      if (apt.equalsIgnoreCase("LOT")) apt = apt + " " + p.get(' ');
      String place = p.get();
      if (apt.length() > 0) {
        parseAddress(addr, data);
        data.strApt = apt;
        data.strPlace = place;
      } else {
        super.parse(field, data);
        if (data.strAddress.equals(append(data.strApt, " ", data.strPlace))) {
          data.strApt = "";
          data.strPlace = "";
        }
      }
    }
  }
  
  private static final Pattern MILE_PTN = Pattern.compile(" mi [NSEW][NSEW]? ");
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      int pt = 0;
      Matcher match = MILE_PTN.matcher(field);
      while (match.find()) pt = match.end();
      if (pt >= 0) {
        data.strCall = field.substring(pt).trim();
        data.strCross = field.substring(0,pt).trim();
      } else {
        Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, field);
        if (res.getStatus() > 0) {
          res.getData(data);
          data.strCall = res.getLeft();
        } else {
          data.strCall = field;
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "X CALL";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
}