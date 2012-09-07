package net.anei.cadpage.parsers.ZCAAB;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Lacombe County, AB, CA
Contact: support@active911.com
Sender: RedDeer911 <reddeer911@reddeer.ca>
https://www.active911.com/interface/parser_report.php?key=636-3GXrP

(Incident Message) Date: 2012-06-02 13:02:11\nType: GRASS - 2.3 Grass/ Brush/ Forest\nLocation: Unknown Location - Call Dispatch\nLatitude: 52.38667500\nLongitude: -113.81778000
(Incident Message) Date: 2012-06-02 13:02:11\nType: GRASS - 2.3 Grass/ Brush/ Forest\nLocation: 1 BLACKFALDS, TOWN OF, BLACKFALDS\nUnits Responding: BLKP4, BLKP2, BLKT1, BLKC
(Incident Message) Date: 2012-06-04 01:21:42\nType: ALARMS - 2.6 Alarms\nLocation: 7 GREYSTONE DR, BLACKFALDS RURAL\nUnits Responding: BLKP1, BLKP2, BLKR3, BLKC, BLKT1
(Incident Message) Date: 2012-06-06 12:23:42\nType: ALARMS - 2.6 Alarms\nLocation: 6 WINSTON PL, BLACKFALDS\nLatitude: 52.38963050\nLongitude: -113.79837571\nUnits Responding: BLKP1, BLKP2, BLKR3, BLKC, BLKT1

Lamont County, AB
Contact: Colin Candy <colincandy51@gmail.com>
Sender: scesitgroup@strathcona.ca
Sender: messaging@iamresponding.com
(CAD Message) Date: 2012-07-29 10:48:02\nType: 29D2k - Traffic Incidents\nLocation: TWP RD 550 /Rng rd 171, Lamont County\nUnits Respo
(Mundare Station) Date: 2012-08-14 06:55:06\nType: 29 - Traffic Incidents\nLocation: 171016 Hwy 16, Lamont County\nUnits Respondi
(CAD Message) Date: 2012-08-14 06:55:06\nType: 29 - Traffic Incidents\nLocation: 171016 Hwy 16, Lamont County\nUnits Responding: LCC1,
(CAD Message) Date: 2012-08-23 17:36:56\nType: 71 - Vehicle Fire\nLocation: 9999 NE 25 53 17 W4, Mundare Rural Area\nUnits Responding:
(CAD Message) Date: 2012-09-04 14:25:32\nType: 9E1 - Cardiac Arrest\nLocation: Unknown Location - Call Dispatch\nUnits Responding: LCC

*/
public class ZCAABRedDeerCountyParser extends FieldProgramParser {
  
  public ZCAABRedDeerCountyParser() {
    this("RED DEER COUNTY");
  }

  
  protected ZCAABRedDeerCountyParser(String defCity) {
    super(defCity, "AB",
           "Date:DATETIME! Type:CALL! Location:ADDR! Latitude:GPS? Longitude:GPS? Units_Responding:UNIT");
  }
  
  @Override
  public String getFilter() {
    return "reddeer911@reddeer.ca,messaging@iamresponding.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!parseFields(body.split("\n"), data)) return false;
    if (data.strAddress.startsWith("Unknown Location -") && data.strGPSLoc.length() > 0) {
      data.strAddress = data.strGPSLoc;
    }
    return true;
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    sAddress = RNG_PATTERN.matcher(sAddress).replaceAll("Range");
    sAddress = HWY_PATTERN.matcher(sAddress).replaceAll("RT");
    return sAddress;
  }
  private static final Pattern RNG_PATTERN = Pattern.compile("\\bRng\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern HWY_PATTERN = Pattern.compile("\\bHwy\\b", Pattern.CASE_INSENSITIVE);
  
  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      setDateTime(DATE_TIME_FMT, field, data);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strCity = p.getLastOptional(',');
      super.parse(p.get(','), data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
  
  private class MyGPSField extends GPSField {
    @Override
    public void parse(String field, Data data) {
      data.strGPSLoc = append(data.strGPSLoc, ",", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("GPS")) return new MyGPSField();
    return super.getField(name);
  }
  
  
}
