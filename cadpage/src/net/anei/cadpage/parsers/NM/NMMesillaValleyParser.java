package net.anei.cadpage.parsers.NM;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.HtmlProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;

public class NMMesillaValleyParser extends HtmlProgramParser {
  
  public NMMesillaValleyParser() {
    super("MESILLA VALLEY", "NM", 
          "COMPLETED_INCIDENT_REPORT! RESPONSE! Location:ADDRCITY! Zone:MAP! Response_Type:CALL! CreationTime:DATETIME! Priority:PRI! AlarmLevel:SKIP! SequenceNumber:ID! Status:SKIP! CALL_DETAILS! CallerName:NAME! PhoneNumber:PHONE! PhoneNumberExt:EXT! SKIP+? RESPONSE_STATE_LOGS! INFO<+",
          "tr");
  }
  
  @Override
  public String getFilter() {
    return "access@mvrda.org,5754056434@messaging.sprintpcs.com,5756402348@vtext.com";
  }
  
  private String connect;

  @Override
  protected boolean parseHtmlMsg(String subject, String body, Data data) {
    
    // Only the run reports require the HTML parser, and they can be identified
    // by the leading <STYLE> marker
    if (body.startsWith("<STYLE>")) {
      connect = "\n";
      data.msgType = MsgType.RUN_REPORT;
      if (!super.parseHtmlMsg(subject, body, data)) return false;
    }
    
    // Regular dispatch format
    else {
      if (!parseDispatchMsg(body, data)) return false;;
    }
    
    if (data.strCallId.length() > 4) data.strSource = data.strCallId.substring(0,4);
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("COMPLETED_INCIDENT_REPORT")) return new SkipField("Completed Incident Report", true);
    if (name.equals("RESPONSE")) return new SkipField("Response");
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("ID")) return new IdField("[A-Z]{4}\\d{4}-\\d{5}");
    if (name.equals("CALL_DETAILS")) return new SkipField("Call Details");
    if (name.equals("EXT")) return new MyExtField();
    if (name.equals("RESPONSE_STATE_LOGS")) return new InfoField("Response State Logs", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private class MyAddressCityField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      parseAddress(field, data, false);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY X PLACE APT";
    }
  }
  
  private class MyExtField extends PhoneField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      data.strPhone = append(data.strPhone, " ", 'X'+field);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("<|")) {
        connect = "\n";
        return;
      }
      data.strSupp = append(data.strSupp, connect, field);
      connect = "  ";
    }
  }
  
  private static final Pattern MASTER = Pattern.compile("([A-Z]{4}\\d{4}-\\d{5})(?:Pending|Dispatched|En Route|Disposed|Arrived|Clear)(.*)");

  public boolean parseDispatchMsg(String body, Data data) {
    setFieldList("ID CALL ADDR CITY X PLACE APT");
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    parseAddress(match.group(2), data, true);
    return true;
  }
  
  private static final Pattern ADDR_PTN = Pattern.compile("(.*?)(?:, *(\\d{5}))? *(?:\\((.*)\\)[# ]*(.*))?");
  private static final Pattern CALL_ADDR_PTN = Pattern.compile("(.*[a-z]) *(.*)");
  
  private void parseAddress(String field, Data data, boolean inclCall) {
    Matcher match = ADDR_PTN.matcher(field);
    if (!match.matches()) return;   // Cannot possibly happen
    String callAddr = match.group(1);
    data.strCity = getOptGroup(match.group(2));
    String cross = getOptGroup(match.group(3));
    String apt = getOptGroup(match.group(4));
    
    // Call and address are backed up against each other.  But it looks like we
    // find the break between them after the last lower case letter.
    if (inclCall) {
      match = CALL_ADDR_PTN.matcher(callAddr);
      if (match.matches()) {
        data.strCall = match.group(1);
        parseAddress(match.group(2), data);
      } else {
        parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_START_FLD_NO_DELIM | FLAG_ANCHOR_END, callAddr, data);
      }
    } else {
      parseAddress(callAddr, data);
    }
    
    // Separate near clause from cross streets
    int pt = cross.indexOf(';');
    if (pt >= 0) {
      data.strPlace = cross.substring(pt+1).trim();
      cross = cross.substring(0,pt);
    }
    cross = stripFieldStart(cross, "/");
    cross = stripFieldEnd(cross, "/");
    data.strCross = cross;
    
    // Process apt
    data.strApt = append(data.strApt, "-", apt);
  }
}
