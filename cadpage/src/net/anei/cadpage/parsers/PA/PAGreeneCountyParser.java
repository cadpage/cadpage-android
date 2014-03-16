package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class PAGreeneCountyParser extends SmartAddressParser {

  public PAGreeneCountyParser() {
    super("GREENE COUNTY", "PA");
    setFieldList("CALL ADDR CITY APT INFO X MAP DATE TIME ID UNIT");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(MW_STREET_LIST);
  }

  private static Pattern MASTER = Pattern.compile("(.*?) ,(\\d+) #:(.*?)X:/?(.*?)/?GD:(.*?)ZN:(.*?):(\\d{2}/\\d{2}/\\d{4}) (\\d{1,2}:\\d{2}:\\d{2})MI#:(\\d{9})(.*)");

  protected boolean parseMsg(String subject, String body, Data data) {
    //cut off all from the first \n on
    int ni = body.indexOf("\n");
    if (ni >= 0) body = body.substring(0, ni);
    
    Matcher mat = MASTER.matcher(body);
    if (!mat.matches()) return false;

    parseAddress(StartType.START_CALL,  FLAG_ANCHOR_END | FLAG_START_FLD_NO_DELIM, mat.group(1).trim(), data);
    data.strCity = getOptGroup(CITY_LIST.getProperty(mat.group(2)));
    data.strApt = mat.group(3).trim();
    parseAddress(StartType.START_ADDR,  FLAG_ANCHOR_END | FLAG_ONLY_CROSS, mat.group(4), data);
    data.strMap = append(mat.group(5).trim(), " ", mat.group(6).trim());
    data.strDate = mat.group(7);
    data.strTime = mat.group(8);
    data.strCallId = mat.group(9);
    data.strUnit = getOptGroup(mat.group(10));
    return true;
  }
  
  private static final Properties CITY_LIST = buildCodeTable(new String[]{
      "26", "WAYNESBURG",
      "24", "WAYNESBURG",
      "15", "WAYNESBURG",
      "07", "WAYNESBURG"
  });
  
  private static final CodeSet CALL_LIST = new CodeSet(
    "CHIMNEY FIRE",
    "FIRE ALARM RESIDEN",
    "FIRE CARBON MONO",
    "FIRE FIELD",
    "FIRE STRUCTURE RES",
    "FIRE VEHICLE",
    "FIRE/ODOR INVEST",
    "MVA NO INJURY");
  
  private static final String[] MW_STREET_LIST = new String[]{
    "GRIMES RUN",
    "HUNTINGTON WOODS",
    "MT VIEW GARDENS",
    "ROY FURMAN",
    "SMITH CREEK",
    "SOUTH BRANCH MUDDY CREEK"
  };

}
