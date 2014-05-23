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
           "Date:DATETIME! Type:CALL! Location:ADDR! Units:UNIT? Latitude:GPS1? Longitude:GPS2? Units_Responding:UNIT");
  }
  
  @Override
  public String getAliasCode() {
    return "ZCABRedDeerCounty";
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
    if (!subject.equals("CAD Message") && !subject.equals("Incident Message")) {
      data.strSource = subject;
    }
    body = body.replace("\nLatitudeUnits Responding:", "\nUnits Responding:");
    if (!parseFields(body.split("\n"), data)) return false;
    setGPSLoc(data.strGPSLoc, data);
    if (data.strAddress.startsWith("Unknown Location -") && data.strGPSLoc.length() > 0) {
      data.strAddress = data.strGPSLoc;
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
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
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }

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
      String apt = "";
      Parser p = new Parser(field);
      data.strCity = p.getLastOptional(',');
      if (data.strCity.startsWith("Unit ")) {
        data.strApt = data.strCity.substring(5).trim();
        data.strCity = p.getLastOptional(',');
      }
      field = p.get(',');
      if (field.startsWith("Unit ")) {
        data.strApt = field.substring(5).trim();
        field = p.get(',');
      }
      
      super.parse(field.replace('\\', '/'), data);
      data.strApt = append(data.strApt, "-", apt);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY PLACE";
    }
  }
}
