package net.anei.cadpage.parsers.VA;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;


/**
 * Prince William County, VA
 */
public class VAPrinceWilliamCountyAParser extends VAPrinceWilliamCountyBaseParser {
  
  public VAPrinceWilliamCountyAParser() {
    super(CITY_CODES, "DATE TIME CODE ADDR X/Z+? BOX UNIT! INFO+");
  }

  @Override
  public String getFilter() {
    return "cc_message_notification@usamobility.net,@rsan.pwcgov.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    return parseFields(body.split("/"), 6, data);
  }
  
  private static final DateFormat DATE_FMT = new SimpleDateFormat("dd-MMM-yyyy");
  private class MyDateField extends DateField {
    @Override
    public void parse(String field, Data data) {
      setDate(DATE_FMT, field, data);
    }
  }
  
  private class MyTimeField extends TimeField {
    public MyTimeField() {
      setPattern("\\d\\d:\\d\\d:\\d\\d", true);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String sPlace = append(p.getOptional('@'), " - ", p.getLastOptional('('));
      if (sPlace.endsWith(")")) sPlace = sPlace.substring(0, sPlace.length()-1).trim();
      data.strPlace = sPlace;
      String city = convertCodes(p.getLastOptional(','), CITY_CODES);
      int pt = city.indexOf(',');
      if (pt >= 0) {
        data.strState = city.substring(pt+1);
        city = city.substring(0,pt);
      }
      data.strCity = city;
      parseAddress(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY PLACE";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(',');
      if (pt >= 0) {
        if (data.strCity.length() == 0) data.strCity = convertCodes(field.substring(pt+1).trim(), CITY_CODES);
        field = field.substring(0,pt).trim();
      }
      
      // very occasionally, the address will be a cross street and the
      // cross street will be an address
      if (data.strCross.length() == 0 && field.length() > 0 && Character.isDigit(field.charAt(0)) &&
          (data.strAddress.length() == 0 || !Character.isDigit(data.strAddress.charAt(0)))) {
        data.strCross = data.strAddress;
        data.strAddress = "";
        parseAddress(field, data);
      } else {
        super.parse(field, data);
      }
    }
  }
  
  private static final Pattern ID_PTN = Pattern.compile("\\[(\\d+)]?$");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ID_PTN.matcher(field);
      if (match.find()) {
        data.strCallId = match.group(1);
        field = field.substring(0,match.start()).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "INFO ID";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATE")) return new MyDateField();
    if (name.equals("TIME")) return new MyTimeField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("BOX")) return new BoxField("\\d\\d[A-Z]?|[A-Z]{2}", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CHAR", "CHARLES COUNTY,MD",
      "DULL", "DULLES",
      "DUMF", "DUMFRIES",
      "FAIR", "FAIRFAX",
      "FAUQ", "FAUQUIER",
      "FBEL", "FORT BELVOIR",
      "FXCT", "FAIRFAX",
      "HAYM", "HAYMARKET",
      "LOUD", "LOUDOUN",
      "MCB",  "MARINE CORPS BASE QUANTICO",
      "MNPK", "MANASSAS PARK",
      "MNSS", "MANASSAS",
      "OCCO", "OCCOQUAN",
      "PWC",  "",
      "QUAN", "QUANTICO",
      "STAF", "STAFFORD",
      "WAR",  "WARRENTON"
  });
}