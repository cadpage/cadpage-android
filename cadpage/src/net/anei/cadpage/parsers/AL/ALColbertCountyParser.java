package net.anei.cadpage.parsers.AL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Colbert County, AL
Contact: "Michael Smith" <colbertema@gmail.com>
Sender: 911alert@comcast.net

MISSING PERSON\n 2564150099\n3804 HATCH BLVD, SHEFFIELD
SUICIDAL PERSON\n 6622123327\n105 FORREST DR, CHEROKEE\n43 YOF
BREATHING PROBLEM\nCHEROKEE FAMILY CLINIC 2563594516\n1080 2ND ST, CHEROKEE\n62 YOF
SEIZURE\n 2568566665\n8685 HIGHWAY 72, CHEROKEE\n21F
MISSING PERSON\nATKISSON, TAMARA 2564123685\n603 PASADENA AV, A, MUSCLE SHOALS  (also includes Apartment #)
MVC-Injury\n 2564125319\nWOODWARD AV && 6TH ST, MUSCLE SHOALS\n2 CARS

*/
public class ALColbertCountyParser extends FieldProgramParser {
  
  public ALColbertCountyParser() {
    super("COLBERT COUNTY", "AL",
           "CALL NAMEPH ADDR! INFO");
  }
  
  @Override
  public String getFilter() {
    return "911alert@comcast.net";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    return parseFields(body.split("\n"), data);
  }
  
  private static final Pattern PHONE_PTN = Pattern.compile("\\b\\d{10}$");
  private class NamePhoneField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = PHONE_PTN.matcher(field);
      if (match.find()) {
        data.strPhone = match.group();
        field = field.substring(0,match.start()).trim();
      }
      data.strName = field;
    }
    
    @Override
    public String getFieldNames() {
      return "NAME PHONE";
    }
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      field = field.replace("&&", "&");
      int pt = field.lastIndexOf(", ");
      if (pt < 0) abort();
      data.strCity = field.substring(pt+2).trim();
      field = field.substring(0,pt).trim();
      pt = field.lastIndexOf(", ");
      if (pt >= 0) {
        data.strApt = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      parseAddress(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("NAMEPH")) return new NamePhoneField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
