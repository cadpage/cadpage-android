package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Lancaster County, PA
 */
public class PALancasterCountyParser extends FieldProgramParser {
  
  public PALancasterCountyParser() {
    super(CITY_LIST, "LANCASTER COUNTY", "PA",
           "CITY ADDR X/Z+? UNIT TIME!");
  }
  
  @Override
  public String getFilter() {
    return "911@lcwc911.us,messaging@iamresponding.com,@everbridge.net,141000";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! body.contains("~")) return false;
    
    if (subject.indexOf(' ') >= 0 || subject.indexOf('-') >= 0 || subject.indexOf('/') >= 0) { 
      data.strCall = subject;
    } else {
      data.strSource = subject;
    }
    
    if (body.endsWith("^")) body = body.substring(0,body.length()-1).trim();
    body = body.replace(" BOROUGH", " BORO").replace(" TOWNSHIP", " TWP");
    return parseFields(body.split("~"), data);
  }
  
  @Override
  public String getProgram() {
    return "SRC CALL " + super.getProgram();
  }
  
  private static final Pattern CITY_DELIM = Pattern.compile("\n| / ");
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CITY_DELIM.matcher(field);
      if (match.find()) {
        data.strCall = append(data.strCall, " / ", field.substring(0,match.start()).trim());
        data.strCity = field.substring(match.end()).trim();
      } else {
        String call = data.strCall;
        data.strCall = "";
        parseAddress(StartType.START_CALL, FLAG_ONLY_CITY | FLAG_ANCHOR_END, field, data);
        data.strCall = append(call, " / ", data.strCall);
        if (data.strCall.length() == 0 || data.strCity.length() == 0) abort();
      }
      if (data.strCity.endsWith(" BORO")) data.strCity = data.strCity.substring(0, data.strCity.length()-5).trim();
      if (data.strCity.startsWith("LANC")) data.strCity = "LANCASTER";
    }
  }
  
  private static Pattern LANC_PTN = Pattern.compile("\\bLANC\\b", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = LANC_PTN.matcher(field).replaceAll("LANCASTER");
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d:\\d\\d", true);
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String address) {
    return ROUTE_30_PTN.matcher(address).replaceAll("US 30");
  }
  private static final Pattern ROUTE_30_PTN = Pattern.compile("\\b(?:RT|ROUTE) *30\\b");
  
  private static final String[] CITY_LIST = new String[]{

    // Cities
    "LANC",
    "LANC CITY",
    "LANCASTER",
    "LANCASTER CITY",
    
    // Boroughs
    "ADAMSTOWN BORO",
    "AKRON BORO",
    "CHRISTIANA BORO",
    "COLUMBIA BORO",
    "DENVER BORO",
    "EAST PETERSBURG BORO",
    "ELIZABETHTOWN BORO",
    "EPHRATA BORO",
    "LITITZ BORO",
    "MANHEIM BORO",
    "MARIETTA BORO",
    "MILLERSVILLE BORO",
    "MOUNT JOY BORO",
    "MOUNTVILLE BORO",
    "NEW HOLLAND BORO",
    "QUARRYVILLE BORO",
    "STRASBURG BORO",
    "TERRE HILL BORO",
    
    // Townships
    "BART TWP",
    "BRECKNOCK TWP",
    "CAERNARVON TWP",
    "CLAY TWP",
    "COLERAIN TWP",
    "CONESTOGA TWP",
    "CONOY TWP",
    "DRUMORE TWP",
    "EARL TWP",
    "EAST COCALICO TWP",
    "EAST DONEGAL TWP",
    "EAST DRUMORE TWP",
    "EAST EARL TWP",
    "EAST HEMPFIELD TWP",
    "EAST LAMPETER TWP",
    "EDEN TWP",
    "ELIZABETH TWP",
    "EPHRATA TWP",
    "FULTON TWP",
    "LANCASTER TWP",
    "LEACOCK TWP",
    "LITTLE BRITAIN TWP",
    "MANHEIM TWP",
    "MANOR TWP",
    "MARTIC TWP",
    "MOUNT JOY TWP",
    "PARADISE TWP",
    "PENN TWP",
    "PEQUEA TWP",
    "PROVIDENCE TWP",
    "RAPHO TWP",
    "SADSBURY TWP",
    "SALISBURY TWP",
    "STRASBURG TWP",
    "UPPER LEACOCK TWP",
    "WARWICK TWP",
    "WEST COCALICO TWP",
    "WEST DONEGAL TWP",
    "WEST EARL TWP",
    "WEST HEMPFIELD TWP",
    "WEST LAMPETER TWP",
    
    // Census-designated places
    "BAINBRIDGE",
    "BIRD-IN-HAND",
    "BLUE BALL",
    "BOWMANSVILLE",
    "BRICKERVILLE",
    "BROWNSTOWN",
    "CHURCHTOWN",
    "CLAY",
    "CONESTOGA",
    "EAST EARL",
    "FALMOUTH",
    "FARMERSVILLE",
    "FIVEPOINTVILLE",
    "GAP",
    "GEORGETOWN",
    "GOODVILLE",
    "GORDONVILLE",
    "HOPELAND",
    "INTERCOURSE",
    "KIRKWOOD",
    "LAMPETER",
    "LANDISVILLE",
    "LEOLA",
    "LITTLE BRITAIN",
    "MAYTOWN",
    "MORGANTOWN",
    "PARADISE",
    "PENRYN",
    "REAMSTOWN",
    "REFTON",
    "REINHOLDS",
    "RHEEMS",
    "RONKS",
    "ROTHSVILLE",
    "SALUNGA",
    "SCHOENECK",
    "SMOKETOWN",
    "SOUDERSBURG",
    "STEVENS",
    "SWARTZVILLE",
    "WAKEFIELD",
    "WASHINGTON BORO",
    "WILLOW STREET",
    "WITMER",
 
    // Other communities
    "BAUSMAN",
    "BROWNSTOWN",
    "BLAINSPORT",
    "BUCK",
    "COCALICO",
    "CONEWAGO",
    "CRESWELL",
    "DILLERVILLE",
    "ELM",
    "FERTILITY",
    "HEMPFIELD",
    "HINKLETOWN",
    "HOLTWOOD",
    "KINZERS",
    "KISSEL HILL",
    "LEAMAN PLACE",
    "LYNDON",
    "MARTINDALE",
    "MASTERSONVILLE",
    "MECHANICS GROVE",
    "NARVON",
    "NEW DANVILLE",
    "NEFFSVILLE",
    "NICKEL MINES",
    "PEQUEA",
    "SAFE HARBOR",
    "SILVER SPRING",
    "TALMAGE",
    "WHITE HORSE",
    
    // Other counties
    "CHESTER COUNTY",

  };
}
