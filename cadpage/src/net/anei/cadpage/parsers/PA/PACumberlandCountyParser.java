package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchArchonixParser;



public class PACumberlandCountyParser extends DispatchArchonixParser {
  
  private static final Pattern CODE_CALL_PTN = Pattern.compile("(\\d{2}[A-Z]\\d{2}) +(.*)");
  
  public PACumberlandCountyParser() {
    super(CITY_CODES, MA_CITY_CODES, "CUMBERLAND COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "ccpaeoc@comcast.net,EP911@ccpa.net";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.startsWith("[DISPATCH]")) subject = subject.substring(10).trim();
    if (!super.parseMsg(subject,  body, data)) return false;
    
    // Call can contain a code field
    Matcher match = CODE_CALL_PTN.matcher(data.strCall);
    if (match.matches()) {
      data.strCode = match.group(1);
      data.strCall = match.group(2);
    }
    
    // The Map (Zone) field contains the CAD zone (which users are not interested in
    // and  a box number
    Parser p = new Parser(data.strMap);
    p.get(' ');
    data.strBox = p.get();
    data.strMap = "";
    
    // Clean up city field
    data.strCity = stripFieldEnd(data.strCity, " BORO");
    data.strCity = stripFieldStart(data.strCity, "BORO OF ");
    data.strCity = stripFieldStart(data.strCity, "BORO ");
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CALL", "CODE CALL").replace("MAP", "BOX");
  }
  
  @Override
  public String adjustMapAddress(String address) {
    address = GD_PTN.matcher(address).replaceAll("GARDEN");
    address = ES_PTN.matcher(address).replaceAll("ESTATES");
    address = HGWY_PTN.matcher(address).replaceAll("HWY");
    address = BY_PTN.matcher(address).replaceAll("BYPASS");
    return address;
  }
  private static final Pattern GD_PTN = Pattern.compile("\\bGD\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern ES_PTN = Pattern.compile("\\bES\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern HGWY_PTN = Pattern.compile("\\bHGWY\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern BY_PTN = Pattern.compile("\\bBY\\b", Pattern.CASE_INSENSITIVE);

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CA CU", "CARLISLE",
      "CB CU", "CARLISLE BARRACKS",
      "CH CU", "CAMP HILL",
      "CK CU", "COOKE TWP",
      "DK CU", "DICKINSON TWP",
      "EP CU", "EAST PENNSBORO TWP",
      "HM CU", "HAMPDEN TWP",
      "HW CU", "HOPEWELL TWP",
      "LA CU", "LOWER ALLEN TWP",
      "LB CU", "LEMOYNE",
      "LF CU", "LOWER FRANKFORD TWP",
      "LM CU", "LOWER MIFFLIN TWP",
      "MB CU", "MECHANICSBURG",
      "MH CU", "MT HOLLY SPRINGS",
      "MN CU", "MONROE TWP",
      "MX CU", "MIDDLESEX TWP",
      "NB CU", "NEWBURG",
      "NC CU", "NEW CUMBERLAND",
      "NM CU", "NORTH MIDDLETON TWP",
      "NN CU", "NORTH NEWTON TWP",
      "NV CU", "NAVAL SUPPORT ACTIVITY",
      "NW CU", "NEWVILLE",
      "PN CU", "PENN TWP",
      "SB CU", "SHIPPENSBURG",
      "SF CU", "SHIPPENSBURG", // in Franklin County
      "SH CU", "SOUTHAMPTON TWP",
      "SM CU", "SOUTH MIDDLETON TWP",
      "SN CU", "SOUTH NEWTON TWP",
      "SS CU", "SILVER SPRING TWP",
      "ST CU", "SHIPPENSBURG TWP",
      "SR CU", "SHIREMANSTOWN",
      "UA CU", "UPPER ALLEN TWP",
      "UF CU", "UPPER FRANKFORD TWP",
      "UM CU", "UPPER MIFFLIN TWP",
      "WB CU", "WORMLEYSBURG",
      "WP CU", "WEST PENNSBORO TWP",
      
      "AR FC", "AYR TWP", 
      "BC FC", "BRUSH CREEK TWP",
      "BL FC", "BELFAST TWP",
      "BT FC", "BETHEL TWP",
      "DB FC", "DUBLIN TWP",
      "LC FC", "LICKING CREEK TWP",
      "MC FC", "MCCONNELLSBURG",
      "TD FC", "TODD TWP",
      "TH FC", "THOMPSON TWP",
      "TY FC", "TAYLOR TWP",
      "UN FC", "UNION TWP",
      "VH FC", "VALLEY-HI",
      "WL FC", "WELLS TWP",
      
      "DC DC", "DAUPHIN COUNTY",
      "FCR",   "FRANKLIN COUNTY",
      "FC FR", "FRANKLIN COUNTY",
      "PC PC", "PERRY COUNTY"
  });

  private static final Properties MA_CITY_CODES = buildCodeTable(new String[]{
      "S HAMP", "SOUTHAMPTON TWP",
      "SH TWP", "SOUTHAMPTON TWP",
      "SHAMP",  "SOUTHAMPTON TWP",
      "SHP",    "SHIPPENSBURG",
      "SUSQ TWP","SUSQUEHANNA TWP"

  });

}
