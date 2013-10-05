package net.anei.cadpage.parsers.MO;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchCiscoParser;



public class MOStFrancoisCountyParser extends DispatchCiscoParser {
  
  private static final Pattern SPECIAL_MSG_PTN = Pattern.compile("Unit: *([A-Z0-9]+) *(.*?) -> (.*)");
  
  public MOStFrancoisCountyParser() {
    super("ST FRANCOIS COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "IPN.9999900138@ipnpaging.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SPECIAL_MSG_PTN.matcher(body);
    if (match.matches()) {
      data.strUnit = match.group(1);
      String type = match.group(2).trim();
      String msg =  match.group(3).trim();
      if (type.equals("Is Clearing from")) {
        data.strCall = "RUN REPORT";
        data.strPlace = type + " -> " + msg;
        return true;
      }
      if (type.equals("Notification")) {
        data.strCall = "GENERAL ALERT";
        data.strPlace = msg;
        return true;
      }
      data.strCall = "GENERAL ALERT";
      data.strPlace = type + " -> " + msg;
      return true;
    }
    
    if (!super.parseMsg(subject, body.replace('\n', ' ').replace("!",""), data)) return false;
    
    // Cross streets need implied ampersands :(
    if (data.strCross.length() > 0) {
      String cross = data.strCross;
      data.strCross = "";
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT | FLAG_ANCHOR_END, cross, data);
    }
    
    // Calculate zip code from grid
    if (data.strCity.length() == 0 && data.strMap.length() > 0) {
      String zipCode = GRID_ZIP_TABLE.getProperty(data.strMap);
      if (zipCode != null) data.strCity = zipCode;
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("MAP", "MAP CITY");
  }
  
  private static final Properties GRID_ZIP_TABLE = buildCodeTable(new String[]{
      "3601", "63640",
      "3602", "63640",
      "3603", "63640",
      "3604", "63640",
      "3605", "63640",
      "3606", "63640",
      "3607", "63640",
      "3704", "63640",
      "3705", "63640",
      "3708", "63640",
      "3710", "63640",
      "3711", "63640",
      "4101", "63640",
      "4102", "63640",
      "4201", "63640",
      "4204", "63640",
      "4205", "63640",
      "4206", "63640",
      "4207", "63640",
      "4267", "63640",
      "6741", "63640",
      "6742", "63640",
      "3101", "63624",
      "3102", "63624",
      "3104", "63624",
      "3105", "63624",
      "3106", "63624",
      "3108", "63624",
      "3109", "63624",
      "3111", "63624",
      "3103", "63650",
      "3107", "63650",
      "3110", "63650",
      "4104", "63650",
      "3301", "63601",
      "3302", "63601",
      "3304", "63601",
      "3305", "63601",
      "3306", "63601",
      "2300", "63601",
      "3701", "63601",
      "3702", "63601",
      "3703", "63601",
      "3706", "63601",
      "3707", "63601",
      "3709", "63601",
      "3712", "63601",
      "3713", "63601",
      "3714", "63601",
      "3715", "63601",
      "3802", "63601",
      "3803", "63601",
      "3901", "63601",
      "3902", "63601",
      "3903", "63601",
      "3904", "63601",
      "4103", "63601",
      "4102", "63601",
      "3303", "63628",
      "3201", "63628",
      "3202", "63628",
      "3204", "63628",
      "3307", "63628",
      "3401", "63628",
      "3402", "63628",
      "3403", "63628",
      "3404", "63628",
      "3406", "63628",
      "3407", "63628",
      "3408", "63628",
      "3409", "63628",
      "3411", "63628",
      "4300", "63628",
      "4501", "63628",
      "4502", "63628",
      "4503", "63628",
      "4504", "63628",
      "4505", "63628",
      "3410", "63087",
      "3801", "63653",
      "3405", "63036",
      "4400", "63036",
      "4402", "63036",
      "4203", "63670",
      "7101", "63670",
      "7106", "63670",
      "7204", "63670",
      "7301", "63670",
      "7401", "63670",
      "7402", "63670",
      "7405", "63670",
      "7406", "63670",
      "7452", "63670",
      "7453", "63670",
      "7455", "63670",
      "7603", "63670",
      "7701", "63670",
      "7702", "63670",
      "7703", "63670",
      "7705", "63670",
      "7706", "63670",
      "7707", "63670",
      "7708", "63670",
      "7201", "63627",
      "7202", "63627",
      "7203", "63627",
      "7255", "63627",
      "7256", "63627",
      "7501", "63627",
      "7555", "63627",
      "7601", "63673",
      "7655", "63673",
      "7656", "63673",
      "7801", "63673",
      "7802", "63673",
      "7803", "63673",
      "7806", "63673",
      "7807", "62233"
  });
}
