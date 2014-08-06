package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class PADelawareCountyBParser extends FieldProgramParser {
  
  private static final Pattern CAP_PTN = Pattern.compile("^(\\d{7}) ");
  private static final Pattern NATURE_PTN = Pattern.compile("[\\* \"](?:N.tu.e:|.ature:|Natu....(?=[A-Z]))");
  private static final Pattern XN_PTN = Pattern.compile("[ ><](?!X1 INSIDE)X([12])..");
  
  private AddressField addressField;
  
  private boolean crossAddress;
  
  public PADelawareCountyBParser() {
    super(CITY_CODES, "DELAWARE COUNTY", "PA",
           "ADDR/S X1:XADDR? X2:X? Nature:CALL! Time:TIME Notes:INFO? Inc:ID");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = CAP_PTN.matcher(body);
    if (match.find()) {
      data.strUnit = match.group(1);
      body = body.substring(match.end()).trim();
    }

    // For some reason the Nature: keyword is prone to being garbled
    body = NATURE_PTN.matcher(body).replaceFirst(" Nature: ");
    
    // Then again, garbledness seems to occur anywhere, we just find it 
    // in the Nature field because that causes the parser to fail.  But lets
    // fix up the Xn: fields if we can
    body = XN_PTN.matcher(body).replaceAll(" X$1: ");
    crossAddress = false;
    return super.parseMsg(body.replace('\n', ' '), data);
  }
  
  @Override
  public String getProgram() {
    return "UNIT " + super.getProgram();
  }
  
  private static final Pattern ADDR_DASH_CITY_PTN = Pattern.compile("(.*)[-<]([A-Z]{2})");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      field = stripFieldEnd(field, "<");
      Parser p = new Parser(field);
      while (true) {
        String place = p.getLastOptional(':');
        if (place.length() == 0) break;
        place = stripFieldStart(place, "@");
        if (!place.endsWith(" CO") && !place.endsWith(" CO.") && !place.endsWith(" MD")) {
          String city = CITY_CODES.getProperty(place);
          Result res = parseAddress(StartType.START_OTHER, FLAG_ONLY_CITY | FLAG_ANCHOR_END, place);
          city = res.getCity();
          if (city.length() > 0) {
            res.getData(data);
            place = res.getStart();
          }
        }
        if (!data.strPlace.contains(place)) data.strPlace = append(place, " - ", data.strPlace);
      }
      String apt = p.getLastOptional(',');
      field = p.get();
      if (field.startsWith("@")) {
        String place = field.substring(1).trim();
        if (!data.strPlace.contains(place)) data.strPlace = append(place, " - ", data.strPlace);
      } else {
        Matcher match = ADDR_DASH_CITY_PTN.matcher(field);
        if (match.matches()) {
          field = match.group(1) + " " + match.group(2);
        }
        super.parse(field, data);
      }
      data.strAddress = stripFieldEnd(data.strAddress, "--");
      data.strApt = append(data.strApt, "-", apt);
      if (data.strCity.equals("NEW CASTLE COUNTY")) data.strState = "DE";
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY ST APT PLACE";
    }
  }
  
  private class CrossAddressField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (data.strAddress.length() == 0) {
        crossAddress = true;
        addressField.parse(field, data);
      } else {
        super.parse(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return addressField.getFieldNames() + " X";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (crossAddress) {
        data.strAddress = append(data.strAddress, " & ", field);
      } else {
        super.parse(field, data);
      }
    }
  }
  
  private class MyIdField extends IdField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(" Beat ");
      if (pt >= 0) {
        data.strBox = field.substring(pt+6).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "ID BOX";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (addressField == null) addressField = new MyAddressField();
    if (name.equals("ADDR")) return addressField;
    if (name.equals("XADDR")) return new CrossAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("ID")) return new MyIdField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AL", "ALDAN",
      "AS", "ASTON TWP",
      "BE", "BETHEL TWP",
      "BM", "BIRMINGHAM TWP",
      "BR", "BROOKHAVEN",
      "CC", "CHESTER",
      "CF", "CHADDS FORD TWP",
      "CH", "CHESTER HEIGHTS",
      "CL", "CLIFTON HEIGHTS",
      "CN", "CONCORD TWP",
      "CO", "COLLINGDALE",
      "CW", "COLWYN",
      "DB", "DARBY",
      "DT", "DARBY TWP",
      "ED", "EDDYSTONE",
      "EG", "EDGEMONT TWP",
      "EL", "EAST LANSDOWNE",
      "ES TN", "ESSINGTON", // SECTION OF TINICUM TWP
      "FL", "FOLCROFT",
      "GL", "GLENOLDEN",
      "HV", "HAVERFORD TWP",
      "LA", "LANSDOWNE",
      "LC", "LOWER CHICHESTER TWP",
      "LM", "LOWER MERION TWP",  // In montgomery conty
      "LS TN", "LESTER", // SECTION OF TINICUM TWP
      "MB", "MILLBOURNE",
      "MD", "MIDDLETOWN TWP",
      "ME", "MEDIA",
      "MH", "MARCUS HOOK",
      "MO", "MORTON",
      "MP", "MARPLE TWP",
      "NP", "NETHER PROVIDENCE TWP",
      "NT", "NEWTOWN TWP",
      "NW", "NORWOOD",
      "PK", "PARKSIDE",
      "PP", "PROSPECT PARK",
      "RN", "RADNOR TWP",
      "RP", "RIDLEY PARK",
      "RT", "RIDLEY TWP",
      "RU", "RUTLEDGE",
      "RV", "ROSE VALLEY",
      "SH", "SHARON HILL",
      "SP", "SPRINGFIELD TWP",
      "SW", "SWARTHMORE",
      "TB", "THORNBURY TWP",
      "TC", "CHESTER TWP",
      "TD", "TREDYFFRIN TWP",
      "TN", "TINICUM TWP",
      "TR", "TRAINER",
      "UC", "UPPER CHICHESTER TWP",
      "UD", "UPPER DARBY TWP",
      "UL", "UPLAND",
      "UP", "UPPER PROVIDENCE TWP",
      "WT", "WILLISTOWN TWP",
      "YE", "YEADON",
      
      "MONTCO",       "MONTGOMERY COUNTY",
      "UMT MONTCO",   "UPPER MERION TWP",
      
      "NCC",          "NEW CASTLE COUNTY",
      "NC",           "NEW CASTLE COUNTY",
      "NEW CASTLE",   "NEW CASTLE COUNTY",
      
      "LOWER MERION",      "LOWER MERION TWP",
      "LOWER MERION TWP",  "LOWER MERION TWP",
      "UPPER MERION",      "UPPER MERION TWP",
      "UPPER MERION TWP",  "UPPER MERION TWP"
    
  });
}
