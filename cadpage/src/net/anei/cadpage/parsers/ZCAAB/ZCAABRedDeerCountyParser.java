package net.anei.cadpage.parsers.ZCAAB;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
/**
 * Lacombe County, AB, CA
 */
public class ZCAABRedDeerCountyParser extends FieldProgramParser {
  
  private static final Pattern CLEAN_CITY_PTN = Pattern.compile("(.*?) +RURAL(?: AREA)?", Pattern.CASE_INSENSITIVE);
  
  private String version;
  
  public ZCAABRedDeerCountyParser() {
    this("RED DEER COUNTY");
  }
  
  protected ZCAABRedDeerCountyParser(String defCity) {
    super(defCity, "AB",
           "( SELECT/2 CALL CALL2? LOCATION ADDR VILLAGE_OF? CITY/Z? ( APT UNITS_RESPONDING! | UNITS_RESPONDING! ) UNIT+ | " +
             "Date:DATETIME! Type:CALL! Location:ADDRCITY! Units:UNIT? Latitude:GPS1? Longitude:GPS2? Units_Responding:UNIT )");
  }
  
  @Override
  public String getAliasCode() {
    return "ZCABRedDeerCounty";
  }

  @Override
  public String getFilter() {
    return "@reddeer.ca,messaging@iamresponding.com";
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
    
    body = body.replace("LatitudeUnits Responding", "Units Responding");
    body = body.replace('\\', '/');
    if (body.startsWith("/ ")) {
      version = "2";
      body = body.replace("\n", " / ");
      if (!parseFields(body.substring(2).trim().split(" / "), data)) return false;
    } else {  
      version = "1";
      if (!parseFields(body.split("\n"), data)) return false;
      setGPSLoc(data.strGPSLoc, data);
      if (data.strAddress.startsWith("Unknown Location -") && data.strGPSLoc.length() > 0) {
        data.strAddress = data.strGPSLoc;
      }
    }
    Matcher match = CLEAN_CITY_PTN.matcher(data.strCity);
    if (match.matches()) data.strCity = match.group(1);
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    sAddress = RNG_PATTERN.matcher(sAddress).replaceAll("Range");
    sAddress = RANGE_RD_DASH_PTN.matcher(sAddress).replaceAll("$1$2");
    return sAddress;
  }
  private static final Pattern RNG_PATTERN = Pattern.compile("\\bRng\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern RANGE_RD_DASH_PTN = Pattern.compile("\\b(RANGE +RD +\\d+)-(\\d+)\\b", Pattern.CASE_INSENSITIVE);

  @Override
  public String postAdjustMapAddress(String sAddress) {
    return HWY_NN_PTN.matcher(sAddress).replaceAll("ALBERTA $1");  
  }
  private static final Pattern HWY_NN_PTN = Pattern.compile("\\bHWY +(\\d+)\\b", Pattern.CASE_INSENSITIVE);

  
  @Override
  protected String getSelectValue() {
    return version;
  }

  @Override
  public Field getField(String name) {
    if (name.equals("CALL2")) return new CallField("Gas Odor.*");
    if (name.equals("LOCATION")) return new SkipField("Location", true);
    if (name.equals("VILLAGE_OF")) return new SkipField("VILLAGE OF");
    if (name.equals("APT")) return new AptField("Unit +(.*)");
    if (name.equals("UNITS_RESPONDING")) return new SkipField("Units Responding", true);
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }

  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      setDateTime(DATE_TIME_FMT, field, data);
    }
  }
  
  private class MyAddressCityField extends AddressCityField {
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
      
      parseAddress(field.replace('\\', '/'), data);
      data.strApt = append(data.strApt, "-", apt);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, " ", field);
    }
  }
}
