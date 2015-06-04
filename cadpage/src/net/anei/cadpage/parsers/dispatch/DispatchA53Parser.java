package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class DispatchA53Parser extends SmartAddressParser {
  
  public DispatchA53Parser(String city, String state) {
    super(city, state);
    
    setFieldList("ID CALL ADDR APT X SRC TIME INFO");
  }
  
  private static Pattern ID_CALL = Pattern.compile(".*?CFS# *(\\d+) *- *(.*)");
  private static Pattern SRC_DISP = Pattern.compile("- ([A-Z]{3,4}) [A-Z0-9]+");
  private static Pattern TIME = Pattern.compile("(\\d{2}:\\d{2}:\\d{2}) *-{3,4} *");
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    //ID from subject... could get call too but there's a case where its incomplete (TXHelotes T2)
    Matcher mat = ID_CALL.matcher(subject);
    if (!mat.matches()) return false;
    data.strCallId = mat.group(1);
    
    //get \n\n index to split page by
    int nni = body.indexOf("\n\n");
    
    //split first line of body by commas, return false if more fields than we know what to do with
    String[] fields = body.substring(0, nni).split(",");
    if (fields.length > 4 || fields.length < 3) return false; //fail if abnormal # of fields
    
    //CALL ADDR
    data.strCall = fields[0].trim();
    parseAddress(fields[1].trim().replace('@', '&'), data);
    
    //X?
    if (fields.length == 4) data.strCross = fields[2].trim();
    
    //SRC
    mat = SRC_DISP.matcher(fields[fields.length-1].trim());
    if (!mat.matches()) return false;
    data.strSource = mat.group(1).trim();
    
    //INFO
    String trail = body.substring(nni+2);
    mat = TIME.matcher(trail);
    if (mat.find()) data.strTime = mat.group(1);
    data.strSupp = mat.replaceAll("");

    //victory!
    return true;
  }
  
}