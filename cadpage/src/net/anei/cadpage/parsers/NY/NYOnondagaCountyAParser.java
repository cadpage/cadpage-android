package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/**
 * Onondaga County, NY
 */
public class NYOnondagaCountyAParser extends FieldProgramParser {

  private static final Pattern MARKER = Pattern.compile("^(?:(?:(?:I/)?CAD MSG )?([A-Z]+) +)?(\\d\\d:\\d\\d:\\d\\d) +");
  
  private static final Pattern CITY_EXP_PTN = Pattern.compile("\\b(TMA),[A-Z]\\b");

  public NYOnondagaCountyAParser() {
    super(CITY_CODES, "ONONDAGA COUNTY", "NY",
           "ADDR/SXP! XTS:X! P:PRI Lev:SKIP X:INFO Disp:UNIT%");
  }
  
  @Override
  public String getFilter() {
    return "e9web1@ongov.net,messaging@emergencysmc.com,@notifyatonce.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Some services split message into subject and message
    if (subject.startsWith("CAD MSG")) {
      body = subject + " " + body;
    }
    
    // Make sure pages starts with initial marker
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strSource = getOptGroup(match.group(1));
    data.strTime = match.group(2);
    body = body.substring(match.end());
    
    // Drop line breaks and duplicate blanks
    body = body.replace('\n', ' ').replaceAll("  +", " ");
    body = CITY_EXP_PTN.matcher(body).replaceAll("$1");
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC TIME " + super.getProgram();
  }
  
  private static final Pattern ADDR_ZIP_PTN = Pattern.compile(" +(13\\d{3})$");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String sPlace = "";
      int pt = field.indexOf(':');
      if (pt >= 0) {
        sPlace = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
        if (sPlace.startsWith("@")) sPlace = sPlace.substring(1).trim();
      }
      if (field.startsWith("/")) {
        data.strAddress = field;
      } else {
        super.parse(field, data);
      }
      data.strPlace = append(data.strPlace, " / ", sPlace);
      Matcher match = ADDR_ZIP_PTN.matcher(data.strAddress);
      if (match.find()) {
        if (data.strCity.length() == 0) data.strCity = match.group(1);
        data.strAddress = data.strAddress.substring(0,match.start());
      }
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String cross = p.get(',');
      if (data.strAddress.startsWith("/")) {
        if (data.strCity.length() == 0) {
          data.strCity = convertCodes(data.strAddress.substring(1).trim(), CITY_CODES);
        }
        data.strAddress = "";
        parseAddress(cross, data);
      } else {
        super.parse(cross, data);
      }
      String place = p.get(',');
      if (place.startsWith("APT ")) {
        data.strApt = place.substring(4).trim();
      } else {
        if (place.startsWith("IFO")) place = place.substring(3).trim();
        data.strPlace = append(data.strPlace , " / ", place);
      }
      String call = p.get();
      if (call.length() == 0) abort();
      if (call.endsWith("-")) call = call.substring(0,call.length()-1).trim();
      data.strCall = call;
    }
    
    @Override
    public String getFieldNames() {
      return "X CALL";
    }
  }

  // Remove redundant date/time from info field
  private static final Pattern DATE_TIME_PTN = Pattern.compile("\\b\\d\\d/\\d\\d \\d\\d:\\d\\d:\\d\\d:\\b");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (match.find()) {
        field = append(field.substring(0,match.start()).trim(), " ", field.substring(match.end()));
      }
      super.parse(field, data);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String address) {
    address = ROUTE_11_PTN.matcher(address).replaceAll("NEW YORK STATE BICYCLE ROUTE 11");
    address = ROUTE_20_PTN.matcher(address).replaceAll("US 20");
    return address;
  }
  private static final Pattern ROUTE_11_PTN = Pattern.compile("\\b(?:RT|ROUTE) *11\\b");
  private static final Pattern ROUTE_20_PTN = Pattern.compile("\\b(?:RT|ROUTE) *20\\b");
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "NAT",   "NAT",     // ????
      "OTOW",  "OWASCO",
      "TCI",   "CICERO",
      "TCL",   "CLAY",
      "TFB",   "FABIUS",
      "TLF",   "LAFAYETTE",
      "TMA",   "MANLIUS",
      "TMR",   "MARCELLUS",
      "TON",   "ONONDAGA",
      "TOT",   "OTISCO",
      "TPO",   "POMPEY",
      "TSL",   "SALINA",
      "TSK",   "SKANEATELES",
      "TTU",   "TULLY",
      "VFY",   "FAYETTEVILLE",
      "VTU",   "TULLY",
      "VMA",   "MARCELLUS",
      "VNS",   "NORTH SYRACUSE",
      "VSK",   "SKANEATELES",
      
      "OVCH MAD", "MADISON COUNTY"
  });
  
}
	