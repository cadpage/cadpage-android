package net.anei.cadpage.parsers.ZCAAB;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
/**
 * Lacombe County, AB, CA
 */
public class ZCAABRedDeerCountyParser extends FieldProgramParser {
  
  public ZCAABRedDeerCountyParser() {
    this("RED DEER COUNTY");
  }

  
  protected ZCAABRedDeerCountyParser(String defCity) {
    super(defCity, "AB",
           "Date:DATETIME! Type:CALL! Location:ADDR! Units:UNIT? Latitude:GPS? Longitude:GPS? Units_Responding:UNIT");
  }
  
  @Override
  public String getFilter() {
    return "reddeer911@reddeer.ca,messaging@iamresponding.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS | MAP_FLG_CR_CRES;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!parseFields(body.split("\n"), data)) return false;
    setGPSLoc(data.strGPSLoc, data);
    if (data.strAddress.startsWith("Unknown Location -") && data.strGPSLoc.length() > 0) {
      data.strAddress = data.strGPSLoc;
    }
    return true;
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    return RNG_PATTERN.matcher(sAddress).replaceAll("Range");
  }
  private static final Pattern RNG_PATTERN = Pattern.compile("\\bRng\\b", Pattern.CASE_INSENSITIVE);
  
  @Override
  public String postAdjustMapAddress(String sAddress) {
    return HWY_NN_PTN.matcher(sAddress).replaceAll("ALBERTA $1");  
  }
  private static final Pattern HWY_NN_PTN = Pattern.compile("\\bHWY +(\\d+)\\b", Pattern.CASE_INSENSITIVE);

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
      if (field.endsWith(")")) {
        int pt = field.indexOf('(');
        data.strPlace = field.substring(pt+1,field.length()-1).trim();
        field = field.substring(0,pt).trim();
      }
      Parser p = new Parser(field);
      data.strCity = p.getLastOptional(',');
      super.parse(p.get(',').replace('\\', '/'), data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY PLACE";
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
