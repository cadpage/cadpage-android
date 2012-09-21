package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Duchess County, NY
Contact: "corey1193@gmail.com" <corey1193@gmail.com>

PV-1: Type:EMS P2 |Address: 923 SALT POINT TRNPK, PLEASANT VALLEY, New York |Nature: 17 YOM FEELING DIZZY |Cross:BLOSSOM HILL - WEST 
PV-1: Type:EMS P4 |Address: 1434 ROUTE 44 , PLEASANT VALLEY, New York  |Nature: 57YOM FELL ,SHOULDER PAIN FATHER FELL |Cross:WILBUR RD
PV-1: Type:Alarm Fire |Address: 1903 ROUTE 44 , PLEASANT VALLEY, New York |Nature: AFA -2ND FLOOR PULL-WEST SIDE |Cross:BREWSTER LN -
PV-1: Type:EMS P3 |Address: 11 WALNUT DR , PLEASANT VALLEY, New York  |Nature: 59 YOM ABDOMINAL-POST SURGICAL COMPLICATIONS |Cross:WAT 
PV-1: Type:EMS P1 |Address: 7 BRISTOL DR , PLEASANT VALLEY, New York |Nature: 70 YOF CHEST AND BACK PAIN |Cross:FREEDOM RD - FOREST V

*/


public class NYDuchessCountyParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("^([-A-Z0-9]+): ");

  public NYDuchessCountyParser() {
      super("DUCHESS COUNTY", "NY",
           "Type:CALL! Address:ADDR! Nature:CALL! Cross:X");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strSource = match.group(1);
    body = body.substring(match.end()).trim();
    return parseFields(body.split("\\|"), 3, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String state = p.getLastOptional(',');
      if (state.equals("NY") || state.equalsIgnoreCase("New York")) state = "";
      String city = p.getLastOptional(',');
      super.parse(p.get(), data);
      data.strCity = city;
      data.strState = state;
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY ST";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(" - ", " / ");
      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
}
